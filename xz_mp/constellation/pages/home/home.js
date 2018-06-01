// pages/home/home.js
const $vm = getApp()
const _GData = $vm.globalData
const api = $vm.api
var mta = require('../../utils/mta_analysis.js')
const {
	parseIndex
} = $vm.utils
Page({

	/**
	 * 页面的初始数据
	 */
	data: {

		isLoading: false,
		selectBack: false,
		showHome: false,
		hasAuthorize: true,
		signList: $vm.utils.constellation,
		selectStatus: {
			selected: false,
			current: -1
		},
		pageFrom: null,
		myConstellation: {},
		remindToday: '',
		myLuck: [
			{
				name : '爱情运',
				count : 1,
				color : '#9262FB'
			},
			{
				name : '升值运',
				count : 2,
				color : '#DA6AE4'
			},
			{
				name : '暴富运',
				count : 3,
				color : '#B3B4FF'
			},
			{
				name : '健康运',
				count : 4,
				color : '#88BB74'
			}
		],
		timer: null,
		xiaodaka: {
			appId: 'wx855c5d7718f218c9',
			path: '/pages/index/index?wxID=ad6377&scene=gzhgl922689',
			openType: 'navigate',
			extra: '',
			txt: '打卡',
			version: 'release'
		},
		navConf : {
			title : '今日运势',
			state : 'root',
			isRoot : true,
			isIcon : true,
			iconPath : '',
			root : '',
			isTitle : true,
			centerPath : '/pages/center/center'
		}
	},


	selectSign: function (e) {
		const _self = this
		const _SData = this.data

		const selectConstellation = e.detail.target.dataset.item
		mta.Event.stat('ico_home_select', { 'constellation': selectConstellation.name })
		_GData.selectConstellation = selectConstellation
		wx.setStorage({
			key: 'selectConstellation',
			data: e.detail.target.dataset.item,
		})
		_self.setData({
			myConstellation: selectConstellation,
			selectBack: false,
			showHome: true,
			'selectStatus.current': selectConstellation.id - 1,
			'selectStatus.selected': true
		})
		_self.onShowingHome()
	},

	onShowingHome: function () {
		const _self = this
		const _SData = this.data
		$vm.api.getSelectx100({
			constellationId: _GData.selectConstellation.id,
			nickName: _GData.userInfo.nickName,
			headImage: _GData.userInfo.avatarUrl,
			notShowLoading: true,
		}).then(res => {
			console.log(res)
			var myLuck = parseIndex(res)
			this.setData({
				myLuck: myLuck,
				remindToday: res.remindToday ? res.remindToday : ''
			})
			if (!_self.goPage(_SData)) {
				const myLuckLen = myLuck.length
				_self.circleDynamic()();
				// for (let i = 0; i < myLuckLen; i++) {
				//   _self.circleDynamic(i)()
				// }
			}


		}).catch(err => {
			console.log(err)
		})

	},

	/**
	 * 生命周期函数--监听页面加载
	 */
	onLoad: function (options) {
		mta.Page.init()
		const _self = this
		const _SData = this.data
		const selectConstellation = _GData.selectConstellation
		if (selectConstellation) {
			_self.setData({
				myConstellation: selectConstellation,
				selectBack: false,
				showHome: true
			})
			_self.onShowingHome()
		} else {
			_self.setData({
				showHome: false
			})
		}

		console.log('输出参数：', options)
		let fromwhere = options.from
		let to = options.to
		if (fromwhere == 'share' || fromwhere == 'activity') {
			_self.setData({
				toPage: to,
				pageFrom: fromwhere
			})
			if (to == 'brief') {
				if (options.hotapp == 1) {
					mta.Event.stat("ico_in_from_brief_qrcode", {})
				} else {
					mta.Event.stat("ico_in_from_brief", {})
				}

			} else if (to == 'today') {
				if (options.hotapp == 1) {
					mta.Event.stat("ico_in_from_today_qrcode", {})
				} else if (fromwhere == 'activity') {
					console.log('ico_in_from_brief_activity')
					mta.Event.stat("ico_in_from_brief_activity", {})
				} else {
					mta.Event.stat("ico_in_from_today", {})
				}

			}
		}

		wx.getUserInfo({
			success: function (res) {
				console.log(res)
				if (res.userInfo) {
					wx.setStorage({
						key: 'userInfo',
						data: res.userInfo,
					})
					_self.setData({
						hasAuthorize: true,
						'navConf.iconPath' : res.userInfo.avatarUrl
					})
					_GData.userInfo = res.userInfo
					$vm.api.getSelectx100({
						constellationId: _GData.selectConstellation.id,
						nickName: res.userInfo.nickName,
						headImage: res.userInfo.avatarUrl,
						notShowLoading: true,
					}).then(res => {

					})
				}
			},
			fail: function (res) {
				// 查看是否授权
				wx.getSetting({
					success: function (res) {
						if (!res.authSetting['scope.userInfo']) {

							_self.setData({
								hasAuthorize: false
							})
							wx.redirectTo({
								url: '/pages/checklogin/checklogin?from=' + fromwhere + '&to=' + to
							})
							// if (fromwhere == 'share') {
							//   wx.showToast({
							//     title: '请先同意授权',
							//     icon: 'none',
							//     mask: true,
							//   })
							// }
						}
					}
				})
			}
		})


	},

	/**
	 * 生命周期函数--监听页面初次渲染完成
	 */
	onReady: function () {

	},

	/**
	 * 生命周期函数--监听页面显示
	 */
	onShow: function () { },

	/**
	 * 生命周期函数--监听页面隐藏
	 */
	onHide: function () {

	},

	/**
	 * 生命周期函数--监听页面卸载
	 */
	onUnload: function () {

	},

	/**
	 * 页面相关事件处理函数--监听用户下拉动作
	 */
	onPullDownRefresh: function () {

	},

	/**
	 * 页面上拉触底事件的处理函数
	 */
	onReachBottom: function () {

	},

	/**
	 * 用户点击右上角分享
	 */
	onShareAppMessage: function (res) {
		if (res.from = 'menu') {
			mta.Event.stat("ico_from_home", {})
		}

		return {
			title: '小哥星座，准的无话可说',

			success: function (res) {
				// 转发成功
			},
			fail: function (res) {
				// 转发失败
			}
		}
	},

	goPage: function (_SData) {
		console.log('===============')
		var shouldGo = false
		if (_SData.pageFrom == 'share') {
			// if (_SData.toPage == 'today') {
			//   wx.navigateTo({
			//     url: '/pages/today/today?from=share'
			//   })
			// } 
			// else
			if (_SData.toPage == 'brief') {
				wx.navigateTo({
					url: '/pages/onebrief/brief?from=share'
				})
			}
			shouldGo = true
		}
		return shouldGo
	},

	tween: function (t, b, c, d) {
		return c * t / d + b;
	},
	//圈圈的动态
	circleDynamic: function (n) {

		const _self = this
		const _SData = this.data
		const myLuckList = _SData.myLuck
		let keys = [], counts = [];

		myLuckList.forEach((v, ind) => {
			keys.push('myLuck[' + ind + '].count');
			counts.push(myLuckList[ind].count);
		});

		let t = 0, b = 0, d = 15;

		function price() {
			if (!_self.data.showHome) {
				return
			}
			t++
			if (t > d) {
				return
			} else {
				keys.forEach((v, ind) => {
					_self.setData({
						[v]: Math.floor(_self.tween(t, b, counts[ind], d))
					})
				})
			}
			let temp = setTimeout(price, 15);

			_self.setData({
				timer: temp
			})

		}
		return price
	},

	onClickConstellation: function () {

		clearTimeout(this.data.timer ? this.data.timer : '');
		mta.Event.stat("ico_home_unselect", {})
		wx.setStorage({
			key: 'selectConstellation',
			data: null,
		})
		_GData.selectConstellation = null
		this.setData({
			selectBack: true,
			showHome: false,
			'selectStatus.current': -1,
			'selectStatus.selected': false
		})

	},
	bindGetUserInfo: function (e) {


		if (e.detail.userInfo) {
			wx.setStorage({
				key: 'userInfo',
				data: e.detail.userInfo,
			})
			this.setData({
				hasAuthorize: true
			})
			_GData.userInfo = e.detail.userInfo
			$vm.api.getSelectx100({
				nickName: e.detail.userInfo.nickName,
				headImage: e.detail.userInfo.avatarUrl,
				notShowLoading: true,
			}).then(res => {

			})
		}

	},
	onelot: function (e) {
		const _self = this
		if (_self.data.isLoading) {
			return
		}
		_self.setData({
			isLoading: true
		})
		let formid = e.detail.formId
		$vm.api.getX610({
			notShowLoading: true,
			formid: formid
		})
		mta.Event.stat("ico_home_to_shake", {})
		wx.navigateTo({
			url: '/pages/lot/shakelot/shake?formid=' + formid,
			complete: function (res) {
				_self.setData({
					isLoading: false
				})
			}
		})
	},
	oneword: function (e) {

		let formid = e.detail.formId
		$vm.api.getX610({
			notShowLoading: true,
			formid: formid
		})
		mta.Event.stat("ico_home_to_brief", {})
		wx.navigateTo({
			url: '/pages/onebrief/brief?formid=' + formid
		})
	},
	today: function (e) {
		let formid = e.detail.formId
		$vm.api.getX610({
			notShowLoading: true,
			formid: formid
		})
		mta.Event.stat("ico_home_to_today", {})
		wx.navigateTo({
			url: '/pages/today/today?formid=' + formid
		})
	}
})