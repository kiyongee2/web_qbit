<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 상세 보기</title>
<style type="text/css">
	ul li{list-style: none;}
</style>
</head>
<body>
	<h2>상품 등록</h2>
	<hr>
	<form action="/product?action=add" method="post">
		<ul>
			<li>
				<label>상품 코드</label>
				<input type="text" name="pid">
			</li>
			<li>
				<label>상품명</label>
				<input type="text" name="pname">
			</li>
			<li>
				<label>제조사</label>
				<input type="text" name="maker">
			</li>
			<li>
				<label>가격</label>
				<input type="number" name="price">
			</li>
			<li>
				<label>등록일</label>
				<input type="date" name="regdate">
			</li>
		</ul>
		<p>
			<input type="submit" value="등록">
			<input type="reset" value="취소">
		</p>
	</form>
</body>
</html>