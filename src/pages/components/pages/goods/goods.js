const API = require('../../../../utils/api')
const Storage = require('../../../../utils/storage')
const mta = require('../../../../utils/mta_analysis')
const util = require('../../../../utils/util')
let img = '/assets/images/share-banner.png'
Page({
  data: {

    navConf: {
      title: ' 精选好物',
      state: 'root',
      isRoot: false,
      isIcon: true,
      root: '',
      isTitle: true,
      bg: '#fff',
      color: 'black',
      fontColor: 'black',
      showContent: false,
    },
    IPhoneX : false,
    // 默认高度
    height: 64,
    cdn:'https://xingzuo-1256217146.file.myqcloud.com',
    list:[],
    result:[],
     // 是否无数据
     noList : false,
     // 是否存在下一页
     hasNext : true,
     nextPage : 1
  },
  onLoad() {
    mta.Page.init()
    this._getGoodsList()
  },
  onShareAppMessage(){
    return {
      path : 'pages/home/home?from=share&to=goods'
    }
  },
  // 前往商品详情
  goExc(e){
    let {res} = e.currentTarget.dataset
    mta.Event.stat('page_goods_click',{id:res.id})
    console.log(res)
    wx.navigateTo({
			url:'/pages/components/pages/goodsInfo/goodsInfo?id=' + res.id
		})
  },

  // 下一页数据
  _nextList(){
    mta.Event.stat('page_goods_next',{})
    console.log('进入下一页')
    if(!this.data.hasNext){
        return
    }
    this._getGoodsList(++this.data.nextPage)
  },

  // 获取商品列表
  _getGoodsList(page = 1){

    API.getGoodslist({startpage : page,testnum:1 ,type:1,pageSize:10}).then(res => {
        console.log('新品专区列表',res)
        if(!res){
            return
        }
        if(!res.goods){
          return
        }
        let list = []
        let ls = res.goods

        console.log(ls)
        console.log('页码：',page)
        
        if(page === 1){
            list = ls || []
        }else{
            list = this.data.list.concat(ls || [])
        }
        this.setData({
            list
        })
    }).catch(err => {
        console.log(err)
    })

    API.getGoodslist({startpage : page,testnum:1 ,type:0,pageSize:10}).then(res => {
      console.log('推荐专区列表',res)
      if(!res){
          return
      }
      if(!res.goods){
        return
      }
      
      let result = []
      let lstmp = res.goods

      console.log(lstmp)
      console.log('页码：',page)
      
      if(page === 1){
          result = lstmp || []
      }else{
          result = this.data.result.concat(lstmp || [])
      }
      this.setData({
          result,
          imgs : [],
          hasNext : res.hasnextpage
      })
    }).catch(err => {
        console.log(err)
    })
},

  // 获取导航栏高度
  _setHeight(e) {
    let temp = e.detail || 64 
    this.setData({
      height: temp,
      IPhoneX : temp === 64 ? false : true
    })
  },
  /**
     * 上报formId
     * @param {*} e
     */
  _reportFormId(e) {
    console.log(e.detail.formId)
    let formid = e.detail.formId
    API.getX610({ notShowLoading: true, formid: formid })
  }
})