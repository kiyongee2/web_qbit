<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
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
		<table>
			<tbody>
				<tr>
					<td><input type="text" name="title" size=52 
						value="${board.title}" readonly></td>
				</tr>
				<tr>
					<td><input type="text" name="mid" size=52 readonly
						value="글쓴이: ${board.mid} (작성일: ${board.regDate})"></td>
				</tr>
				<tr>
					<td>
						<textarea  name="content" rows="10" 
								cols="50" readonly>${board.content}</textarea>
					</td>
				</tr>
			</tbody>
		</table>
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