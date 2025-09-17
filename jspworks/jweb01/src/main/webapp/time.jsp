<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시간이란...</title>
<style>
	#content{width: 90%; margin: 0 auto; text-align: center;}
</style>
<script>
	setInterval(myWatch, 1000);
	
	function myWatch(){
		let date = new Date();
		let now = date.toLocaleTimeString();
		document.getElementById("demo").innerHTML = now;
	}
</script>
</head>

<body>
	<div id = "content">
		<h2>시간이란...</h2>
		<h3>내일 죽을 것처럼 오늘을 살고<br>
		    영원히 살 것처럼 내일을 꿈꾸어라!</h3>
		<img alt="시계" src="resources/images/time.jpg" 
					width="320" height="240">
		<p id="demo"></p>
	</div>
</body>
</html>
