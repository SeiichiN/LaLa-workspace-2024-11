package servlet;

import java.io.IOException;

import game.Player;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/retry")
public class RetryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String retry = request.getParameter("retry");
		HttpSession session = request.getSession();
		if (retry.equals("yes")) {
			Player player = (Player) session .getAttribute("player");
			int mission = player.getGame().getMission();
			String number = String.valueOf(mission);
			session.setAttribute("mission", number);
		} else {
			session.removeAttribute("player");
		}
		response.sendRedirect("game");
	}

}