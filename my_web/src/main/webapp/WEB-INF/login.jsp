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
<title>登录</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="登录">

<link href="/plugins/ui/sideshow/component.css" rel="stylesheet" />
<link href="/plugins/ui/sideshow/demo.css" rel="stylesheet" />

</head>
<script type="text/javascript">
	
</script>
<body style="background-color: #000;">
	<div class="container demo-1">
		<div class="content">
			<div id="large-header" class="" style="background-color: #fff;">
				<canvas id="demo-canvas"></canvas>
				<h1 class="main-title" style="display: none;">
					Connect <span class="thin">Three</span>
				</h1>
			</div>
			<nav class="codrops-demos">
			</nav>
		</div>
	</div>
	
	<!-- /container -->
	<script src="/js/assist/TweenLite.js"></script>
	<script src="/js/assist/EasePack.js"></script>
	<script src="/js/assist/rAF.js"></script>
	<script src="/js/assist/demo-1.js"></script>
</body>
</html>
