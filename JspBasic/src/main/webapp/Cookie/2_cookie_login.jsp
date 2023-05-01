<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
        - 생성된 login_cookie 쿠키를 검색하여 쿠키가 이미 존재한다면
         로그인 폼 대신 브라우저에 "이미 로그인한 사용자입니다." 를 출력 후
         welcome 페이지로 이동할 수 있는 링크를 제공하세요.
         
        - login_cookie가 없는 사용자는 로그인 입력창이 등장하도록 구성하세요.
    --%>
    

	<% 
    	Cookie[] cookies = request.getCookies();
    	boolean flag = false;
    	String userId = ""; //아이디 기억하기 쿠키
    
    	if(cookies != null){
    		for(Cookie c : cookies){
    			if(c.getName().equals("login_cookie")){
    				out.print("<h3>이미 "+c.getValue()+"(으)로 로그인된 사용자입니다.</h3>");
    				flag = true;
    				break;
    			}
    			if(c.getName().equals("remember_id")){
    				userId = c.getValue();
    			}
    			
    		}// for문 끝
    	}
	if(!flag){ %>
	<form action="2_cookie_login_con.jsp" method="post">
            <input type="text" name="id" size="10" placeholder="ID" value="<%=userId%>"> 
            <input type="checkbox" name="id_remember" value="true">
            <small style="font-size: 0.7em">아이디 기억하기</small>
            <br>
            <input type="password" name="pw" size="10" placeholder="PW"> <br>
            <input type="submit" value="로그인">
        </form>
	<%} %>
    
    
    
    




</body>
</html>



















