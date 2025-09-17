<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<style>
	ul li{list-style: none; margin: 10px;}
</style>
</head>
<body>
	<h3>회원 가입</h3>
	<form action="member01_process.jsp" method="post">
		<ul>
		  <li>
		  	<label for="uid">아이디 : </label>
		  	<input type="text" name="id">
		  </li>
		  <li>
		  	<label for="passwd">비밀번호 : </label>
		  	<input type="password" name="passwd">
		  </li>
		  <li>
		  	<label for="name">이름 : </label>
		  	<input type="text" name="name">
		  </li>
		  <li>
		  	<!-- <input type="submit" value="로그인"> -->
		  	<button type="submit">로그인</button>
		  </li>
		</ul>
	</form>
</body>
</html>