<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>GAME</h1>
	<p>${game.name}</p>
	<form action="main" method="post">
		名前変更<input type="text" name="name">
		<input type="submit" value="change">
	</form>
</body>
</html>