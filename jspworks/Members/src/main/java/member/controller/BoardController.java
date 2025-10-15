package member.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.model.Board;
import member.service.BoardService;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BoardService service = new BoardService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String nextPage = "";
		
		if("boardList".equals(action)) {
			List<Board> boardList = service.getBoardList();
			request.setAttribute("boardList", boardList);
			nextPage = "/board/boardList.jsp";
		}else if("writeForm".equals(action)) {
			nextPage = "/board/write.jsp";
		}
		
		RequestDispatcher rd =
				request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
}
