<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 개설</title>
</head>
<body>
	<h2>계좌 개설</h2>
	<!-- 에러 메시지 표시 -->
	<c:if test="${not empty error}">
	    <p style="color:red;">${error}</p>
	</c:if>
	
	<hr>
	<form action="/bank" method="post">
	    <input type="hidden" name="action" value="create">
	    계좌번호: <input type="text" name="accountNumber"><br>
	    예금주: <input type="text" name="owner"><br>
	    <input type="submit" value="개설">
	</form>
</body>
</html>