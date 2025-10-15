<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
<style>
	h2{margin-left: 30px;}
	ul li{list-style: none; margin: 10px;}
</style>
</head>
<body>
	<fmt:setLocale value="${param.language}"/>
	<fmt:setBundle basename="bundle0.message"/>
	
	<a href="?language=ko">한국어</a> | 
	<a href="?language=en">영어</a>
	
	<h2><fmt:message key="title" /></h2>
	<form action="loginProcess.jsp" method="post">
		<ul>
		  <li>
		  	<label for="uid"><fmt:message key="userid" /> </label>
		  	<input type="text" id="userid" name="userid">
		  </li>
		  <li>
		  	<label for="passwd"><fmt:message key="password" /> </label>
		  	<input type="password" id="passwd" name="passwd">
		  </li>
		  <li>
		  	<button type="submit"><fmt:message key="button" /></button>
		  </li>
		</ul>
	</form>
</body>
</html>