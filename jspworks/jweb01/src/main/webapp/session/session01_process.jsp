<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("id");
    String userPw = request.getParameter("passwd");
    
    if(userId.equals("khit") && userPw.equals("1234")){
    	session.setAttribute("userID", userId);
    	out.println("세션이 발급되었습니다.");
    }else{
    	out.println("<script>");
		out.println("alert('아이디나 비밀번호를 입력하세요')");
		out.println("history.back()");
		out.println("</script>");
    }
%>

<p><%=session.getAttribute("userID") %>님이 로그인한 상태입니다.<p>