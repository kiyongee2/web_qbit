<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 언어</title>
</head>
<body>
	<h2>EL 언어 실습</h2>
	<h3>문자, 숫자 데이터 표현</h3>
	${300}<br>
	${"감사합니다."}<br>
	${12 * 2}
	${12 / 2}
	
	<h3>비교, 논리 연산</h3>
	${10 == 11}<br>
	${10 eq 11}<br>
	${10 != 11}<br>
	
	${10 < 11}<br>
	${10 lt 11}<br>
	${10 > 11}<br>
	${10 gt 11}<br><br>
	
	${(10 > 11) and (10 != 11)}<br>
	${(10 > 11) or (10 != 11)}<br><br>
	
</body>
</html>