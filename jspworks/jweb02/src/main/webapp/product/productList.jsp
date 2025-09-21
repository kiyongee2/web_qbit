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
<body>
	<div id="container">
	<h2>상품 목록</h2>
	<hr>
	<form action="/jweb02/product" method="get">
		<select name="fruit">
			<option value="apple">사과</option>
			<option value="banana">바나나</option>
			<option value="grape">포도</option>
		</select>
		<input type="submit" value="선택">
	</form>
	</div>
</body>
</html>