<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 태그</title>
</head>
<!-- 전역 변수 선언 -->
<%!
	int count = 0;
%>
<body>
	<h2>스크립트 태그</h2>
	<%
		int n1 = 10, n2 = 20;
	
		out.println("두 수의 합: " + (n1 + n2) + "<br>");
		
		//짝수 출력
		for(int i = 1; i <= 10; i++){
			if(i % 2 == 0)
				out.println(i);
		}
	%>
	
	<h3>두 수의 합: <%=n1 + n2 %></h3>
	<h3>사이트 방문은 <%= ++count %>번째 입니다.</h3>
</body>
</html>