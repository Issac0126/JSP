<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL을 사용하기 위해서는 외부 태그 라이브러리 선언을 해야 한다.  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
		JSTL의 c:set으로 변수를 선언하면 EL 안에서 활용이 가능하다.
		값도 EL을 이용해서 배길 수 있다.
		EL이 타입을 자동으로 인식해서 정해준다. 
		c:set을 이용해서 지정한 변수는 스크립틀릿의 자바 변수와는 다르다.
		내장객체에 지정하는 데이터로 활용되기 때문에 EL이 가능하다. 
		(scope 속성이 숨겨져있다. 기본값은 page => 이 페이지 안에서만 사용 가능.)
	 -->

	<c:set var="age" value="${param.age}" />
	
	<p>
		나이: ${age}세
		<c:if test="${age >= 20}">
			<h2>당신은 성인입니다.</h2>
		</c:if>
	</p>








</body>
</html>











