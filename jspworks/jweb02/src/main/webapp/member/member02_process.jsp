<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body>
<jsp:useBean id="member" class="member.Member" />
<jsp:setProperty property="id" name="member"/>
<jsp:setProperty property="passwd" name="member"/>
<jsp:setProperty property="name" name="member"/>

	<h2>회원 정보</h2>
	<hr>
	<table>
		<tr>
			<th>아이디</th>
			<th>패스워드</th>
			<th>이름</th>
		</tr>
		<tr>
			<td>${member.id}</td>
			<td>${member.passwd}</td>
			<td>${member.name}</td>
		</tr>
	</table>
</body>
</html>