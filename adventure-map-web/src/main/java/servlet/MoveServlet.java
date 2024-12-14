package servlet;

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
import game.SetOnMap;

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
				SetOnMap soMapObj = player.getGame().getMap()[player.getY()][player.getX()];
				if (soMapObj != null) {
					String chara = soMapObj.toString();
					switch (chara) {
						case "goblin" -> {
							request.setAttribute("monsterType", chara);
							request.setAttribute("monster", soMapObj);
						}
						case "dragon" -> {
							request.setAttribute("monsterType", chara);
							request.setAttribute("monster", soMapObj);
						}
						case "potion" -> {
							request.setAttribute("item", soMapObj);
						}
						case "ether" -> {
							request.setAttribute("item", soMapObj);
						}
						case "Gold" -> {
							request.setAttribute("item", soMapObj);
						}
					}
				}
			}
		}
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}


}
