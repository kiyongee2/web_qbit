<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl - core</title>
</head>
<body>
	<%-- 변수 num에 12를 저장 --%>
	<c:set var="num" value="12" />
	
	<!-- 1. c:if문 사용 -->
	<c:if test="${num % 2 == 0}">
		<c:out value="${num}는(은) ${'짝수입니다.'}" />
	</c:if>
	<c:if test="${num % 2 == 1}">
		<c:out value="${num}는(은) ${'홀수입니다.'}" />
	</c:if>
	
	<!-- c:choose문 사용 -->
	<c:choose>
		<c:when test="${num % 2 == 0 }">
			${num}는(은) 짝수입니다.
		</c:when>
		<c:otherwise>
			${num}는(은) 홀수입니다.
		</c:otherwise>
	</c:choose>
</body>
</html>