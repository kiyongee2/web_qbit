<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl - core</title>
</head>
<body>
	<h2>학점 계산기</h2>
	<form action="scorePoint.jsp" method="get">
		<p>점수 입력 <input type="text" name="score">
			<input type="submit" value="학점출력"></p>
	</form>
</body>
</html>