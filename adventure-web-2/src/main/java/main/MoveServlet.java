package main;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import game.Dragon;
import game.Game;
import game.Goblin;
import game.Monster;
import game.Player;

@WebServlet("/move")
public class MoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = request.getParameter("direction");
		// System.out.println(s);
		String direction = request.getParameter("direction").trim();
		switch (direction) {
			case "w","e","n","s" -> {
				HttpSession session = request.getSession();
				Player player = (Player)session.getAttribute("player");
				String msg = player.move(direction);
				request.setAttribute("message", msg);
				Game game = player.getGame();
				String chara = game.getCharacter(player.getY(), player.getX());
				// Monster backMonster = player.getBackMonster();
				switch (chara) {
					case "goblin" -> {
						request.setAttribute("monsterType", chara);
						Goblin goblin = null;
						if (player.getBackMonster() == null) {
							goblin = new Goblin("goblin");
							player.setBackMonster(goblin);
						} else {
							Monster m = player.getBackMonster();
							if (m instanceof Goblin g) {
								goblin = g;
							}
						}
						player.setMonster(goblin);
					}
					case "dragon" -> {
						request.setAttribute("monsterType", chara);
						Dragon dragon = null;
						if (player.getBackMonster() == null) {
							dragon = new Dragon("dragon");
							player.setBackMonster(dragon);
						} else {
							Monster m = player.getBackMonster();
							if (m instanceof Dragon d) {
								dragon = d;
							}
						}
						player.setMonster(dragon);
					}
					case "potion" -> {
						// String msg = chara + "がある！";
						// request.setAttribute("message", msg);
						request.setAttribute("item", "potion");
					}
				}
			}
		}
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}


}
