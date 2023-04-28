<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String mvName = request.getParameter("pick");
    
    	/* if(mvName.equals("sel1")){
    		String url = "https://www.youtube.com/embed/wIyofRdOHOI?autoplay=1";
    		String pickName = "오리 힐링 영상";
    	} else if(mvName.equals("sel2")){
    		String url = "https://www.youtube.com/embed/BNKuteTX-e8?autoplay=1";
    		String pickName = "Hypeboy 커버영상";
    	} */
    %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	 <style>
		table{
			text-align: center;
			padding: 2px;
			margin: 0 auto;
			border: 0px solid #000000;
		}
		th, td, tr{
			border: 1px solid lightblue;
		}
			
	</style>
<body>

	<table border="1px solid #000000">
		<tr><td>선택한 영상 정보</td></tr>
		
			<% if(mvName.equals("sel1")){ %>
				<tr><td>선택한 영상은 <strong>오리 힐링 영상</strong>입니다.</td></tr>
				<tr><td>관련 비디오</td></tr>
				<tr><td>
					<iframe width="640" height="360" src="https://www.youtube.com/embed/wIyofRdOHOI?autoplay=1" title="[4K 무편집]  오창호수공원 오리 / 10분 힐링영상" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen loop>
			
			<%} else if(mvName.equals("sel2")){ %>
				<tr><td>선택한 영상은 원진의 <strong>Hype Boy 커버영상</strong>입니다.</td></tr>
				<tr><td>관련 비디오</td></tr>
				<tr><td>
					<iframe width="640" height="360" src="https://www.youtube.com/embed/BNKuteTX-e8?autoplay=1" title="[C-Plus+] WONJIN 원진 &#39;Hype boy&#39; Cover l CRAVITY (크래비티)" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen loop></iframe>
			<%} %>
		</iframe></td></tr>
		
		
		
	</table>
	



</body>
</html>