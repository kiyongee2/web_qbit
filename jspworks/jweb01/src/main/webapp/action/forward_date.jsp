<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날짜/시간</title>
</head>
<body>
	<h2>오늘의 날짜 및 시간</h2>
	<p><%=LocalDateTime.now() %></p>
</body>
</html>
