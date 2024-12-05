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
import game.Player;
import game.Potion;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Game game = new Game();
		session.setAttribute("game", game);
		if (session.getAttribute("goblin") == null) {
			Goblin g = new Goblin("goblin", game);
			session.setAttribute("goblin", g);
		}
		if (session.getAttribute("dragon") == null) {
			Dragon d = new Dragon("dragon", game);
			session.setAttribute("dragon", d);
		}
		if (session.getAttribute("potion") == null) {
			Potion po = new Potion("potion", game);
			session.setAttribute("potion", po);
		}
		if (session.getAttribute("player") == null) {
			Player p = new Player(game);
			session.setAttribute("player", p);
		}
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		if (name != null && name.length() > 0) {
			// Game.playerName = name; 
			String message = "プレーヤーの名前を" + name + "に設定しました。";
			request.setAttribute("message", message);
			HttpSession session = request.getSession();
			Player player = (Player) session.getAttribute("player");
			player.setName(name);
		}
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}
}
