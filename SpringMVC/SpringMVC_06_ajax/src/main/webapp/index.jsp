<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Title</title>
<script src="${pageContext.request.contextPath}/static/js/jQuery.js"></script>
<%-- 後臺實際取的name是script裡面的name參數的值--%>
<script>
	function a(){
		$.post({
			url:"${pageContext.request.contextPath}/a1", <%-- 發起請求的地址--%>
			data:{"name":$("#username").val()},          <%-- 協帶數據--%>
			success:function(data, status){				 <%-- data為接收後端回傳的數據--%>
				console.log("data: " + data);
				console.log("status: " + status);
			}
			
		})
	}
</script>

</head>
<body>
<%-- 失去焦點(onblur)觸發a()--%>
用戶名: <input type="text" id="username" onblur="a()"/>

</body>

</html>