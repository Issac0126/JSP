<%@page import="com.myweb.board.commons.PageVO"%>
<%@page import="com.myweb.board.model.BoardDAO"%>
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
		for(int i = 1; i<=300; i++){
			String writer = "김테스트"+i;
			String title = "테스트 파일입니다."+i;
			String content = "개미"+i+"가 일을 합니다. <br> 개미는 뚠뚠 오늘도 뚠뚠 열심히 테스트를 하네 뚠뚠";
			
			BoardDAO.getInstance().regist(writer, title, content);
		}
	--%>

	<%
		int countArticles = BoardDAO.getInstance().countArticles();
		out.print("# 총 게시물 수: "+countArticles + "개 <br>");
		out.print("--------------------------------------<br>");
			
		PageVO paging = new PageVO();
		paging.setPage(12);
		paging.setCpp(20);
		int displayBtn = 6; //보여줄 버튼 개수 [1 2 3 ... 8 9 10] 이거
		
		//끝 페이지 번호 계산 테스트
		int endPage = (int) Math.ceil(paging.getPage() / (double) displayBtn) * displayBtn;
		//ceil에겐 double을 주고, double로 리턴된 값을 다시 int로 변환.
		out.print("끝 페이지 번호: "+endPage+"번 <br>");
		
		//시작 페이지 번호 테스트
		int beginPage = endPage - displayBtn + 1; //끝 페이지에서 10번째 앞 번호!
		out.print("시작 페이지 번호: "+beginPage+"번 <br>");
		
		//이전버튼 활성, 비활성 여부
		boolean isPrev = (beginPage == 1) ? false : true; 
		out.print("이전 버튼 활성화 여부: "+isPrev+" <br>");
		
		//다음버튼 활성, 비활성 여부
		boolean isNext = (countArticles <= (endPage*paging.getCpp())) ? false : true;
		out.print("다음 버튼 활성화 여부: "+isNext+" <br>");
		
		//끝 페이지 보정
		if(!isNext){ //다음 버튼이 비활성화가 되었다면
			endPage = (int) Math.ceil(countArticles / (double) paging.getCpp());
		}
		out.print("보정된 끝 페이지 번호: "+endPage+"번 <br>");
		
	
	%>






</body>
</html>




























