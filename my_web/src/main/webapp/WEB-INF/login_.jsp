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
		<link href="/css/style.css" rel="stylesheet" />
		<link href="/css/login.css" rel="stylesheet" />
		<link href="/css/common/hover-min.css" rel="stylesheet" />
		<script type="text/javascript" src="/js/jquery/jquery-1.8.0.min.js"></script>
		<script type="text/javascript" src="/js/scroll/scrollLoad.js"></script>
		<script type="text/javascript" src="/js/common/index.js"></script>
</head>
	<script type="text/javascript">
		var login = function(){
			document.loginform.submit();
		}
		var refreshVerifyCode = function() {
			document.getElementById('verifyCodeImg').src = '<%=basePath%>verifyCode?dt=' + new Date().getTime();
		}
		if(top.location != location){  
			top.location.reload();
		}
  </script>
	<body style="background-color: #0E0E0E;">
		<div id="backgroudDiv">
			<div style="">
			</div>
		</div>
		<div id="loginOrRegister" class="loginOrRegister" style="display: block;">
			<div align="center" id="loginTable" style="margin-top: 20px;">
				<form action="<%=basePath%>login" method="post" name="loginform">
					<table border="0" cellspacing="0" cellpadding="2" width="400"
						height="160" style="border-collapse: collapse; font-size: 12px;">
						<tr height="36">
							<td colspan="3" align="center">
								<div style="color: red;">
									<c:if test="${loginState == 1}">
				    					登录成功!
				    				</c:if>
												<c:if test="${loginState == 3}">
				    					用户名或密码错误!
				    				</c:if>
												<c:if test="${loginState == 5}">
				    					验证码错误!
				    				</c:if>
								</div>
							</td>
						</tr>
						<tr height="30">
							<td align="right" width="100">
								用户名
							</td>
							<td colspan="2">
								<div class="inputDiv">
									<input class="inputText" type="text" name="username" id="username" value=""
									style="width: 180px;" />
								</div>
							</td>
						</tr>
						<tr height="30">
							<td align="right">
								密 码
							</td>
							<td colspan="2">
								<div class="inputDiv">
									<input class="inputText" type="password" name="password" id="password" value=""
									style="width: 180px;" />
								</div>
							</td>
						</tr>
						<tr height="30">
							<td align="right">
								验证码
							</td>
							<td colspan="2" align="left">
								<ul style="list-style:none; margin:0px; margin-left: -40px;" id="verifyCodeUl">
									<li style="float: left;">
										<div class="inputCodeDiv">
											<input  class="inputText" type="text" name="verifyCode" id="verifyCode" size="4"
												maxlength="4" style="width: 45px;" />
										</div>
									</li>
									<li style="float: left; margin-left: 6px;">
										<img id="verifyCodeImg" onclick="refreshVerifyCode();"
											style="vertical-align: middle; margin-top: 2px;"/>
									</li>
									<li style="float: left; margin-left: 6px; line-height: 25px;" >
										<span style="margin-top: 15px;">
											<a href="#" onclick="refreshVerifyCode(); return false;">看不清？</a>
										</span>
									</li>
								</ul>
									<script type="text/javascript">refreshVerifyCode();</script>
							</td>
						</tr>
						<tr height="76">
							<td colspan="3">
								<div style="margin-left: 150px;">
									<input type="submit" style="display: none;">
									<a href="javascript:login();" class="hvr-ripple-out">&nbsp;&nbsp;&nbsp;登&nbsp;&nbsp;录&nbsp;&nbsp;&nbsp;</a>
									<span style="margin-left: 15px; margin-top: 10px;">
										<a href="#">注 册</a>
									</span>
								</div>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</body>
</html>
