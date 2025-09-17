<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
	<h2>회원 정보</h2>
	<hr>
	<table>
		<tr>
			<th>아이디</th>
			<th>패스워드</th>
			<th>이름</th>
		</tr>
		<tr>
			<td>${param.id}</td>
			<td>${param.passwd}</td>
			<td>${param.name}</td>
		</tr>
	</table>
</body>
</html>