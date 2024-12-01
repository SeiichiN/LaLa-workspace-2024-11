package main;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import game.Dragon;
import game.Game;
import game.Goblin;
import game.Player;
import game.Potion;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		if (name != null) {
			Game.playerName = name; 
			String message = "プレーヤーの名前を" + name + "に変えました。";
			request.setAttribute("message", message);
		}
		Goblin g = new Goblin("goblin");
		Dragon d = new Dragon("dragon");
		Potion po = new Potion("potion");
		Player p = new Player(Game.playerName);
		HttpSession session = request.getSession();
		session.setAttribute("goblin", g);
		session.setAttribute("dragon", d);
		session.setAttribute("potion", po);
		session.setAttribute("player", p);
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
