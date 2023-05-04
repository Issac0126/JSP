<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p> <!-- 기존에 데이터 꺼내던 방식 -->
		# data1: <%= session.getAttribute("data1") %> <br>
		# data2: <%= application.getAttribute("data2") %>
	</p>
	
	<hr> 
	
	<%--
		* EL에서 데이터를 참조할 때 영역을 명시하지 않는다면
		page -> request -> session -> application
		순서대로 검색하여 찾아내 표현합니다.
		
		* 만약 서로 다른 내장 객체에 같은 이름의 데이터가 존재하는 경우
		내장객체명Scope.데이터이름으로 특정 영역을 지목해서 가져올 수 있다.
	 --%>
	 
	 
	 
	 
	 
	<p> <!-- el을 이용해서 데이터 꺼내기 (신문물) -->
		# data1: ${data1} <br>
		# data2: ${data2} <br>
		# data2: ${applicationScope.data2}
	</p>











</body>
</html>