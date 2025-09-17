<body>
    <!-- header 영역 -->
	<%!
		int pageCount = 0;
	
	    void addCount(){
	    	pageCount++;
	    }
	%>
	
	<%
		addCount();
	%>
	이 사이트 방문은 <%=pageCount %>번째 입니다.
</body>
