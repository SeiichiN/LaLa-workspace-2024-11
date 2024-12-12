package main;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import game.Game;
import game.Item;
import game.Player;
import game.Potion;

@WebServlet("/take")
public class TakeItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String choice = request.getParameter("choice");
		String type = request.getParameter("type");
		if ((choice == null || choice.length() == 0) ||
			(type == null || type.length() == 0)) {
			response.sendRedirect("/main");
			return;
		}
		if (choice.equals("take")) {
			HttpSession session = request.getSession();
			Item item = null;
			if (type.equals("potion")) {
				item = new Potion("potion");
			}
			Player player = (Player) session.getAttribute("player");
			player.getInventory().add(item);
			String msg = item.getType() + "を袋に入れた。";
			request.setAttribute("message", msg);
			Game game = player.getGame();
			game.getMap()[player.getY()][player.getX()] = ".";
			
			// if (item instanceof Potion potion) {
				// player.setHp(player.getHp() + potion.getRp());
				// if (player.getHp() > player.MAXHP) { player.setHp(player.MAXHP); }
				// String msg = player.getName() + "はHPを回復した。";
			// }
		}
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
