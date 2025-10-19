<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome~ Good Mall...</title>
	<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<section id="container">
		<div id="main">
			<h2>Good Mall에 오신 것을 환영합니다.</h2>
			
			<div class="main-pic">
				<img alt="점포" src="/resources/images/store.png">
			</div>
			
			<p>
			   <a href="/member?action=addForm">회원 가입</a> &nbsp; | &nbsp;
			   <a href="/member?action=loginForm">로그인</a> &nbsp; | &nbsp;
			   <a href="/member?action=list">회원목록</a> &nbsp; | &nbsp;
			   <a href="/board?action=boardList">게시판</a> &nbsp;
			</p>
		</div>
	</section>
</body>
</html>

