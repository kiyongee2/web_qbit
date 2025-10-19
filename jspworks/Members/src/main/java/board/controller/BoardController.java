package board.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import board.model.Board;
import board.service.BoardService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
		HttpSession session = request.getSession(); //세션 생성
		
		if("boardList".equals(action)) { //목록 보기
			List<Board> boardList = service.getBoardList();
			request.setAttribute("boardList", boardList);
			nextPage = "/board/boardList.jsp";
		}else if("writeForm".equals(action)) { //글쓰기 페이지
			nextPage = "/board/write.jsp";
		}else if("write".equals(action)) { //글쓰기 처리
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String mid = request.getParameter("mid");
			
			Board board = new Board();
			board.setTitle(title);
			board.setContent(content);
			board.setMid(mid);
			
			service.addBoard(board); //등록 메서드 호출
			//글쓰기 후 글 목록으로 이동
			response.sendRedirect("/board?action=boardList");
			return;
		}else if("detail".equals(action)) { //글 상세보기
			int bnum = Integer.parseInt(request.getParameter("bnum"));
			Board board = service.getBoard(bnum);
			
			request.setAttribute("board", board);
			nextPage = "/board/detail.jsp";
		}else if("delete".equals(action)) {
			int bnum = Integer.parseInt(request.getParameter("bnum"));
			service.deleteBoard(bnum);
			response.sendRedirect("/board?action=boardList");
			return;
		}else if("updateForm".equals(action)) {
			int bnum = Integer.parseInt(request.getParameter("bnum"));
			request.setAttribute("board", service.getBoard(bnum));
			nextPage = "/board/updateForm.jsp";
		}
		
		//포워딩
		RequestDispatcher rd =
				request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
}
