<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>登入頁面</h1>

<form action="${pageContext.request.contextPath}/user/login" method="post">
	帳號: <input type="text" name="username"/>
	密碼: <input type="text" name="password"/>
		 <input type="submit" value="登入"/>
</form>

</body>
</html>