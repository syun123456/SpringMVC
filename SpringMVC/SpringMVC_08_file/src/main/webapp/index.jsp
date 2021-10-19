<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
	<title>FileUpload</title>
</head>
<body>
<h2>FileUpload</h2>

<%-- 通過表單上傳文件 
	 get:上傳的檔案有大小限制
	 post:上傳的檔案沒有大小限制
--%>
<form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
	<input type="file" name="file"/>
	<input type="submit" value="upload"/>
</form>

<a href="${pageContext.request.contextPath}/statics/test.jpg">下載圖片</a>

</body>
</html>
