<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 개설</title>
<style>
	body { margin: 40px; }
</style>
</head>
<body>
	<h2>계좌 검색</h2>
	<!-- 에러 메시지 표시 -->
	<c:if test="${not empty error}">
	    <p style="color:red;">${error}</p>
	</c:if>
	
	<hr>
	<!-- 계좌 검색 폼 -->
	<form action="/bank" method="get">
	    <input type="hidden" name="action" value="search"/>
	    계좌번호: <input type="text" name="accountNumber"/>
	    <input type="submit" value="검색"/>
	</form>
</body>
</html>