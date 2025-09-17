<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Use Bean</title>
</head>
<body>
	<jsp:useBean id="calc" class="bean.Calculator" />
	<%
		int num = calc.calculate(4);
		out.println("결과: " + num);
	%>
</body>
</html>