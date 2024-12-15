package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/next")
public class NextStageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mission = request.getParameter("mission");
		if (mission.matches("[1-9]")) {
			HttpSession session = request.getSession();
			session.setAttribute("mission", mission);
			// System.out.println("mission:" + mission);
		}
		response.sendRedirect("game");
	}

}
