<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>입금</title>
</head>
<body>
    <h2>입금</h2>
    <!-- 에러 메시지 출력 -->
    <c:if test="${not empty error}">
        <p style="color:red;">${error}</p>
    </c:if>
    
    <form action="/bank" method="post">
        <input type="hidden" name="action" value="deposit" />
        계좌번호: <input type="text" name="accountNumber" 
        			value="${param.accountNumber}" readonly /><br/>
        금액: <input type="number" name="amount" /><br/>
        <button type="submit">입금하기</button>
    </form>

    
</body>
</html>
