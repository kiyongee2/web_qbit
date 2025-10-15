<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>거래 내역</title>
	<style>
		body { margin: 40px; }
	</style>
</head>
<body>
	<h2>거래 내역</h2>
    <hr>
    <p>계좌번호: ${account.accountNumber}</p>
    <p>예금주: ${account.owner}</p>
    <p>잔액: ${account.balance}원</p>
    <br>

    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>거래번호</th>
            <th>유형</th>
            <th>금액</th>
            <th>일시</th>
        </tr>
        <c:forEach var="tr" items="${transactions}">
            <tr>
                <td>${tr.id}</td>
                <td>${tr.type}</td>
                <td>${tr.amount}원</td>
                <td>${tr.timestamp}</td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <a href="/bank?action=search&accountNumber=${account.accountNumber}">계좌 정보</a>
</body>
</html>