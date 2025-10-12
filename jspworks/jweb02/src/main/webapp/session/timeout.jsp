<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션의 유효시간 설정</title>
</head>
<body>
	<h3>세션 유효시간 변경 전</h3>
	<%
		// 30*60=1800초
		int time = session.getMaxInactiveInterval();
		out.println(time + "초<br>");
		
		time = time / 60;
		out.println(time + "분<br>");
	%>
	
	<h3>세션 유효시간 변경 후</h3>
	<%
		//세션 유효 시간을 5분으로 설정
		session.setMaxInactiveInterval(5*60);
		
		// 5*60=300초
		time = session.getMaxInactiveInterval();
		out.println(time + "초<br>");
		
		time = time / 60;
		out.println(time + "분<br>");
	%>
	
</body>
</html>