<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
<script src="${pageContext.request.contextPath}/static/js/jQuery.js"></script>

<script>
	function a1(){
		$.post({
			url:"${pageContext.request.contextPath}/a3",
			data:{"name": $("#name").val()},
			success:function(data){
				console.log(data);
				if(data === 'OK'){
					$("#userInfo").css("color","green");
				}
				else{
					$("#userInfo").css("color","red");
				}
				$("#userInfo").html(data);
			}
		})
	}
	function a2(){
		$.post({
			url:"${pageContext.request.contextPath}/a3",
			data:{"pwd": $("#pwd").val()},
			success:function(data){
				console.log(data);
				if(data === 'OK'){
					$("#pwdInfo").css("color","green");
				}
				else{
					$("#pwdInfo").css("color","red");
				}
				$("#pwdInfo").html(data);
			}
		})
	}
	
</script>

</head>
<body>

<p>
	帳號: <input type="text" id="name" onblur="a1()">
	<span id="userInfo"></span>
</p>

<p>
	密碼: <input type="text" id="pwd" onblur="a2()">
	<span id="pwdInfo"></span>
</p>

</body>

</html>