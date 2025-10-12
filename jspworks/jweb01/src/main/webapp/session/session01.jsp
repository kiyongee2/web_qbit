<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 발급</title>
<style>
	body{margin-left: 30px;}
</style>
</head>
<body>
	<h2>로그인</h2>
	<form action="session01_process.jsp" method="post">
		<p>아이디: <input type="text" name="id"></p>
		<p>패스워드: <input type="password" name="passwd"></p>
		<p><input type="submit" value="로그인"></p>
	</form>
</body>
</html>