package forward.dispatch;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dispatch/second")
public class SecondServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//브라우저로 응답하기
		response.setContentType("text/html; charset=utf-8");
		
		//쿼리스트링 데이터 받기
		String name = request.getParameter("name");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("RequestDispatcher를 이용한 포워딩 실습입니다.");
		out.println("이름: " + name + "<br>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
