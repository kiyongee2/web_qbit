<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<style type="text/css">
	#container{width: 80%; margin: 30px auto;}
</style>
</head>
<jsp:useBean id="product" class="product.Product" />
<body>
	<div id="container">
	<h2>상품 목록</h2>
	<hr>
	<form action="selProduct.jsp" method="get">
		<select name="select">
			<%--<%
				for(String product : product.getProductList()){
					out.println("<option>" + product + "</option>");
				}
			--%>
			<c:forEach var="product" items="${product.productList}">
				<option>${product}</option>
			</c:forEach>
		</select>
		<input type="submit" value="선택">
	</form>
	</div>
</body>
</html>