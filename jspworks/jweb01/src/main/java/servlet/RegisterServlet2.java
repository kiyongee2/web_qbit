package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet("/register2") //http://localhost:8080/register
public class RegisterServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8"); //한글 깨짐(인코딩 설정)
		
		//요청 입력값 받기
		String name = request.getParameter("uname");
		String email = request.getParameter("email");
		String[] subject = request.getParameterValues("subject"); 
		
		//응답 설정
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html><html>");
		out.println("<head><title>회원 가입</title></head>");
		out.println("<body><h2>회원 등록 결과</h2><hr>");
		out.println("<p>이름: " + name + "</p>");
		out.println("<p>이메일: " + email + "</p>");
		for(String subj : subject) {
			out.println("<p>선택한 과목: " + subj + "</p>");
		}
		out.println("<a href='/servlet/register.jsp'>다시 입력</a>");
		out.println("</body></html>");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
