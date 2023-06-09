<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- <% int total = 0; 
	for(int i=1; i<=100; i++){
		total += i;
	}
		out.print("<h4>1부터 100까지의 누적합: "+total+"</h4>");
	%> --%>

	<%-- 
		<c:set> 태그는 변수의 생성과 동시에, 이미 동일한 이름의 데이터가 존재한다면
		기존의 데이터를 지목해서 값을 변경할 때도 사용한다.
		setAttribute()에서 이미 존재하는 이름을 지목하여 값을 변경하는 것과 유사하다.
	 --%>


	<c:set var="total" value="0" />
	<c:forEach var="i" begin="1" end="100" step="1">
		<c:set var="total" value="${ total+i }" />
	</c:forEach>

	<h4>1부터 100까지의 누적합: ${total}</h4>
	
	<hr>
	
	<%--
	<h4>구구단 n단</h4>
	<% for(int hang=1; hang <=9; hang++){ %>
		4 x <%=hang%> = <%=4*hang%> <br>
	<%} %>
	<c:forEach var="hang" begin="1" end="9"> <!-- step을 생략할 경우 자동으로 1로 처리됨. -->
		4 x ${hang} = ${hang*4} <br>
	</c:forEach> --%>
	
	<!-- 구구단을 2~9단까지 출력하는데, 짝수단만 출력해 보세요. (jstl) -->
	
	
	<c:forEach var="fir" begin="2" end="9">
		<c:if test="${fir%2 ==0}">
			<h4>구구단 ${fir}단</h4>
			<c:forEach var="sed" begin="1" end="9">
				${fir} x ${sed} = ${fir*sed} <br>
			</c:forEach>
			<br>
		</c:if>
	</c:forEach>
	
	
	<h2>배열이나 컬렉션 내부의 값을 출력</h2>
	
	<c:set var="arr" value="<%= new int[] {1,3,5,7,9} %>"  />
	<c:forEach var="n" items="${arr}">
		${n}  &nbsp;
	</c:forEach>
	
	<hr>
	<%-- <c:set var="list" value="<%= new ArrayList<>() %>" /> --%>
	<c:set var="list" value='<%= Arrays.asList("가", "나", "다", "라") %>'  />
	
	<c:forEach var="str" items="${list}">
		${str}  &nbsp;
	</c:forEach>
	
	
</body>
</html>













