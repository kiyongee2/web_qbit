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
		<h2>글 수정</h2>
		<form action="/board" method="post">
			<input type="hidden" name="action" value="update">
			<input type="hidden" name="bnum" value="${board.bnum}">
			<table>
				<tbody>
					<tr>
						<td><input type="text" name="title" size=52 
									value="${board.title}"></td>
					</tr>
					<tr>
						<td><input type="text" name="mid" size=52 
								value="${board.mid}" readonly></td>
					</tr>
					<tr>
						<td>
							<textarea  name="content" rows="10" 
									cols="50">${board.content}</textarea>
						</td>
					</tr>
				</tbody>
			</table>
			<p>
				<button type="submit">저장</button>
				<button type="reset">취소</button>
			</p>
		</form>
	</section>
</body>
</html>