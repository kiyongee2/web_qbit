<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>계좌 정보</title>
	<style>
	    body { margin: 40px; }
	    .info { margin: 15px 0; }
	    .menu a {
	        display: inline-block;
	        margin: 8px;
	        padding: 8px 15px;
	        background: #eee;
	        color: #000;
	        text-decoration: none;
	        border-radius: 5px;
	    }
	    .menu a:hover { background: #ddd; }
	</style>
</head>
<body>
    <h2>계좌 정보</h2>
    <hr>
    
    <c:if test="${empty account}">
        <p style="color:red;">계좌 정보가 없습니다.</p>
        <p><a href="/bank/main.jsp">메인으로 돌아가기</a></p>
    </c:if>

    <c:if test="${not empty account}">
        <div class="info">
            <p><b>계좌번호:</b> ${account.accountNumber}</p>
            <p><b>예금주:</b> ${account.owner}</p>
            <p><b>잔액:</b> ${account.balance} 원</p>
        </div>

        <div class="menu">
            <!-- 입금 페이지 이동 -->
            <a href="/bank/deposit.jsp?accountNumber=${account.accountNumber}">입금</a>
            <!-- 출금 페이지 이동 -->
            <a href="/bank/withdraw.jsp?accountNumber=${account.accountNumber}">출금</a>
            <!-- 거래 내역 페이지 이동 -->
            <a href="/bank?action=history&accountNumber=${account.accountNumber}">거래 내역</a>
            <!-- 메인 메뉴 -->
            <a href="/bank/main.jsp">메인으로</a>
        </div>
    </c:if>

    
</body>
</html>

