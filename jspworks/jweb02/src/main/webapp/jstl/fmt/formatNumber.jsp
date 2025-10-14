<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fmt 태그</title>
</head>
<body>
	<h3>숫자 표기</h3>
	<c:set var="price" value="25000"></c:set>
	<p>가격: ${price}
	
	<p>가격: <fmt:formatNumber value="25000" />
	<p>가격: <fmt:formatNumber value="${price}" />
	<hr>
	
	<h3>통화 표기</h3>
	<fmt:setLocale value="ko_KR" />
	<p>한국 원(KRW): 
		<fmt:formatNumber value="${price}" type="currency" />
	</p>
	
	<fmt:setLocale value="ja_JP" />
	<p>일본 엔(JPY): 
		<fmt:formatNumber value="${price}" type="currency" />
	</p>

	<fmt:setLocale value="en_US" />
	<p>미국 달러(USD): 
		<fmt:formatNumber value="${price}" type="currency" />
	</p>
	<hr>
	
	<h3>퍼센트 표기</h3>
	<c:set var="rate" value="0.257" />
	
	<p>기본 퍼센트 표시: 
		<fmt:formatNumber value="${rate}" type="percent" />
	</p>
	<p>소수점 1자리까지 표시: 
		<fmt:formatNumber value="${rate}" type="percent" maxFractionDigits="1" />
	</p>
	
</body>
</html>