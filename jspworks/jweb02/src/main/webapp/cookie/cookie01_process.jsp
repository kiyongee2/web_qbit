<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("passwd");
	
	if(id.equals("today") && pw.equals("1234")){
		Cookie cookieId = new Cookie("userId", id);
		Cookie cookiePw = new Cookie("userPw", pw);
		
		response.addCookie(cookieId);
		response.addCookie(cookiePw);
		
		out.println("쿠키 생성이 성공했습니다.");
	}else{
		out.println("쿠키 생성이 실패했습니다.");
	}

%>