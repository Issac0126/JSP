<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page errorPage="error_page02.jsp" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- null을 이용해 오류를 만듬. -->
	<%= request.getParameter("id").toLowerCase() %>


</body>
</html>


















