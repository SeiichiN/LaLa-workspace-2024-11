package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
		if (itemType.equals("potion")) {
			Player player = (Player) session.getAttribute("player");
			Potion potion = null;
			List<Item> itemList = player.getItemList();
			for (Item item : itemList) {
				if (item instanceof Potion p) {
					potion = p;
				}
			}
			player.setHp(player.getHp() + potion.getRp());
			if (player.getHp() > Player.MAXHP) { player.setHp(Player.MAXHP); }
			String msg = player.getName() + "は" + potion.getType() + "を使った。";
			request.setAttribute("message", msg);
			player.getItemList().remove(potion);
		}
		
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
