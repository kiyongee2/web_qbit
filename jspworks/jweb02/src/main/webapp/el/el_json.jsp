<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL JSON 예제</title>
</head>
<body>

<%
    List<Map<String, Object>> userList = new ArrayList<>();

    Map<String, Object> user1 = new HashMap<>();
    user1.put("name", "이정후");
    user1.put("age", 26);
    user1.put("team", "키움");
    userList.add(user1);

    Map<String, Object> user2 = new HashMap<>();
    user2.put("name", "류현진");
    user2.put("age", 37);
    user2.put("team", "한화");
    userList.add(user2);

    request.setAttribute("users", userList);
%>

<h2>JSON 형태 (List<Map>) 반복 출력</h2>
	<table border="1" cellpadding="5">
	<tr><th>이름</th><th>나이</th><th>팀</th></tr>
	<c:forEach var="u" items="${users}">
	    <tr>
	        <td>${u.name}</td>
	        <td>${u.age}</td>
	        <td>${u.team}</td>
	    </tr>
	</c:forEach>
	</table>

</body>
</html>
