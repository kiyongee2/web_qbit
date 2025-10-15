<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 목록</title>
	<link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
	<section id="container">
		<h2>게시글 목록</h2>
		<table>
			<thead>
				<tr>
					<th>글번호</th>
					<th>글제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${boardList}">
				<tr>
					<td>${board.bnum}</td>
					<td>${board.title}</td>
					<td>${board.mid}</td>
					<td>${board.regDate}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<p>
			<a href="/board?action=writeForm">글쓰기</a>
		</p>
	</section>
</body>
</html>