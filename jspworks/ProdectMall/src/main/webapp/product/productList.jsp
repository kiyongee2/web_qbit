<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상품 목록</title>
	<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<section id="container">
		<h2>상품 목록</h2>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>상품명</th>
					<th>제조사</th>
					<th>가격</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${productList}" varStatus="i">
				<tr>
					<td>${i.count}</td>
					<td>
						<a href="/product?action=info&pid=${product.pid}">
							${product.pname}
						</a>
					</td>
					<td>${product.maker}</td>
					<td>${product.price}</td>
					<td>${product.regdate}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<p><a href="/product?action=addForm">상품 등록</a></p>
	</section>
</body>
</html>