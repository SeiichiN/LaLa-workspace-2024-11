package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import game.Dragon;
import game.Ether;
import game.Game;
import game.Goblin;
import game.Gold;
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
			player = new Player("", game);
		} else {
			String num = (String) session.getAttribute("mission");
			Game game = null;
			switch (num) {
				case "1" -> {
					System.out.println("num:" + num + " retry!");
					game = new Game();
					setCharacter(game);
				}
				case "2" -> {
					System.out.println("num:" + num + " mission2!");
					int ysize = 8;
					int xsize = 8;
					int reward = 50;
					int amount = 300;
					int mission = Integer.parseInt(num);
					game = new Game(ysize, xsize, reward, amount, mission);
					setCharacter(game);
				}
			}
			player.setHp(player.MAXHP);
			player.setGame(game);
		}
		session.setAttribute("player", player);
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	private void setCharacter(Game game) {
		if (game.getMission() > 0) {
			new NotEnter(game);
			new NotEnter(game);
			new Goblin("goblin", "棍棒で殴りかかった", 10, game);
			new Dragon("dragon", "口から炎を噴き出した", 30, game);
			new Potion("potion", game);
			new Ether("ether", game);
			for (int i = 0; i < 5; i++) {
				new Gold("Gold", game);
			}
		}
		if (game.getMission() > 1) {
			new NotEnter(game);
			new NotEnter(game);
			new Goblin("goblin", "斧で斬りつけた", 20, game);
			new Dragon("dragon", "鋭い歯で噛みついた", 25, game);
			new Potion("potion", game);
			new Potion("potion", game);
		}
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
