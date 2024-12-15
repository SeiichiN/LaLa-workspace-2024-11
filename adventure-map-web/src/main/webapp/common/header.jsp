<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<header>
	<div class="center-align header-inn">
		<h1><a href="game">ADVENTURE GAME</a></h1>
		<p>
			プレーヤー：<c:out value="${player.name}"/><br>
			ミッション：<c:out value="${player.game.mission}"/>
		</p>
	</div>
</header>