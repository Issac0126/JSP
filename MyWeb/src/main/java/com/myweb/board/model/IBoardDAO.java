package com.myweb.board.model;

import java.util.List;

public interface IBoardDAO {

	//글 등록 메서드
	//인터페이스 메서드를 구현할 때에는 1. 메서드 이름, 2. 리턴 타입, 3. 받을 매개변수를 결정한다.
	void regist(String writer, String title, String content);
	

	//글 전체 목록을 가지고 오는 메서드
	List<BoardVO> listBoard(); //SELECT * FROM my_board로 정해졌기 때문에 매개변수 필요X
	
	
	//글 상세보기 요청을 처리할 메서드
	BoardVO contentBoard(int bId);
	
	
	//글 수정 요청을 처리할 메서드 (제목, 내용)
	void updateBoard(String title, String content, int bId);
	
	
	//글 삭제 요청을 처리할 메서드
	void deleteBoard(int dId);
	
	
	//글 검색 요청을 처리할 메서드
	List<BoardVO> searchBoard(String keyword, String category);
	
	
	//조회수를 올려주는 메서드
	void upHit(int dId);
	
	
	
}
