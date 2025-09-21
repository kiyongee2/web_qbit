<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과일 목록</title>
</head>
<body>
    <!-- array -->
    ${names[0]}<br>

    <!-- list -->
    ${fruit[0]}
	<c:forEach var="fruit" items="${fruits}">
	    ${fruit}
	</c:forEach>
	<br>
	
	<!-- map -->
	모델명: ${cars.brand}<br>
	연식: ${cars.year}<br>
</body>
</html>