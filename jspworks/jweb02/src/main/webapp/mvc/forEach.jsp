<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL-반복문</title>
</head>
<body>
	<c:forEach var="i" begin="1" end="4" step="1">
		${i}번 반복<br>
	</c:forEach>
	
	<%
	    // JSP 스크립틀릿에서 리스트 생성 (실무에서는 Controller에서 전달하는 경우가 많음)
	    java.util.List<String> fruits = java.util.Arrays.asList("사과", "바나나", "딸기");
	
		//"fruits"라는 이름으로 fruits 리스트를 request scope 에 저장합니다.
		// 이렇게 하면 JSP 안에서 ${fruits} 라고 EL로 접근 가능해집니다.
	    request.setAttribute("fruits", fruits);
	%>
	
	<ul>
	<c:forEach var="fruit" items="${fruits}">
	    <li>${fruit}</li>
	</c:forEach>
	</ul>
	
	<%
	    String[] names = {"홍길동", "이순신", "유관순"};
	    request.setAttribute("names", names);
	%>
	
	<!-- varStatus 속성을 사용하면 반복 상태를 추적할 수 있습니다.
		status.index → 0부터 시작하는 인덱스
		status.count → 1부터 시작하는 반복 횟수  -->
	
	<c:forEach var="name" items="${names}" varStatus="status">
	    ${status.index} : ${name}<br>
	</c:forEach>
</body>
</html>