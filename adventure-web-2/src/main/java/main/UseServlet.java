package main;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import game.Item;
import game.Player;
import game.Potion;

@WebServlet("/use")
public class UseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String itemType = request.getParameter("item");
		if (itemType == null || itemType.length() == 0) {
			response.sendRedirect("game");
			return;
		}
		HttpSession session = request.getSession();
		Item item = (Item) session.getAttribute(itemType);
		if (itemType.equals("potion")) {
			if (item instanceof Potion potion) {
				Player player = (Player) session.getAttribute("player");
				player.setHp(player.getHp() + potion.getRp());
				if (player.getHp() > player.MAXHP) { player.setHp(player.MAXHP); }
				String msg = player.getName() + "は" + item.getType() + "を使った。";
				request.setAttribute("message", msg);
				player.getInventory().remove(potion);
			}
		}
		
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
