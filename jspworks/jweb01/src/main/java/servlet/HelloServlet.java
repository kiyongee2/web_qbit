package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet("/hello") // URL 패턴 매핑 (http://localhost:8080/프로젝트명/hello)
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답 컨텐츠 타입 설정(type, 한글인코딩)
		response.setContentType("text/html; charset=UTF-8");
		
		//출력 스트림
		PrintWriter out = response.getWriter();
		
		//HTTP 응답
		out.println("<!DOCTYPE html><html>");
		out.println("<head><title>Hello Servelt</title></head>");
		out.println("<body><h2>Hello Servlet!</h2><hr>");
		out.println("현재 날짜와 시간은 " + LocalDateTime.now());
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

