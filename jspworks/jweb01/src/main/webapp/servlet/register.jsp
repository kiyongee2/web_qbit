<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h2>회원 가입</h2>
	<form action="/register" method="post">
		<ul>
		  <li>
		  	<label for="uname">이름 : </label>
		  	<input type="text" id="uname" name="uname">
		  </li>
		  <li>
		  	<label for="email">이메일 : </label>
		  	<input type="text" id="email" name="email">
		  </li>
		  <li>
		  	<input type="submit" value="가입">
		  </li>
		</ul>
	</form>
</body>
</html>