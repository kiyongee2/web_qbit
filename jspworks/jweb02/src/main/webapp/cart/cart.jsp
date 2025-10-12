<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 선택 목록</title>
<style>
	#container{width: 80%; margin: 0 auto; text-align: center;}
</style>
</head>
<section id="container">
	<h2>장바구니</h2>
	<h2>선택한 상품 목록</h2>
	<hr>
	<%
		//세션 유지
		ArrayList<String> productList = (ArrayList)session.getAttribute("sessionList");
		
		//상품 목록
		if(productList != null){
			for(String product : productList){
				out.println(product + "<br>");
			}
		}
	%>
</section>
</body>
</html>
