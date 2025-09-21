<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
</head>
<body>
	<h2>상품 목록</h2>
	<hr>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>상품명</th>
				<th>제조사</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${productList}" varStatus="i">
			<tr>
				<td>${i.count}</td>
				<td>
					<a href="/jweb03/pcontrol?action=info&pid=${product.pid}">
						${product.pname}
					</a>
				</td>
				<td>${product.maker}</td>
				<td>${product.price}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>