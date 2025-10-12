package forward.dispatch;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dispatch/first") 
public class FirstServlet2 extends HttpServlet { //클래스 이름이 중복되지 않게 함
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		//경로는 first이고 데이터(name)만 파라미터로 전달함
		RequestDispatcher rd = 
				request.getRequestDispatcher("second?name=김기용"); 
		rd.forward(request, response);  //URL은 first를 유지함
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
