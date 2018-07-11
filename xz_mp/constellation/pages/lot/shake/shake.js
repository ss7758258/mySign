
const mta = require('../../../utils/mta_analysis.js')
let $vm = getApp()
let _GData = $vm.globalData;
const { parseLot } = $vm.utils
let getUserInfo = $vm.utils.wxPromisify(wx.getUserInfo)
const bus = require('../../../event')
const Storage = require('../../../utils/storage')
const methods = require('./util')

let animation = wx.createAnimation({
    duration: 500,
    delay : 0,
    transformOrigin : 'center 85%',
    timingFunction: 'ease-in-out',
})

// 全局this
let gloThis = null
let len = 0
// 请求的定时器
let reqTimer = null

// 签的动画
let timerLot = null

// 配置参数
const conf = {
    data: {
        // 导航数据
        navConf: {
            title: '每日一签',
            state: 'root',
            isRoot: false,
            isIcon: true,
            iconPath: '',
            root: '',
            isTitle: true
        },
        bannerConf : {
            openId : '',
            appId : 'wxedc8a06ed85ce4df',
            pageNum : 1,
            pageSize : 20
        },
        // 结束摇动的时候触发
        endSpeed : false,
        // 是否为摇动状态
        shakeLotSpeed : false,
        // 来源数据
        fromPage:'',
        // 动画对象
        animationData : {},
        // 是否是长屏机
        longScreen : Storage.LongScreen
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        let self = this
        gloThis = this
        // 重置登录状态
        Storage.shakeLogin = false
        let pageFrom = options.from
        if(len === 0){
            self.shakeFun()
        }
        $vm = getApp()
        _GData = $vm.globalData
        // 调用数据分析进行统计
        methods.analytics(self,options,pageFrom,mta)
        console.log('输出参数：', options)

        this.setData({
            longScreen : Storage.LongScreen || false
        })

        // shake原型对象
        Storage.shakeSelf = self

        let handle = () => {
            console.log('登录标识')
            Storage.shakeLogin = true
            Storage.shakeSelf.setData({
                userInfo: Storage.userInfo
            })
            // 上报选择星座
            // methods.setUserInfo({ userInfo : Storage.userInfo },_GData.selectConstellation.id)
        }

		// 是否是首次注册
		if(!Storage.firstShake){
			Storage.firstShake = true
            // 监听事件
            bus.on('login-success', handle , 'login-com')
            bus.on('login-success', handle , 'shake-app')
		}

		// 如果已经存在用户信息触发登录标识
		if(Storage.userInfo){
            // 已经触发过登录不在触发
			if(Storage.shakeLogin){
				return
			}
			bus.emit('login-success', {}, 'shake-app')
		}
    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function () {
        animation.rotate(0).step()
        // 确认信封出来动画以及树停止动画
        this.setData({
            shakeLotSpeed : false,
            animationData : animation.export()
        })
        if(len === 0){
            len++
            return
        }
        // 开启加速监听
        wx.startAccelerometer()
    },

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide: function () {
        clearTimeout(timerLot)
        clearTimeout(reqTimer)
        animation.rotate(0).step()
        // 确认信封出来动画以及树停止动画
        this.setData({
            animationData : animation.export()
        })
        console.log('动画隐藏')
        wx.stopAccelerometer()
        resetLot(gloThis)
    },

    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload: function () {
        clearTimeout(timerLot)
        clearTimeout(reqTimer)
        animation.rotate(0).step()
        // 确认信封出来动画以及树停止动画
        this.setData({
            animationData : animation.export()
        })
        wx.stopAccelerometer({})
        resetLot(gloThis)
    },
    /**
     * 用户点击右上角分享
     */
    onShareAppMessage: function () {

        var shareImg = '/assets/images/share_shake.jpg'
        var shareMsg = '每日抽一签，赛过活神仙。'
        var sharepath = '/pages/lot/shake/shake?from=share&where=shake'
        return {
            title: shareMsg,
            imageUrl: shareImg,
            path: sharepath,
            success: function (res) {
                console.log('转发成功：',res)
            },
            fail: function (res) {
                // 转发失败
            }
        }
    },
    /**
	 * 打开摇到的签
	 * @param {*} e
	 */
    openEnvelope(){
        // 前往签详情页
        wx.redirectTo({
            url: '/pages/lot/lotdetail/lotdetail?fromSource=shake&lotId=' + Storage.lotId,
        })
        // 重置状态，消除信封动画
        resetLot(this)
    },
    /**
	 * 摇签按钮
	 */
    drawLots: function () {
        if(!Storage.shakeLogin || this.data.endSpeed) return
        // 上报摇签次数
        mta.Event.stat("ico_shake_shake", {})
    
        // 是否出签
        Storage.loExist = false
        // 动画重置
        this.setData({
            // 进入摇动状态
            shakeLotSpeed : true,
            // 结束摇动值重置
            endSpeed : false
        })

        // 震动
        wx.vibrateLong()
        // 震动
        wx.vibrateLong()
        // 拉取摇签数据
        getX504(this,this.data)

    },
    /**
	 * 摇签
	 */
    shakeFun: function () { // 摇一摇方法封装
        const self = this
        var numX = 0.12 //x轴
        var numY = 0.12 // y轴
        var numZ = 0.12 // z轴
        var stsw = true // 开关，保证在一定的时间内只能是一次，摇成功
        var positivenum = 0 //正数 摇一摇总数

        wx.onAccelerometerChange(function (res) { //小程序api 加速度计
            
            console.log('---------------------------------加速度：',res)
            if (numX < res.x && numY < res.y) { //个人看法，一次正数算摇一次，还有更复杂的
                positivenum++
                setTimeout(() => { positivenum = 0 }, 2000) //计时两秒内没有摇到指定次数，重新计算
            }
            if (numZ < res.z && numY < res.y) { //可以上下摇，上面的是左右摇
                positivenum++
                setTimeout(() => { positivenum = 0 }, 2000) //计时两秒内没有摇到指定次数，重新计算
            }
            if (positivenum == 1 && stsw) { //是否摇了指定的次数，执行成功后的操作
                stsw = false

                self.drawLots()
                console.log('摇一摇成功')
                wx.stopAccelerometer({})
                setTimeout(() => {
                    positivenum = 0 // 摇一摇总数，重新0开始，计算
                    stsw = true
                }, 2000)
            }
        })
        // 停止监听
        // wx.stopAccelerometer()
    },
    /**
	 * 进入一签盒
	 * @param {*} e
	 */
    showLotList: function (e) {
        if(!Storage.shakeLogin || this.data.endSpeed) return
        let formid = e.detail.formId
        mta.Event.stat("ico_shake_to_list", {})
        $vm.api.getX610({ notShowLoading: true, formid: formid })
        wx.navigateTo({
            url: '/pages/lot/lotlist/lotlist?formid=' + formid
        })
    },
    /**
	 * 打开一签盒
	 * @param {*} e
	 */
    openLotBox (){
        wx.navigateTo({
            url: '/pages/lot/aSignWall/aSignWall?fromSource=shake'
        })
    }
}

/**
 * 获取签的数据信息
 * @param {*} _self
 * @param {*} _SData
 */
const getX504 = (self,_SData) => {
    // 签的心跳
    lotBeat(self)
    
    // 获取摇签Id
    $vm.api.getX504({ notShowLoading: true, })
    .then(res => {

        reqTimer = setTimeout( () => {
            console.log('摇出的签数据：',res)
            // res.status = 1
            if (res.status === 0) {
                // 解决后台返回数据不是自己的签的问题
                res.isMyQian = 1
                // 缓存签的信息 ,解析签信息
                Storage.lotDetail = parseLot(res)
                // 是否出签
                Storage.loExist = true
                // 摇出的id
                Storage.lotId = res.id

            } else if (res.status === 1) { //没有签了
                // 是否出签
                Storage.loExist = true
                //已经没有签的情况下处理方案
                Storage.lotNot = true
                
            } else {
                // 异常状态
                Storage.lotCatch = true
            }
        },800)
    })
    .catch(err => {
        // 异常状态
        Storage.lotCatch = true
    })
}

// 签动画心跳
function lotBeat(self,num = 0){
    if(num === 0){
        animation.rotate(-5).step({duration:500})
        animation.rotate(5).step()
        self.setData({
            animationData : animation.export()
        })
    }
    // 定时动画
    timerLot = setTimeout(() =>{
        if(Storage.loExist){
            clearTimeout(timerLot)
            animation.rotate(0).step()
            
            if(Storage.lotNot){
                self.setData({
                    animationData : animation.export()
                })
                // 重置签的状态
                resetLot(self)
                
                wx.navigateTo({
                    url: '/pages/lot/emptylot/emptylot',
                })
                return 
            }
            // 确认信封出来动画以及树停止动画
            self.setData({
                animationData : animation.export(),
                endSpeed : true,
                // 结束摇动后重置
                shakeLotSpeed : false,
            })
            
            // 重置签的状态
            // resetLot(self)
            
            return
        }
        // 异常状态停止动画
        if(Storage.lotCatch){
            animation.rotate(0).step()
            // 异常后停止动画
            self.setData({
                animationData : animation.export()
            })
            
            // 重置签的状态
            resetLot(self)
            wx.showModal({
                title: '网络开小差了',
                content: '小主，请您检查网络后再试',
                showCancel: false,
                confirmText: '再试一次',
                success: function (res) { },
                fail: function (res) { },
                complete: function (res) { },
            })

            return
        }
        // 左右摇动动画
        animation.rotate(-5).step()
        animation.rotate(5).step()
        self.setData({
            animationData : animation.export()
        })
        lotBeat(self,++num)
    },1000)
}

// 重置签的状态
function resetLot(self){
    // 出签状态
    Storage.loExist = false
    Storage.lotNot = false
    Storage.lotCatch = false
    // 变更UI状态
    self.setData({
        shakeLotSpeed : false,
        endSpeed: false
    })
}
Page(conf)