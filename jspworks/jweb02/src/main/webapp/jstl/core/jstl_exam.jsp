<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실습 예제</title>
</head>
<body>
	<h2>JTSL 실습 예제</h2>
	<h3>set, out</h3>
	<c:set var="product1" value="삼성 갤럭시"></c:set>
	<c:set var="product2" value="애플 아이폰"></c:set>
	
	<p>product1: <c:out value="${product1}"></c:out></p>
	<p>product2: ${product2}</p>
	
	<h3>if</h3>
	<c:set var="checkout" value="true" />
	<c:if test="${checkout}">
		<p>주문 제품: ${product2}
	</c:if>
	
	<c:if test="${!checkout}"> <!-- value="false" 이면 실행 -->
		<p>주문 제품이 아님
	</c:if>
	
	<c:if test="${not empty product1}"> <!-- empty이면 출력안됨 -->
		<p>${product1} 이미 추가됨
	</c:if>
	
	<h3>forEach</h3>
	<!-- value="${[10, 20, 30, 40]}도 가능 -->
	<c:set var="intArray" value="${{10, 20, 30, 40}}" />
	<ul>
		<c:forEach var="num" items="${intArray}">
			<li>${num}</li>
		</c:forEach>
	</ul>
</body>
</html>