<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>欢迎</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="/css/center.css" rel="stylesheet" />
		<STYLE TYPE="text/css">
			body {
				background-color: #1999A3;
			}
		</STYLE>
	</head>
	<script type="text/javascript"
		src="<%=basePath%>js/jquery/jquery-1.8.0.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/scroll/scrollLoad.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/common/index.js"></script>
	<script type="text/javascript">
		var basePath = '<%=basePath%>';
		$(document).ready(function(){
			var bsh = document.body.scrollWidth;
			var bosh = document.body.offsetHeight;
			
			//	未曾生我谁是我,
		　　//	生我之时我是谁.
		　　//	长大成人方是我,
		　　//	合眼朦胧又是谁.
		  	//	来时欢喜去时悲,
		  	//	空在人间走一回.
		  	//	不如不来也不去,
		  	//	也无欢喜也无悲.
		  	
			//	window.setInterval(function(){
			//	$('body').css('background-image', 'url(\'<%=basePath%>img/bg/bg' + Math.round(Math.random()*17+1)+ '.jpg\')');
			//	}, 3000);
	    });
	</script>
	<body scroll=no>
			<div id="topInfoDiv" style="vertical-align: middle; display: none;" >
				<table border="0" cellpadding="0" cellspacing="0" width="98%" class="topInfoContent"  height="44px">
					<tr >
						<td width="200px">
						</td>
						<td align="left">
							<div class="navMainDiv" >
								<a href="<%=basePath%>diary/edit" target="_blank" style="display: ;">说说</a>
								<a href="<%=basePath%>diary/edit" target="_blank" style="display: none;">记事本</a>
								<a href="<%=basePath%>diary/edit" target="_blank" style="display: none;">相册</a>
								<a href="<%=basePath%>diary/edit" target="_blank" style="display: none;">聊天</a>
								<a href="<%=basePath%>diary/edit" target="_blank" style="display: none;">轻松一刻</a>
							</div>
						</td>
						<td width="200px" align="center">
							<c:if test="${LOGIN_USER == null}">
								<a href="<%=basePath%>toLogin">登录</a>
							</c:if>
							<c:if test="${LOGIN_USER != null}">
			    				欢迎您, ${LOGIN_USER.username }&nbsp;&nbsp;<a
									href="<%=basePath%>loginout">退出</a>
							</c:if>
						</td>
					</tr>
				</table>
			</div>
			<div id="mainDivBack" align="center">
				<div id="mainDiv" align="left">
					<div id="mainContentDiv">
					</div>
				</div>
			</div>
			<div id="popupShadow" class="popupShadow" style="display: none;">
			</div>
			<div id="closeBtn" class="closeBtn" style="display: none;" align="center">
				<a href="#" id="closeA" onclick="popupClose(); return false;"><span>关闭</span></a>
			</div>
			<div style="display: none;" class="diaryDetaiPopup">
				<div>
					<iframe id="diaryDetailFrame" frameborder="0" width="100%" height="700">
					</iframe>
				</div>
			</div>
			<div id="spinner" class="spinner" style="display: none;">
				<img src="<%=basePath%>img/effects/scroll/loading1.gif" alt="Spinner" />
			</div>
			<div id="loadButtonDiv">
				<a href="###" onclick="javascript:window.open('<%=basePath %>diary/edit');return;manualLoad(); return false;" style="margin-left: 14px; text-decoration: none; color: white;">更多信息..</a>
			</div>
		<script type="text/javascript">
			var spinnerState = 2;
			var sl = new ScrollLoad({
				pageSize : 1,
				pageIndex : 1,
				url : '<%=basePath%>diaries',
				interval : 30,
				bindObj : document.getElementById('mainDivBack'),
				loadType : 3,
				beforeAction : function() {
					//	$('#spinner').show();
					//	显示
					spinnerState = 1;
				},
				afterAction : function(data) {
					return;
					var rs = '';
					for(var i = 0; i < data.data.length; i++) {
						rs += createDiary(data.data[i], (this.currentIndex-2)*this.pageSize+i+1);
					}
					$('#mainContentDiv').append(rs);
					this.setTotalCount(data.totalCount);
					spinnerState = 2;
					window.setTimeout(function(){
						//	隐藏
						if(spinnerState == 2) {
							spinnerState = 0;
							//	$('#spinner').hide();
						}
					}, 1100);
					//	
				}
			});
			var manualLoad = function() {
				sl.manualLoad();
			}
			manualLoad();
			sl.run();
	</script>
	</body>
</html>
