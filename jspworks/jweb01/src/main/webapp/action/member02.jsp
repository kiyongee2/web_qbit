<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션 태그</title>
</head>
<body>
	<jsp:useBean id="member" class="bean.Member" scope="request" />
	<jsp:setProperty property="id" name="member" value="2025102" />
	<jsp:setProperty property="name" name="member" value="이강인" />
	
	<p>아이디 : <jsp:getProperty property="id" name="member"/>
	<p>이름 : <jsp:getProperty property="name" name="member"/>
</body>
</html>