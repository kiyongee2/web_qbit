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
	<%-- Set the variable 'num' to 11 --%>
	<c:set var="num" value="12" />
	
    <%-- Use c:choose for if-else logic --%>
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