<%@ page import="java.util.Locale"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello~</title>
</head>
<body>
	<h2>Hello~ World!</h2>
	<h2>안녕~ 세계야~</h2>
	<hr>
	<%
		LocalDateTime now =	LocalDateTime.now();
		DateTimeFormatter formatter = 
				DateTimeFormatter.ofPattern("yyyy-MM-dd a hh:mm:ss", Locale.KOREAN);
	    //a - 오전/오후, Locale.ENGLISH - AM/PM
	    //hh-12시각제, HH-24시각제
	%>
	현재 날짜와 시간: <%= now.format(formatter) %>
</body>
</html>