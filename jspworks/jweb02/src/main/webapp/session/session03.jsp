<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("userID");
	out.println("세션값: " + id + "<br>");
	
	//모든 세션 삭제
	session.invalidate();
	
	//out.println("세션값: " + id + "<br>");
%>
<p>세션을 삭제했습니다.</p>