<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- Ctrl + Shift + / 로 나오는 주석... -->

	<%-- 
		- 전송 방식을 post로 사용하기 위해서는 form 태그가 반드시 필요합니다.
		- form 태그의 method라는 속성을 "post"로 설정하면
		요청 방식이 post 방식으로 전송된다. (기본값은 get)  
	--%>


	<form action="3_req_post_take.jsp" method="post">
		- 아이디: <input type="text" name="id" size="10"> <br>
		- 비밀번호: <input type="password" name="pw" size="10"> <br>
		- 이름: <input type="text" name="name" size="10"> <br>
		<input type="submit" name="확인">
	</form>
</body>
</html>