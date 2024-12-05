<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name = (String)request.getAttribute("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>HEROの名前<%= name %></p>
	<form action="main" method="post">
		Heroの名前<br>
		<input type="text" name="name">
		<input type="submit" value="ok">
	</form>
</body>
</html>