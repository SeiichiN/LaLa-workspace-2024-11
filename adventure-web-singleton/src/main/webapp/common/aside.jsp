<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<aside>
	<section>
		<h3>移動</h3>
		<form action="move" method="post">
			<div class="button-area">
				<div class="up-btn btn"><button type="submit" name="direction" value="n">↑</button></div>
				<div class="lr-btn btn">
					<button type="submit" name="direction" value="w">←</button>
					<button type="submit" name="direction" value="e">→</button>
				</div>
				<div class="down-btn btn"><button type="submit" name="direction" value="s">↓</button></div>
			</div><!-- .button-area -->
		</form>
	</section>
	<section>
		<h3>状態</h3>
		<p>HP:<c:out value="${player.hp}"/></p>
	</section>
	<section>
		<h3>持ち物</h3>
		<c:choose>
			<c:when test="${empty player.inventory}">
				<p>なし</p>
			</c:when>
			<c:otherwise>
				<form action="use" method="post">
					<c:forEach var="item" items="${player.inventory}">
						<input type="radio" name="item" value="${item.type}">${item.type}
					</c:forEach>
					<div>
						<input type="submit" value="使う">
						<input type="reset" value="取消">
					</div>
				</form>
			</c:otherwise>
		</c:choose>
	</section>
	<c:if test="${empty player.name}">
		<section>
			<h3>初期設定</h3>
			<form action="game" method="post">
				<p>
					プレーヤーの名前を決めてください。<br>
					<input type="text" name="name">
				</p>
				<p><input type="submit" value="決定"></p>
			</form>
		</section>
	</c:if>
</aside>
