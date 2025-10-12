<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 선택</title>
<style>
	#container{width: 80%; margin: 0 auto; text-align: center;}
</style>
</head>
<%
	//세션 발급
	String username = request.getParameter("username");
	//out.println(username); 
	session.setAttribute("sessionName", username);

%>
<section id="container">
	<h2>상품 선택</h2>
	<hr>
	<p><b>[<%=session.getAttribute("sessionName") %>]</b>님 환영합니다.</p>
	<form action="addProduct.jsp" method="post">
		<select name="product">
			<option value="사과">사과</option>
			<option value="바나나">바나나</option>
			<option value="포도">포도</option>
		</select>
		<button type="submit">추가</button>
	</form>
	<p>
		<button onclick="location.href='cart.jsp'">장바구니</button>
	</p>
</section>
</body>
</html>