<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정</title>
<link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
	<section id="container">
		<h2>회원 수정</h2>
		<form action="/member" method="post">
			<input type="hidden" name="action" value="update">
			<ul>
				<li>
					<label>아이디</label>
					<input type="text" name="mid" value="${member.mid}" readonly>
				</li>
				<li>
					<label>비밀번호</label>
					<input type="password" name="passwd" value="${member.passwd}">
				</li>
				<li>
					<label>이름</label>
					<input type="text" name="name" value="${member.name}">
				</li>
				<li>
					<label>성별</label>
					<!-- 
					<c:if test="${member.gender eq '남자'}">
						<input type="radio" name="gender" value="남자" checked>남
						<input type="radio" name="gender" value="여자">여
					</c:if>
					<c:if test="${member.gender eq '여자'}">
						<input type="radio" name="gender" value="남자">남
						<input type="radio" name="gender" value="여자" checked>여
					</c:if>
					 -->
					<c:choose>
						<c:when test="${member.gender eq '남자'}">
							<input type="radio" name="gender" value="남자" checked>남
							<input type="radio" name="gender" value="여자">여
						</c:when>
						<c:otherwise>
							<input type="radio" name="gender" value="남자">남
							<input type="radio" name="gender" value="여자" checked>여
						</c:otherwise>
					</c:choose>
				</li>
			</ul>
			<div class="btnJoin">
				<input type="submit" value="저장">
				<input type="reset" value="취소">
			</div>
		</form>
	</section>
</body>
</html>