<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<h3>初期設定</h3>
		<form action="game" method="post">
			<p>
				プレーヤーの名前を決めてください。<br>
				<input type="text" name="name">
			</p>
			<p><input type="submit" value="決定"></p>
		</form>
	</section>
</aside>
