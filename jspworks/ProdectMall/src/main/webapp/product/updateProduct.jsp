<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상품 수정</title>
	<link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
	<section id="container">
		<h2>상품 수정</h2>
		<form action="/product?action=update" method="post">
			<ul>
				<li>
					<label>상품 코드</label>
					<input type="text" name="pid" value="${product.pid}">
				</li>
				<li>
					<label>상품명</label>
					<input type="text" name="pname" value="${product.pname}">
				</li>
				<li>
					<label>제조사</label>
					<input type="text" name="maker" value="${product.maker}">
				</li>
				<li>
					<label>가격</label>
					<input type="number" name="price" value="${product.price}">
				</li>
				<li>
					<label>등록일</label>
					<input type="date" name="regdate" value="${product.regdate}">
				</li>
			</ul>
			<p>
				<input type="submit" value="수정">
				<input type="reset" value="취소">
				<a href="/product?action=list">
					<button type="button">목록</button>
				</a>
			</p>
		</form>
	</section>
</body>
</html>