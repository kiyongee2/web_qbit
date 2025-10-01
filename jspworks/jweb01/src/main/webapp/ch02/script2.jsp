<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지 디렉티브 태그 예제</title>
</head>
<body>
	<%
		//배열
		int[] arr = new int[]{10, 20, 30};
		
		for(int i = 0; i < arr.length; i++){
			out.println(arr[i]);
		}
		out.println("<br>");
		
		//ArrayList 클래스
		ArrayList<String> fruitList = new ArrayList<>();
		fruitList.add("사과");
		fruitList.add("딸기");
		fruitList.add("바나나");
		
		out.println(fruitList.get(0)); //사과
		out.println("<br>");
		
		for(String fruit : fruitList)
			out.println(fruit + " ");
	%>
</body>
</html>