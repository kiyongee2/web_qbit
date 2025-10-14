<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
<link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
	<section id="container">
		<h2>회원 정보</h2>
		<ul>
			<li>아이디: ${member.mid}</li>
			<li>비밀번호: ${member.passwd}</li>
			<li>이름: ${member.name}</li>
			<li>성별: ${member.gender}</li>
			<li>가입일: ${member.joinDate}</li>
		</ul>
		<a href="/member?action=list">
			<button type="button">목록</button>
		</a>
	</section>
</body>
</html>