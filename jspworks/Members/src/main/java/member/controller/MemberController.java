package member.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import member.model.Member;
import member.service.MemberService;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberService service = new MemberService(); //인스턴스 생성

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String nextPage = "";
		HttpSession session = request.getSession(); //세션 객체 생성
		
		if(action.equals("list")) {
			List<Member> memberList = service.getMemberList();
			request.setAttribute("memberList", memberList);
			nextPage = "/member/memberList.jsp";
		}else if(action.equals("addForm")) {
			nextPage = "/member/addForm.jsp";
		}else if(action.equals("add")) {
			String mid = request.getParameter("mid");
			String pwd = request.getParameter("passwd");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			
			Member member = new Member();
			member.setMid(mid);
			member.setPasswd(pwd);
			member.setName(name);
			member.setGender(gender);
			
			service.addMember(member); //addMember() 호출
			//회원 가입후 아이디 세션 발급
			session.setAttribute("sessionId", mid); 
			
			//등록 후 목록 페이지로 이동
			response.sendRedirect("/member?action=list");
			return;  //즉시 종료
		}else if(action.equals("loginForm")) {
			nextPage = "/member/login.jsp";
		}else if(action.equals("login")) {
			String id = request.getParameter("mid");
			String pw = request.getParameter("passwd");
			
			Member member = new Member();
			member.setMid(id);
			member.setPasswd(pw);
			
			boolean result = service.checkLogin(member);
			if(result) {
				//아이디 세션 발급
				session.setAttribute("sessionId", id); 
				response.sendRedirect("/member?action=list");
				return;
			}else {
				String error = "아이디나 비밀번호가 일치하지 않습니다.";
				request.setAttribute("error", error);
				nextPage = "/member/login.jsp";
			}
		}else if(action.equals("logout")) {
			session.invalidate();
			nextPage = "index.jsp";
		}else if(action.equals("info")) {
			String mid = request.getParameter("mid");
			
			Member member = service.getMember(mid);
			request.setAttribute("member", member);
			nextPage = "/member/memberInfo.jsp";
		}else if(action.equals("delete")) {
			String mid = request.getParameter("mid");
			
			service.deleteMember(mid);
			//삭제후 회원 목록 이동
			response.sendRedirect("/member?action=list");
			return;
		}else if(action.equals("updateForm")) {
			String mid = request.getParameter("mid");
			Member member = service.getMember(mid);
			request.setAttribute("member", member);
			nextPage = "/member/updateForm.jsp";
		}
		
		//포워딩
		RequestDispatcher rd = 
				request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
