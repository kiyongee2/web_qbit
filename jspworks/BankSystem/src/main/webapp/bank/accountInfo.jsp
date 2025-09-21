<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>계좌 정보</title> 
</head>
<body>
	<h2>계좌 정보</h2>
	계좌번호: ${account.accountNumber} <br>
	예금주: ${account.owner} <br>
	잔액: ${account.balance} 원 <br>
	
	<!-- 에러 메시지 표시 -->
	<c:if test="${not empty error}">
	    <p style="color:red;">${error}</p>
	</c:if>
	<hr>

	<h3>입금</h3>
	<form action="bank" method="post">
	    <input type="hidden" name="action" value="deposit">
	    <input type="hidden" name="accountNumber" value="${account.accountNumber}">
	    금액: <input type="number" name="amount"><br>
	    <input type="submit" value="입금">
	</form>
	
	<h3>출금</h3>
	<form action="bank" method="post">
	    <input type="hidden" name="action" value="withdraw">
	    <input type="hidden" name="accountNumber" value="${account.accountNumber}">
	    금액: <input type="number" name="amount"><br>
	    <input type="submit" value="출금">
	</form>
	
	<hr>
	<a href="bank?action=history&accountNumber=${account.accountNumber}">거래 내역 보기</a>
</body>
</html>
