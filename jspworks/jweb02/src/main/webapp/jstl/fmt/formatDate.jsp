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
	<h2>날짜를 다양한 형식으로 표기</h2>
	<jsp:useBean id="now" class="java.util.Date" />
	<p>현재 날짜 및 시간 : ${now}
	
	<!-- fmt:formatDate 사용 -->
	<p>날짜: 
		<fmt:formatDate value="${now}" type="date" />
	</p>
	<p>시간: 
		<fmt:formatDate value="${now}" type="time" />
	</p>
	<p>날짜와 시간: 
		<fmt:formatDate value="${now}" type="both" />
	</p>
	<hr>
	
	<h3>패턴 지정 예제</h3>
	<p>yyyy-MM-dd 형식: 
		<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" />
	</p>
	<p>yyyy년 MM월 dd일 a hh:mm:ss 형식: 
		<fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 a hh:mm:ss" />
	</p>
	
	<hr>

	<h3>로케일 지정 예제</h3>
	<fmt:setLocale value="en_US" />
	<p>영문 형식: 
		<fmt:formatDate value="${now}" type="both" dateStyle="full" />
	</p>

	<fmt:setLocale value="ko_KR" />
	<p>한글 형식: 
		<fmt:formatDate value="${now}" type="both" dateStyle="full" />
	</p>
</body>
</html>