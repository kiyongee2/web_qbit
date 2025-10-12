<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="product" class="el2.ProductBean" />
<body>
	<div id="container">
		<h2>상품 목록</h2>
		<hr>
		<form action="selProduct.jsp" method="get">
			<select name="fruit">
				<!--  <option value="apple">사과</option>
				<option value="banana">바나나</option>
				<option value="grape">포도</option> -->
			<%
				for(String item : product.getProductList()){
					out.println(item);
				}
			%>	
			</select>
			<input type="submit" value="선택">
		</form>
	</div>
</body>
</html>