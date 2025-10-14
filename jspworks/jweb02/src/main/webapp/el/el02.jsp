<%@ page import="java.time.LocalDateTime"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 언어</title>
</head>
<body>
	<!-- 현재 날짜 객체 생성1 -->
	<% LocalDateTime datetime =	LocalDateTime.now(); %>
	<p>스크립트 출력 : <%=datetime %></p>
	
	<!-- 현재 날짜 객체 생성2 -->
	<jsp:useBean id="now" class="java.util.Date" />
	<p>EL 출력 : ${now}</p>
	<hr>
	
	<!-- request에 데이터 저장 -->
	<%
		request.setAttribute("name", "한강");
		request.setAttribute("age", 25);
	%>
	
	<p>이름: ${name}</p> <%-- 한강 --%>
	<p>나이: ${age}</p>  <%-- 25 --%>
	<hr>
	
	<!-- 배열, Map 접근 -->
	<%
	    String[] fruits = {"사과", "바나나", "포도"};
	    request.setAttribute("fruits", fruits);
	%>
	
	<p>${fruits[0]}</p>   <%-- 사과 --%>
	<p>${fruits[1]}</p>   <%-- 바나나 --%>
	
	<% for(int i=0; i<fruits.length; i++){ %>
	    	<p>${fruits[i]}</p>
	<% } %> 
	
	<%
	    Map<String, String> map = new HashMap<>();
	    map.put("k1", "korea");
	    map.put("j1", "japan");
	    request.setAttribute("map", map);
	%>
	
	<p>${map.k1}</p>      <%-- korea --%>
	<p>${map["j1"]}</p>   <%-- japan --%>
	
</body>
</html>