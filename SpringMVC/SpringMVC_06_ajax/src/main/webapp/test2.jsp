<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
<script src="${pageContext.request.contextPath}/static/js/jQuery.js"></script>

<script>
	$(function(){
		$("#btn").click(function(){
			$.post("${pageContext.request.contextPath}/a2", function(data){
				console.log(data);
				var html="";
				for(let i = 0; i < data.length; i++){
					html += "<tr>" + 
					"<td>" + data[i].name + "</td>" +
					"<td>" + data[i].age + "</td>" +
					"<td>" + data[i].sex + "</td>" +
					"</tr>"
				}
				$("#content").html(html);
			})
		})
	});
</script>

</head>
<body>

<input type="button" value="載入資料" id="btn"/>
<table>
	<tr>
		<td>姓名</td>
		<td>年齡</td>
		<td>性別</td>
	</tr>
	<tbody id="content">
	
	</tbody>
</table>

</body>

</html>