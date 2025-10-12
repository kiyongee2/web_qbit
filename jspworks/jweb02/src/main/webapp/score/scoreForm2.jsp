<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>jstl - core</title>
</head>
<body>
	<h2>학점 계산기</h2>
	<form action="scorePoint.jsp" method="get" name="form1">
		<p>점수 입력 <input type="text" name="score">
			<button type="button" onclick="checkScore()">학점 출력</button></p>
	</form>
	
	<script>
		function checkScore(){
			//alert("test");
			let form = document.form1;
			let score = form.score.value.trim();  //공백 제거
			console.log(score);
			console.log(typeof(score)); //string
			
			if(score == "" || isNaN(score)){
				alert("점수를 입력하세요(숫자만).");
				form.score.focus(); //커서 위치
				return false;
			}
			if(score < 0 || score > 100){
				alert("0~100 사이의 점수를 입력하세요.");
				form.score.focus(); //커서 위치
				return false;
			}
				
			form.submit();  //서버로 전송
		}
	</script>
	
</body>
</html>