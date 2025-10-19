<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
	<section id="container">
		<h2>게시글 상세보기</h2>
		<div class="detail">
			<fieldset>
				<ul>
					<li>
						<input type="text" name="title" size=62
								value="${board.title}" readonly>
					</li>
					<li>
						<textarea  name="content" rows="10" cols="60"
								readonly>${board.content}</textarea>
					</li>
					<li>
						<input type="text" name="mid" size=62 
								value="글쓴이: ${board.mid} (작성일: ${board.regDate})">
					</li>
				</ul>
			</fieldset>
		</div>
		<p>
		    <c:if test="${board.mid eq sessionId}">
			    <a href="/board?action=updateForm&bnum=${board.bnum}">
			    		<button>수정</button></a>
				<a href="/board?action=delete&bnum=${board.bnum}">
					<button onclick="return confirm('정말로 삭제하시겠습니까?')">삭제</button></a>
			</c:if>
			<a href="/board?action=boardList"><button>목록</button></a>
		</p>
	</section>
</body>
</html>