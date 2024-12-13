<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="game.Game" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADVENTURE GAME</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<header>
		<h1><a href="game">ADVENTURE GAME</a></h1>
	</header>
	<div class="container">
		<div class="main">
			<h2>MAP</h2>
			<table>
				<c:forEach var="y" begin="0" end="4" step="1">
					<tr>
					<c:forEach var="x" begin="0" end="4" step="1">
						<td>
						<c:if test="${player.y == y && player.x == x}">
							プ
						</c:if>
						</td>
					</c:forEach>
					</tr>
				</c:forEach>
			</table>
		</div><!-- .main end -->
		<div class="info">
			<h2>INFO</h2>
			<p>${chara}</p>
		</div>
		<jsp:include page="common/aside.jsp"/>
	</div><!-- .container end -->
</body>
</html>