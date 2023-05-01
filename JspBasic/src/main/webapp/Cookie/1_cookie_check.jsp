<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% 
    	// 클라이언트 쪽에서 요청과 함게 전송된 쿠키를 가져오는 방법.
    	Cookie[] cookies = request.getCookies();
    	boolean flag = false; //내가 찾는 쿠키의 존재 유무를 파악할 변수
    	
    	if(cookies !=null){ //쿠키가 없으면 null로 에러가 난다. 에러방지용 if! 
	    	for(Cookie c : cookies){
	    		if(c.getName().equals("id_cookie")){
	    			out.print("<h3>id 쿠키가 존재합니다!</h3>");
	    			String value = c.getValue(); //쿠키 내부의 값을 얻어오는 메서드.
	    			out.print("<h3>쿠키의 값은"+value+"이다.</h3>");
	    			flag=true;
	    			break;
	    		}
    		} //반복문 끝!
    	
    		if(!flag){ //반복문 끝났는데 발견한게 없음!
    			out.print("<h3>아이디 쿠키가 사라졌거나 존재하지 않습니다.</h3>");
    		}		
    	}
    	
    	
    	
    	
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="1_cookie_check_all.jsp">쿠키 배열 확인하기!</a>









</body>
</html>























