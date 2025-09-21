<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 상세 보기</title>
<style>
	a{text-decoration: none;}
</style>
</head>
<body>
	<h2>상품 정보</h2>
	<hr>
	<ul>
		<li>상품 코드: ${product.pid}</li>
		<li>상품 이름: ${product.pname}</li>
		<li>제조사: ${product.maker}</li>
		<li>가격: ${product.price}</li>
		<li>등록일: ${product.regdate}</li>
	</ul>
	<div>
		<a href="/product?action=updateForm&pid=${product.pid}">
			<button type="submit">수정</button>
		</a>
		<a onclick="return confirm('정말로 삭제하시겠습니까?')"
		   href="/product?action=delete&pid=${product.pid}">
		<button type="submit">삭제</button></a>
		<a href="/product?action=list">
			<button type="button">목록</button>
		</a>
	</div>
	
</body>
</html>