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
import game.NotEnter;
import game.Player;
import game.Potion;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Player player = (Player) session.getAttribute("player");
		if (player == null) {
			Game game = new Game();
			setCharacter(game);
			player = new Player(game);
			session.setAttribute("player", player);
		}
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	private void setCharacter(Game game) {
		game.setLocation("goblin");
		game.setLocation("dragon");
		game.setLocation("potion");
		game.setLocation("ether");
		game.setLocation("Gold");
		game.setLocation("#");
		game.setLocation("#");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		if (name == null || name.length() == 0) {
			response.sendRedirect("game");
			return;
		}
		String message = "プレーヤーの名前を" + name + "に設定しました。";
		request.setAttribute("message", message);
		HttpSession session = request.getSession();
		Player player = (Player) session.getAttribute("player");
		player.setName(name);
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}
}