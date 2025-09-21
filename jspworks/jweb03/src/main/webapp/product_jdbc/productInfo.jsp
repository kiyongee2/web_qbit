<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 상세 보기</title>
</head>
<body>
	<h2>상품 정보</h2>
	<hr>
	<ul>
		<li>상품 코드: ${product.pid}</li>
		<li>상품 이름: ${product.pname}</li>
		<li>제조사: ${product.maker}</li>
		<li>가격: ${product.price}</li>
		<li>등록일: ${product.date}</li>
	</ul>
	
	<a href="pcontrol?action=list">상품 목록으로</a>
</body>
</html>