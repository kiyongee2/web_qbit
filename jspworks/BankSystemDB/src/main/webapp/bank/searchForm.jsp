<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>계좌 조회</title>
	<style>
		body { margin: 40px; }
	</style>
</head>
<body>
    <h2>계좌 조회</h2>
    <form action="bank" method="get">
        <input type="hidden" name="action" value="info">
        계좌번호: <input type="text" name="accountNumber"><br/>
        <button type="submit">조회</button>
    </form>
</body>
</html>
