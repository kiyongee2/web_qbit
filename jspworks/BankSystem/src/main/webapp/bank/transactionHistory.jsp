<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>거래 내역</title>
</head>
<body>
	<h2>거래 내역</h2>
	<c:if test="${empty transactions}">
		거래 내역이 없습니다.
	</c:if>
	<c:if test="${not empty transactions}">
		<table>
			<tr>
				<th>시간</th>
				<th>유형</th>
				<th>금액</th>
			<tr>
			<c:forEach var="transaction" items="${transactions}">
			<tr>
				<td>${transaction.formattedTimestamp}</td>
				<td>${transaction.type}</td>
				<td>${transaction.amount}원</td>
			</tr>
			</c:forEach>
		</table>
	</c:if>
	<a href="/bank?action=accountForm">새 계좌 개설</a>
</body>
</html>