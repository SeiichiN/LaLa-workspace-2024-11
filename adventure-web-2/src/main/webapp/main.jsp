<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<% 
String player_ch = "プ"; 
pageContext.setAttribute("player_ch", player_ch);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="common/header.jsp"/>
	<div class="container center-align">
		<section>
			<h3>MAP</h3>
			<table>
				<c:forEach var="y" begin="0" end="4" step="1">
					<tr>
					<c:forEach var="x" begin="0" end="4" step="1">
						<td>
							<span class="player-ch">
							<c:if test="${player.y == y && player.x == x}">
								<c:out value="${player_ch}"/>
							</c:if>
							</span>
						</td>
					</c:forEach>
					</tr>
				</c:forEach>
			</table>
		</section>
		<section>
			<h3>INFO</h3>
			<c:if test="${not empty message}">
				<p><c:out value="${message}"/></p>
			</c:if>
			<c:if test="${not empty monsterType}">
				<p><c:out value="${monsterType}"/>が現れた。</p>
			</c:if>
			<c:if test="${not empty playerMsgList}">
				<ul>
				<c:forEach var="playerMsg" items="${playerMsgList}">
					<li><c:out value="${playerMsg}"/></li>
				</c:forEach>
				</ul>
			</c:if>	
			<c:if test="${not empty monsterMsgList}">
				<ul>
				<c:forEach var="monsterMsg" items="${monsterMsgList}">
					<li><c:out value="${monsterMsg}"/></li>
				</c:forEach>
				</ul>
			</c:if>
			<c:if test="${not empty item}">
				<form action="take" method="post">
					<input type="hidden" name="type" value="${item}">
					<button type="submit" name="choice" value="take">拾う</button>
					<button type="submit" name="choice" value="not-take">そのまま</button>
				</form>
			</c:if>
			<c:if test="${not empty monsterType}">
				<p>プレーヤー：${player.hp} ${monsterType}:${monster.hp}</p>
				<c:if test="${player.hp > 0}">
					<form action="buttle" method="post">
						<input type="hidden" name="type" value="${monsterType}">
						<button type="submit" name="choice" value="fight">戦う</button>
						<button type="submit" name="choice" value="run">逃げる</button>
					</form>
				</c:if>
			</c:if>
			<c:if test="${player.hp < 0}">
				<p class="game-over">GAME OVER</p>
			</c:if>
				
		</section>
		<jsp:include page="common/aside.jsp"/>
	</div>
	<jsp:include page="common/footer.jsp"/>
	<script src="js/get_key.js"></script>
</body>
</html>