<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>首頁</h1>

<span>Hello  ${userLoginInfo}</span>

<p><a href="${pageContext.request.contextPath}/user/logout">登出</a></p>

</body>
</html>