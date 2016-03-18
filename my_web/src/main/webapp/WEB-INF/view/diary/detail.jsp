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
		<title>日志详情</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="日志详情">
		<link href="<%=basePath%>css/common/style.css" rel="stylesheet" />
		<style >
			.mainContent {
				background: none repeat scroll 0 0 #fff;
				display : block;
				top: 5px;
				bottom: 5px;
				left: 5px;
				right : 5px;
				position : fixed;
				z-index: 55;
				border : solid 1px #ddb233;
				overflow: auto;
				
			}
		</style>
	</head>
	<script>
	</script>
	<body>
		<div class="mainContent" >
			<div style="margin: 8px; font-size: 12px;">
				${diary.content }
			</div>
		</div>
	</body>
</html>
