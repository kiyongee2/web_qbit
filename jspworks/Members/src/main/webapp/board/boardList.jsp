<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %> 
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %> 
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
		<p>
			<a href="/index.jsp">홈으로</a>
		<p>
		<table>
			<thead>
				<tr>
					<th>글번호</th>
					<th>글제목</th>
					<th>글쓴이</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${boardList}">
				<tr>
					<td>${board.bnum}</td>
					<td><a href="/board?action=detail&bnum=${board.bnum}"> 
							${board.title}</a>
					</td>
					<td>${board.mid}</td>
					<td>${board.hit}</td>
					<td><fmt:formatDate value="${board.regDate}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="btnWrite">
			<a href="/board?action=writeForm" >
				<button type="button">글쓰기</button>
			</a>
		</div>
	</section>
</body>
</html>