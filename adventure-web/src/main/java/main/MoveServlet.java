package main;

import java.io.IOException;

import game.Game;
import game.Monster;
import game.Player;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
				String chara = Game.getCharacter(player.y, player.x);
				switch (chara) {
					case "goblin", "dragon" -> {
						request.setAttribute("monsterType", chara);
					}
				}
			}
		}
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
