<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<!-- 
    	# 요청 파라미터 (request parameter)
    	
    	- 클라이언트 측에서 서버로 데이터를 요청할 때
    	함께 전달되는 값들을 담은 변수.
    	- 요청 파라미터는 URL 주소 뒤에 ?를 붙인 후, [파라미터 변수명=값]의
    	형식을 통해 서버로 데이터를 전송한다. 
    	- 요청 파라미터를 여러 개 전달할 때 & 기호를 사용해 나열해서 전달한다.
     --> 


	<% 
		// 클라이언트 쪽에서 전송된 요청 파라미터 값을 얻는 방법
		// getParameter() 메서드는 String 문자열로 반환된다.
		// 숫자가 전달되어도 타입이 문자열이기 때문에 연산이 필요하면 변환해야 한다.
		
		double cm = Double.parseDouble(request.getParameter("cm"));
		double kg = Double.parseDouble(request.getParameter("kg"));
		
		//bmi 지수 계산
		double bmi = kg / (cm/100 * cm/100);
		bmi = Math.round(bmi*100) / 100.0;

	%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h2>당신의 BMI 지수</h2>
	
	<hr>
	<p>
		- 신장: <%= cm %>cm <br>
		- 체중: <%= kg %>kg 
	</p>
	
	<p>
		BMI 지수: <strong><%= bmi %></strong> <br>
		<% if(bmi>25) {%>	
			당신은 과체중입니다.
		<%} else if(bmi < 18.5) {%>
			당신은 저체중입니다.
		<%} else {%>
			당신은 정상체중입니다.
		<%} %>
	</p>
	



</body>
</html>






















