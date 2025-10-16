<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
	<section id="container">
		<h2>로그인</h2>
		<form action="/member" method="post">
			<input type="hidden" name="action" value="login">
			<ul>
				<li>
					<label>아이디</label>
					<input type="text" name="mid">
				</li>
				<li>
					<label>비밀번호</label>
					<input type="password" name="passwd">
				</li>
			</ul>
			<div style="color: red">
				<c:if test="${not empty error}">
				  ${error}
				</c:if>
			</div>
			<div class="btnLogin">
				<input type="submit" value="로그인">
				<input type="reset" value="취소">
			</div>
		</form>
	</section>
</body>
</html>