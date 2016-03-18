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
		<title>滚动加载</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>
	<style>
		.post {
			border:1px solid gray; line-height: 25px;
		}
		#spinner {
			background: none repeat scroll 0 0 #000000;
		    border-radius: 8px;
		    bottom: 40px;
		    color: #ffffff;
		    height: 36px;
		    opacity: 1;
		    padding: 10px;
		    position: fixed;
		    width: 106px;
		    z-index: 5000;
		}
	</style>
	<script type="text/javascript"
		src="<%=basePath%>js/jquery/jquery-1.8.0.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/scroll/scrollLoad.js"></script>
	<body>
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		a
		<br />
		<div id="posts">
		</div>
		<div id="spinner" class="spinner" style="display: none; font-size: 12px; vertical-align: middle;">
			<img style="vertical-align: middle;" src="<%=basePath%>img/effects/scroll/spinner.gif" alt="Spinner"> 
			<span style="vertical-align: middle;">加载中... </span>
		</div>
		<div style="border: solid 1px red; margin-bottom: 200px; display: none;" align="center">
			<input type="button" value=" 更多信息 " onclick="manualLoad();" style="line-height: 30px;" width="80" />
		</div>
	</body>
	<script type="text/javascript">
		var sl = new ScrollLoad({
			pageSize : 10,
			pageIndex : 0,
			//	totalCount : 200,
			url : '<%=basePath%>effects/getData',
			interval : 10,
			ignoreInterval : 0,
			autoLoad : true,
			beforeAction : function() {
			
			    var wih = window.innerHeight;
			    var wiw = window.innerWidth;
			    var bst = document.body.scrollTop;
			    
			    var ow = $("#spinner").width();
				var oh = $("#spinner").height();
			    
			    var left = (wiw - ow) / 2;
			    var top = bst + (wih - oh) / 2;
				$("#spinner").css('position', 'absolute');
				$('#spinner').css('left', left);
				$('#spinner').css('top', top);
				$('#spinner').show();
			},
			afterAction : function(data) {
				$('#spinner').hide();
				$('#posts').append(data.data);
				this.setTotalCount(data.totalCount);
			}
		});
		sl.run();
		var manualLoad = function() {
			sl.manualLoad();
		}
	</script>
</html>
