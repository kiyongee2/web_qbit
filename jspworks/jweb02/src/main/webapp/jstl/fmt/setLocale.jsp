<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날짜 시간 표기</title>
</head>
<body>
	<h3>로케일 지정 예제</h3>
	<%=response.getLocale() %>
	
	<jsp:useBean id="now" class="java.util.Date" />
	<p>현재 날짜 및 시간 : ${now}
	
	<fmt:setLocale value="ko_KR" />
	<p>한글 형식: 
		<fmt:formatDate value="${now}" type="both" dateStyle="full" />
	</p>
	
	<fmt:setLocale value="en_US" />
	<p>영문 형식: 
		<fmt:formatDate value="${now}" type="both" dateStyle="full" />
	</p>
	
	<fmt:setLocale value="ja_JP" />
	<p>일어 형식: 
		<fmt:formatDate value="${now}" type="both" dateStyle="full" />
	</p>
</body>
</html>