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
import game.Item;
import game.Monster;
import game.Player;
import game.Potion;

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
				Game game = player.getGame();
				String chara = game.getCharacter(player.getY(), player.getX());
				switch (chara) {
					case "goblin" -> {
						request.setAttribute("monsterType", chara);
						session.setAttribute("monster", new Goblin("goblin"));
					}
					case "dragon" -> {
						request.setAttribute("monsterType", chara);
						session.setAttribute("monster", new Dragon("dragon"));
					}
					case "potion" -> {
						String msg = chara + "がある！";
						request.setAttribute("message", msg);
						request.setAttribute("item", "potion");
					}
				}
			}
		}
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
