<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("uid");
	String pwd = request.getParameter("passwd");
	
	//입력없이 로그인 클릭했을때
	if(id == "" || pwd == ""){
		out.println("<script>");
		out.println("alert('아이디나 비밀번호를 입력하세요')");
		out.println("history.back()");
		out.println("</script>");
	}else{
		if(id.equals("admin") && pwd.equals("1234")){
			response.sendRedirect("loginSuccess.jsp");
		}else{
			response.sendRedirect("loginFail.jsp");
		}
	}
%>

<p>아이디: <%=id %></p>
<p>패스워드: <%=pwd %></p>