<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상품 목록</title>
	<style>
		body{margin: 20px;}
		h2{
			border-bottom: 2px solid #ccc;
			padding-bottom: 10px;	
		}
		table{
			border: 1px solid #ccc;
			border-collapse: collapse;
		}
		table th, td{
			border: 1px solid #ccc;
			padding: 5px 10px;
		}
	</style>
</head>
<body>
	<section id="container">
		<h2>상품 목록</h2>
		<table>
			<thead>
				<tr>
					<th>번호</th><th>상품명</th><th>제조사</th><th>가격</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${productList}" varStatus="i">
				<tr>
					<td>${i.count}</td>
					<td>
						<a href="/jweb04/pcontrol?action=info&pid=${product.pid}">
							${product.pname}
						</a>
					</td>
					<td>${product.maker}</td>
					<td>${product.price}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
</body>
</html>