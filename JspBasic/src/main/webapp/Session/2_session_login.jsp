<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% if(session.getAttribute("user_id") == null){ %>	<!-- 로그인 중이 아닐 경우 -->
	<form action="2_session_login_con.jsp" method="post">
            <input type="text" name="id" size="10" placeholder="ID"> <br>
            <input type="password" name="pw" size="10" placeholder="PW"> <br>
            <input type="text" name="nick" size="10" placeholder="별명"> <br>
            <input type="submit" value="로그인">
        </form>
	<% } else { %> <!-- 로그인 중일 경우 -->
	<h3> <%= session.getAttribute("user_nick")%>으로 이미 로그인 중인 사용자입니다.</h3>
	<a href="2_session_welcome.jsp">로그인 성공 페이지로 이동하기</a>
	
	<%} %>
	
	
	
	
	



</body>
</html>