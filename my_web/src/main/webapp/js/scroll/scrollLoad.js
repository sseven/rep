/**
 * @author maos
 * @created 2014-7-16 下午02:11:48
 */
ScrollLoad = function(config) {

	var sl = this;
	this.pageSize = config.pageSize || 0;
	this.currentIndex = config.currentIndex || 1;
	this.url = config.url || '';
	//	请求前执行
	this.beforeAction = config.beforeAction || this.beforeAction;
	//	请求成功后执行
	this.afterAction = config.afterAction || this.afterAction;
	//	总记录数
	this.totalCount = config.totalCount || -1;
	//	距离底部距离, 开始load
	this.interval = config.interval || 10;
	//	忽略底部距离, 不执行load.
	this.ignoreInterval = config.ignoreInterval || 0;
	//	1 未请求, 2 请求中, 3 请求完成, 4 请求失败
	this.requestState = 1;
	this.bindObj = config.bindObj;
	//	1 滚动, 2 触发,
	this.loadType = config.loadType || 3;
	
}

ScrollLoad.prototype = {

	constructor : ScrollLoad,
	
	calcIndex : function() {
		this.currentIndex += 1;
	},
	setTotalCount : function(c) {
		this.totalCount = c;
	},
	setAutoLoad : function(i) {
		this.autoLoad = i;
	},
	setCurrentIndex : function(i) {
		this.currentIndex = i;
	},
	setPageSize : function(i) {
		this.pageSize = i;
	},
	beforeAction : function() {
		return true;
	},
	afterAction : function(data) {
	},
	isReached : function() {
		var bsh = this.bindObj.scrollHeight;
	    //	var boh = this.bindObj.offsetHeight;
	    //	this.bindObj.style.top
	    var wih = (window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight);
	    var bst = this.bindObj.scrollTop || document.documentElement.scrollTop;
	    //	console.info(bsh + ' ' + wih + ' ' + bst);
	    return (bsh - wih - bst - this.ignoreInterval < this.interval || this.loadType == 2);
	},
	load : function() {
		if(sl.requestState != 2 && this.isReached()) {
			if(this.totalCount == -1 || this.totalCount > this.currentIndex + 1) {
				//	返回false不执行
				if(this.beforeAction() !== false) {
					sl.requestState = 2;
					$.ajax({
				          type: "GET",
				          url: this.url + "?pageSize=" + this.pageSize + "&currentIndex=" + this.currentIndex + '&datetime=' + new Date().getTime(),
				          dataType: 'json',
				          timeout: 3000,
				          success: function(data) {
				          			sl.requestState = 3;
				          			sl.calcIndex();
				          			sl.afterAction(data);
				          			sl.requestState = 1;
				          	  	},
				          failure : function() {
				          		sl.requestState = 4;
				          }
			          });
		         }
	         }
        }
	},
	manualLoad : function() {
		
		this.loadType = 2;
		sl.load();
	},
	run : function() {
		//	scrollLoad 注册触发事件
		this.bindObj.onscroll = function() {
			sl.loadType = 1;
			sl.load();
		};
	}
}