<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL-반복문</title>
</head>
<body>
	<h2>구구단(5단)</h2>
	<c:set var="dan" value="5" />
	<c:forEach var="i" begin="1" end="9">
		${dan} x ${i} = ${dan*i}<br>
	</c:forEach>
	<p>-----------------------------</p>
	
	<h2>구구단 전체</h2>
	<c:forEach var="i" begin="2" end="9">
		[${i}] 단<br>
		<c:forEach var="j" begin="1" end="9">
			${i} x ${j} = ${i*j}<br>
		</c:forEach>
		<br>
	</c:forEach>
</body>
</html>










