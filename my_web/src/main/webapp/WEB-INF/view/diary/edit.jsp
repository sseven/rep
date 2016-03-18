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
		<title>日志编辑</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="日志编辑">
		<link href="<%=basePath%>css/common/style.css" rel="stylesheet" />
		<link rel="stylesheet" href="<%=basePath%>plugins/editor/themes/default/default.css" />
		<link rel="stylesheet" href="<%=basePath%>plugins/editor/themes/simple/simple.css" /> 
		<script charset="utf-8" src="<%=basePath%>plugins/editor/kindeditor.js"></script>
		<script charset="utf-8" src="<%=basePath%>plugins/editor/lang/zh_CN.js"></script>
	</head>
	<script>
		var editor;
        KindEditor.ready(function(K) {
                var options = {
				        cssPath : '<%=basePath%>plugins/editor/plugins/code/prettify.css',
				        //	filterMode : true,
				        uploadJson : '<%=basePath%>editorUpload',
				        fileManagerJson : '<%=basePath%>editor/fileManager',
                		allowFileManager : true,
                		extraFileUploadParams: {
					        user_id: '${LOGIN_USER.id}'
					    }
				};
				editor = K.create('#centent', options);
        });
        var diaryFormSubmit = function() {
        	editor.sync();
        	//	alert(document.getElementById('centent').value);
        	document.forms["diaryForm"].submit();
        }
	</script>
	<body>
		<div align="center" style="margin-top: 80px;">
			<div id="mainDiv" align="left">
				<form action="<%=basePath%>diary/saveDiary" method="post" name="diaryForm">
					<div style="margin-top: 50px;">
						<div style="margin-left: 50px;">
							<input value="" type="text" name="title" id="title" style="width:400px; font-size: 12px;" class="editBox"/>
						</div>
						<div style="margin-left: 50px; margin-top: 5px;">
							<textarea id="centent" name="content" style="width:860px;height:500px;">
								&lt;strong&gt;HTML内容&lt;/strong&gt;
							</textarea>
						</div>
						<div align="center" style="margin-top: 20px;">
							<input value="提 交" onclick="diaryFormSubmit();" type="button" style="line-height: 28px; width: 80px;"/>
						</div>
					</div>
				</form>
			</div>
		</div>
</html>
