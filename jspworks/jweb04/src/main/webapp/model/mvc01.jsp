<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>변수, 배열</h3>
	<p>현재 계절: ${season}</p>
	<p>현재 계절 : ${seasons[2]}</p>
	<p>전체 계절</p>
	<c:forEach var="season" items="${seasons}">
		${season} <br>
	</c:forEach>
	<hr>
		
	<h3>리스트(List)</h3>
    <p>과일: ${fruits[0]}
    <p>과일 장바구니:
	<c:forEach var="fruit" items="${fruits}">
	    ${fruit}
	</c:forEach>
	<hr>
	
	<h3>맵(Map)</h3>
	<p>모델명: ${cars.brand}
	<p>연식: ${cars.year}
</body>
</html>