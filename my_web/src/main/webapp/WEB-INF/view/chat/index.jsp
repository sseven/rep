<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<title>chat</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=basePath%>css/common/style.css" rel="stylesheet" />
		<STYLE TYPE="text/css">
			BODY {background-image: URL(<%=basePath%>img/bg/bg8.jpg);
			background-position: center;
			background-repeat: no-repeat;
			background-attachment: fixed;}
		</STYLE>
	</head>
	<script type="text/javascript"
		src="<%=basePath%>js/jquery/jquery-1.8.0.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/webSocket/socket.io.js"></script>
	<script type="text/javascript">
	</script>
	<body scroll=no>
		<script type="text/javascript">
			var socket = io.connect('http://localhost:888/easy/');
			socket.on('news', function (data) {
				console.log(data);
				socket.emit('my other event', { my: 'data' });
			});
		</script>
	</body>
</html>
