<%@page import="org.apache.catalina.loader.WebappLoader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%--  <!-- 기존에 데이터 꺼내던 방식 -->
		<%
			String name = request.getParameter("name");
			String nick = request.getParameter("nick");
		%>
		<p>
			# 이름: <%= name %> <br>
			# 별명: <%= nick %>
		</p> 
	--%>
	
	<p> <!-- el을 이용해서 데이터 꺼내기 (신문물) -->
		# 이름 : ${param.name} <br>
		# 별명 : ${param.nick}
	</p>
	
	<%
		session.setAttribute("data1", "hello~!");
		application.setAttribute("data2", "bye");
		session.setAttribute("data2", "이름은 같지만 다른 데이터");
	%>
	
	<a href="2_el_result.jsp"> 세션, 어플리케이션 데이터를 화면에 출력하기</a>	












</body>
</html>
























