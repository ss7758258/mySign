// pages/onebrief/brief.js
const $vm = getApp()
const _GData = $vm.globalData
const getImageInfo = $vm.utils.wxPromisify(wx.getImageInfo)
var mta = require('../../utils/mta_analysis.js')
const Storage = require('../../utils/storage')
const dev=require('../../config.js')
Page({

	/**
	 * 页面的初始数据
	 */
	data: {
		picUserName: '',//用户昵称
		isFromShare: false, //未调用
		prevPic: "",
		isShow: false,
		navConf: {
			title: '一言',
			state: 'root',
			isRoot: false,
			isIcon: true,
			iconPath: '',
			root: '',
			isTitle: true
		},
		isIPhoneX : false,
        current:0,//当前滑块
        isFirst:false, //是否是第一次进来
        list:false,//页面渲染数据
        tomorrow:{
            year:false,
            month:false,
            day:false,
            hour:false,
            minute:false,
            sec:false,
            timer:true,
        }
	},

	/**
	 * 生命周期函数--监听页面加载
	 */
	onLoad: function (options) {
		getSystemInfo(this)
		wx.showLoading({
			title: '加载中...',
		})
		mta.Page.init()
		wx.hideShareMenu({
			success: function (res) { },
			fail: function (res) { },
			complete: function (res) { },
		})
		var fromwhere = options.from
		// console.log(options)
		if (fromwhere == 'share') {
			this.setData({
			  	// isFromShare: true,
				"navConf.root": '/pages/home/home'
			})
		}
		// let env = 'dev';
		// const _self = this
		// if(!Storage.prevPic){
		// 	$vm.api.getDayx400({ notShowLoading: true })
		// 	.then((res) => {
		// 		console.log(res)
		// 		if (res) {
		// 			_self.setData({
		// 				prevPic:
		// 					res.prevPic ? "https://xingzuo-1256217146.file.myqcloud.com" + (env === 'dev' ? '' : '/prod') + res.prevPic :
		// 						"",
		// 			})
		// 		} else {
		// 			_self.setData({
		// 				networkError: true,
		// 				prevPic: "/assets/images/loading.png",
		// 			})
		// 		}
		// 		wx.hideLoading()
		// 	}).catch((err) => {
		// 		wx.hideLoading()
		// 		wx.showToast({
		// 			icon: 'none',
		// 			title: '加载失败了，请小主稍后再试',
		// 		})
		// 	})
		// }else{
		// 	_self.setData({
		// 		prevPic:Storage.prevPic
		// 	})
		// }
		
	},

    onShow(){
        let isFirst = wx.getStorageInfoSync('isFirst'); //判断是否是第一次进来
        console.log('onshow',isFirst)
        if (!isFirst) {
            this.setData({
                isFirst: true
            })
        }

        this.getwordlist()
        this.gettomorrow()
        this.countdown()
    },
	/**
	 * 用户点击右上角分享
	 */
	onShareAppMessage: function () {
		return {
			path: '/pages/onebrief/brief?from=share&to=brief',
			success: function (res) {
				// 转发成功
			},
			fail: function (res) {
				// 转发失败
			},
		}
	},

	/**
	 * 保存图片
	 */
	saveSelect: function (e) {
        console.log('eeeeeeeee',e)
		let formid = e.detail.formId
        let img = e.currentTarget.dataset.img
		$vm.api.getX610({ notShowLoading: true, formid: formid })
		mta.Event.stat("ico_brief_save", {})
		const _self = this
		const _SData = _self.data
		wx.showLoading({
			title: '图片生成中...',
			mask: true,
		})
		_self.setData({
			showCanvas: true,
		})
		$vm.utils.Promise.all([
			getImageInfo({
				src: img,
			})
			
		]).then((res) => {
			console.log(res)
			const ctx = wx.createCanvasContext('shareCanvas')
			ctx.setFillStyle('white')
			ctx.fillRect(0, 0, 375, 667)
			ctx.drawImage(res[0].path, 0, 0, 375, 375.0 / res[0].width * res[0].height)

			ctx.setTextAlign('center') // 文字居中
			ctx.setFillStyle('#333333') // 文字颜色：黑色
			ctx.setFontSize(12) // 文字字号：22px
			ctx.fillText(_GData.userInfo.nickName, 375 / 2, 570 / 2)
			ctx.stroke()
			const qrImgSize = 100
			ctx.drawImage('/assets/images/qrcodebrief.png', (375 - qrImgSize) / 2, 518, qrImgSize, qrImgSize)
			ctx.stroke()
			ctx.setTextAlign('center') // 文字居中
			ctx.setFillStyle('#333333') // 文字颜色：黑色
			ctx.setFontSize(12) // 文字字号：22px
			ctx.fillText("来自一言", 375 / 2, 631 + 12)

			ctx.draw()
			setTimeout(function () {
				wx.canvasToTempFilePath({
					canvasId: 'shareCanvas',
					success: function (res) {
						console.log(res.tempFilePath)
						wx.saveImageToPhotosAlbum({
							filePath: res.tempFilePath,
							success(res) {
								wx.hideLoading()
								wx.showModal({
									title: '保存成功',
									content: '图片已经保存到相册，可以分享到朋友圈了',
									showCancel: false,
								})
								_self.setData({
									showCanvas: false,
								})
								// wx.hideLoading()
							},
							fail() {
								wx.showToast({
									title: '图片保存失败，请检查右上角关于小哥星座的设置中查看是否开启权限',
									icon: 'none',
									duration: 3000
								})
								_self.setData({
									showCanvas: false,
								})
							}
						})
					},
					fail: function (res) {
						console.log(res)
						wx.showToast({
							title: '图片保存失败，请检查右上角关于小哥星座的设置中查看是否开启权限',
							icon: 'none',
							duration: 3000
						})
						_self.setData({
							showCanvas: false,
						})
						// wx.hideLoading()
					},
				})
			}, 1000)
		})
		.catch((err) => {
			wx.hideLoading()
            console.log('保存图片错误信息',err)
			wx.showToast({
				icon: 'none',
				title: '加载失败了，请检查网络',
			})
		})
	},
	onLodingListener: function (e) {
		console.log('图片加载完成时：', e)
		wx.hideLoading()
		const _self = this
		if (e.detail.height && e.detail.width) {
			_self.setData({
				picUserName: _GData.userInfo.nickName,
				// 开启图片展示
				isShow: true,
			})
		}
	},

	/**
	 *
	 * 图片加载失败
	 */
	errorOpen(){
		let self = this
		$vm.api.getDayx400({ notShowLoading: true })
		.then((res) => {
			console.log(res)
			wx.hideLoading()
			if (res) {
				self.setData({
					prevPic:
						res.prevPic ? "https://xingzuo-1256217146.file.myqcloud.com" + (env === 'dev' ? '' : '/prod') + res.prevPic :
							"",
				})
			} else {
				self.setData({
					networkError: true,
					prevPic: "/assets/images/loading.png",
				})
			}
		}).catch((err) => {
			wx.hideLoading()
			wx.showToast({
				icon: 'none',
				title: '加载失败了，请小主稍后再试',
			})
		})
	},
	onclickHome: function (e) {
		mta.Event.stat("ico_brief_home", {})
		let formid = e.detail.formId
		$vm.api.getX610({ notShowLoading: true, formid: formid })
		wx.reLaunch({
			url: '/pages/home/home',
		})
	},
    // 上报formid
    formid(e){
        let isFirst = wx.getStorageInfoSync('key')
        console.log(isFirst)
        if (!isFirst){
            wx.setStorageSync('isFirst',false)
            this.setData({
                isFirst: false
            })
        }
        
        $vm.api.getX610({ formid: e.detail.formId})
    },
    
    // 获取一言列表数据
    getwordlist(){
        let self=this
        $vm.api.wordlist({ constellationId: _GData.selectConstellation.id, startpage:1}).then(res=>{
            
            let url = 'https://xingzuo-1256217146.file.myqcloud.com' + (dev === 'dev' ? '' : '/prod')
            res.wordlist.forEach(function(value){
                value.prevPic = url + value.prevPic
            })
            
            res.wordlist.push({  //添加明日展示
                prevPic:false
            })
            
            console.log('获取一言数据:', res)
            this.setData({
                list:res.wordlist,
                current:res.wordlist.length-2
            })
            

        }).catch(res=>{
            console.log('获取一言错误信息',res)
            wx.showToast({
                title: '抱歉,您的网络有点问题请稍后重启',
                icon: '',
                image: '',
                duration: 0,
                mask: true,
                success: function(res) {},
                fail: function(res) {},
                complete: function(res) {},
            })
        })
    },

    // 获取明日数据
    gettomorrow(){
        let monthE = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November','December']
        let b = new Date(new Date().getTime() + 60 * 60 * 24 * 1000)
        let year = b.getFullYear()
        let month = monthE[b.getMonth()]
        let day = b.getDate()>9?b.getDate():'0'+b.getDate()

        let c = new Date(new Date().toLocaleDateString()).getTime() + 60 * 60 * 24 * 1000 //下一天0点时刻时间戳
        let tomorrow=c-new Date().getTime()
        let tomorrow_timer = new Date(tomorrow-8*60*60*1000)
        let hour = tomorrow_timer.getHours() 
        let minute = tomorrow_timer.getMinutes()
        let sec = tomorrow_timer.getSeconds()
        console.log(`日期：${b},年：${year},月：${month},日：${day},倒计时：${hour}:${minute}:${sec}`)
        this.setData({
            'tomorrow.year':year,
            'tomorrow.month':month,
            'tomorrow.day':day,
            'tomorrow.hour':hour,
            'tomorrow.minute':minute,
            'tomorrow.sec':sec
        })  
    },

    // 明日倒计时
    countdown(){
        let self=this
        let hour=this.data.tomorrow.hour
        let minute=this.data.tomorrow.minute
        let sec=this.data.tomorrow.sec
        let timer=setInterval(function(){
            // clearInterval(timer)
            self.setData({
                'tomorrow.sec': sec--
            })
            console.log(sec)
            if(sec < -1){
                self.setData({
                    'tomorrow.minute': minute-1,
                    'tomorrow.sec': 59
                })
                sec=58,minute-=1
            }else if(minute < 0){
                self.setData({
                    'tomorrow.hour':hour-1,
                    'tomorrow.minute': 59,
                })
                minute=58,hour-=1
            }else if(hour == 0 && minute == 0  && sec == 0){
                clearInterval(timer)
                self.setData({
                    'tomorrow.timer':false
                })
            }
        },1000)
    },

    // 更多好玩
    moregame(e){
        $vm.api.getX610({ formid: e.detail.formId })
        wx.navigateTo({
            url: '/pages/banner/banner'
        })
    }
})

/**
 * 获取系统比例加入比例标识
 * @param {*} self
 */
function getSystemInfo(self){
	let res = wx.getSystemInfoSync();
	console.log('设备信息：',res);
	if(res){
		// 长屏手机适配
		if(res.screenWidth <= 375 && res.screenHeight >= 750){
			self.setData({
				isIPhoneX : true
			})
		}
	}
}