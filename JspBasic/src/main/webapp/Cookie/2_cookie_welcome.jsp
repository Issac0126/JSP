<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	Cookie[] cookies = request.getCookies();
    	String userId = null;
    
    	if(cookies != null){
    		for(Cookie c : cookies){
    			if(c.getName().equals("login_cookie")){
    				userId = c.getValue();
    				break;
    			}
    		}// for END

    	}
    %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	
		if(userId != null){ //아직 로그인이 유효함
			out.print("<p>"+userId+"님 환영합니다!<br></p>");
		} else { 
			out.print("<p>시간이 지나 자동 로그아웃 처리되었습니다.<br></p>");
		}
	%>
	
	<a href="2_cookie_login.jsp">로그인 화면으로 돌아가기</a>










</body>
</html>
















