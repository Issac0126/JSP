package com.myweb.board.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;

public class ContentService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		BoardDAO dao = BoardDAO.getInstance();
		
		/*
        # 쿠키로 조회수를 컨트롤 해 보자.
        1. 사용자가 글 제목을 눌러서 상세보기 요청을 보낼 때 
        글 번호로 된 쿠키를 하나 만들어 줄 겁니다. (String)
        쿠키 이름과 쿠키에 저장할 값을 모두 글 번호로 만들어 주겠습니다.
        쿠키의 수명은 15초로 설정하겠습니다.
        
        2. 요청을 보낼 때 같이 넘어온 쿠키 중에, 
         현재 글 번호와 일치하는 쿠키가 존재한다면 조회수를 올려주지 않을 겁니다.
         현재 글 번호와 일치하는 쿠키가 없다면 조회수를 올려주도록 하겠습니다.  
        */
		
		Cookie[] cooList = request.getCookies();
		
		String stId = request.getParameter("bId"); //1번
		boolean flag = false;
		
		if(cooList != null) {
			for(Cookie c : cooList) {
				if(stId.equals(c.getName())) {
					flag = true;  break;
				}
			}
		}
		
		if(!flag) {
			System.out.println("조회수가 오름! 쿠키 등록"+stId);
			dao.upHit(bId); //조회수를 올린 다음에 게시글을 가져오기 적합한 위치
			
			Cookie cookie = new Cookie(stId, stId); //쿠키 생성
			cookie.setMaxAge(15);
			response.addCookie(cookie);
		}
		
		BoardVO vo = dao.contentBoard(bId);
		vo.setContent(vo.getContent().replace("\r\n", "<br>")); //엔터로 바꾸기 
		
		
		request.setAttribute("content", vo);
		
		
		
		
	
		
		
		
		
		
	}

}
