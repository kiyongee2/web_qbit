<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글쓰기</title>
	<link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
	<section id="container">
		<c:if test="${empty sessionId }">
			<script>
				alert("로그인이 필요합니다.");
				location.href="/member?action=loginForm";
			</script>
		</c:if>
	
		<h2>글쓰기</h2>
		<form action="/board" method="post" class="writeForm">
			<input type="hidden" name="action" value="write">
			<fieldset>
				<ul>
					<li>
						<input type="text" name="title" size=62
								placeholder="제목">
					</li>
					<li>
						<textarea  name="content" rows="10" cols="60"
							placeholder="내용"></textarea>
					</li>
					<li>
						<input type="text" name="mid" size=62 
									value="${sessionId}">
					</li>
				</ul>
			</fieldset>
			<p><button type="submit">등록</button></p>
		</form>
	</section>
</body>
</html>