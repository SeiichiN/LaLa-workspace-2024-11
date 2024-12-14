package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import game.Game;
import game.Gold;
import game.Item;
import game.Player;
import game.Potion;
import game.SetOnMap;

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
			Player player = (Player) session.getAttribute("player");
			SetOnMap soMapObj = player.getGame().getMap()[player.getY()][player.getX()];
			if (soMapObj != null) {
				String msg = null;
				if (soMapObj instanceof Item item) {
					player.getItemList().add(item);
					msg = item.getType() + "を袋に入れた。";
				} else if (soMapObj instanceof Gold gold) {
					player.setGold(gold.getGold());
					msg = gold.getType() + "を" + gold.getGold() + "手に入れた。";
				}
				request.setAttribute("message", msg);
				player.getGame().getMap()[player.getY()][player.getX()] = null;
			}
		}
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
