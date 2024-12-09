package main;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import game.Game;
import game.Item;
import game.Monster;
import game.Player;

@WebServlet("/move")
public class MoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = request.getParameter("direction");
		System.out.println(s);
		String direction = request.getParameter("direction").trim();
		switch (direction) {
			case "w","e","n","s" -> {
				HttpSession session = request.getSession();
				Player player = (Player)session.getAttribute("player");
				player.move(direction);
				Game game = (Game) session.getAttribute("game");
				String chara = game.getCharacter(player.getY(), player.getX());
				switch (chara) {
					case "goblin", "dragon" -> {
						Monster m = (Monster) session.getAttribute(chara);
						request.setAttribute("monsterType", chara);
						request.setAttribute("monster", m);
					}
					case "potion" -> {
						Item item = (Item) session.getAttribute("potion");
						String msg = item.getType() + "がある！";
						request.setAttribute("message", msg);
						request.setAttribute("item", item);
					}
				}
			}
		}
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
