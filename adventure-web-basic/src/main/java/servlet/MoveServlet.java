package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import game.Game;
import game.Player;

@WebServlet("/move")
public class MoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Player player = (Player) session.getAttribute("player");
		if (player == null) {
			response.sendRedirect("game");
			return;
		}
		String dir = request.getParameter("dir");
		player.move(dir);
		String chara = Game.map[player.getY()][player.getX()];
		System.out.println(chara);
		request.setAttribute("chara", chara);
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
