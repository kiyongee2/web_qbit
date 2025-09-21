<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mvc-el언어</title>
</head>
<body>
	<h2>데이터 받기</h2>
	<p>현재 계절: ${season}
	<p></p>4계절 :
		${seasons[0]}, ${seasons[1]}, ${seasons[2]}, ${seasons[3]}
		
	<!-- list -->
    <p>과일: ${fruits[0]}
    <p>과일 장바구니:
	<c:forEach var="fruit" items="${fruits}">
	    ${fruit}
	</c:forEach>
	<br>
	
	<!-- map -->
	<p>모델명: ${cars.brand}
	<p>연식: ${cars.year}
</body>
</html>