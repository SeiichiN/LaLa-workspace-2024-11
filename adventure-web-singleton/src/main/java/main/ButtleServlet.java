package main;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import game.Monster;
import game.Player;

@WebServlet("/buttle")
public class ButtleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String choice = request.getParameter("choice");
		String monsterType = request.getParameter("type");
		List<String> playerMsgList = new ArrayList<>();
		HttpSession session = request.getSession();
		Player player = (Player) session.getAttribute("player");
		switch (choice) {
		case "fight" -> {
			Monster monster = (Monster) session.getAttribute(monsterType);
			playerMsgList = player.attack(monster);
			if (monster.getHp() <= 0) break;
			List<String> monsterMsgList = monster.attack(player);
			request.setAttribute("monsterMsgList", monsterMsgList);
			request.setAttribute("monsterType", monsterType);
			request.setAttribute("monster", monster);
		}
		case "run" -> {
			playerMsgList.add(player.getName() + "は逃げ出した。");
		}
		default -> {
			response.sendRedirect("game");
			return;
		}
		}
		request.setAttribute("playerMsgList", playerMsgList);
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
