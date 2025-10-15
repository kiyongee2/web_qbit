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
	<p>===== 기본 로케일 =====</p>
	<fmt:setLocale value="ko"/>
	<fmt:setBundle basename="bundle0.message_ko" />
	<p>제목: <fmt:message key="title" />
	<p>이름: <fmt:message key="username" />
	
	<p>===== 영문 로케일 =====</p>
	<fmt:setLocale value="en"/>
	<fmt:setBundle basename="bundle0.message_en" />
	<p>제목: <fmt:message key="title" />
	<p>이름: <fmt:message key="username" />
	
	<p>===== 일본어 로케일 =====</p>
	<fmt:setLocale value="ja"/>
	<fmt:setBundle basename="bundle0.message_ja" />
	<p>제목: <fmt:message key="title" />
	<p>이름: <fmt:message key="username" />
</body>
</html>