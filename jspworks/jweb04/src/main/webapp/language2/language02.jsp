<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다국어 처리</title>
</head>
<body>
	<h2>다국어 처리</h2>
	<fmt:setLocale value="${param.language}"/>
	<fmt:setBundle basename="bundle.message"/>
	
	<a href="?language=ko">한국어</a> | 
	<a href="?language=en">영어</a>  |
	<a href="?language=ja">일본어</a>
	
	<p>제목: <fmt:message key="title" />
	<p>이름: <fmt:message key="username" />
</body>
</html>  