package main;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import game.Game;
import game.GameLocation;
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
				String chara = Game.getCharacter(player.getY(), player.getX());
				GameLocation gl = (GameLocation)session.getAttribute(chara);
				Monster monster = null;
				Item item = null;
				if (gl instanceof Monster) {
					monster = (Monster) gl;
				} else if (gl instanceof Item) {
					item = (Item) gl;
				}
				switch (chara) {
					case "goblin", "dragon" -> {
						request.setAttribute("monsterType", chara);
						request.setAttribute("monster", monster);
					}
					case "potion" -> {
						request.setAttribute("Item", item);
					}
				}
			}
		}
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
