package com.myweb.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;

public class GetListService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardVO> boardList = dao.listBoard();

		
		//Q. 왜 session을 사용하지 않고 request를 사용하는가?
		//A. 데이터베이스로부터 받아온 글 목록은 일시적인 데이터이다.
		//글 목록은 언제든지 변할 수 있기 때문에
		//그런 데이터를 굳이 session에 담아서 유지할 필요가 없다.
		//때문에 응답이 나간 뒤 자동으로 소멸하는 request에 담아서 화면에 전달한다.
		request.setAttribute("boardList", boardList);
		
		
		
		
	}

}
