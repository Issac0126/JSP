package com.myweb.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.text.AbstractDocument.Content;
import javax.websocket.Session;

public class BoardDAO implements IBoardDAO {

	private DataSource ds; //커넥션 풀
	
	private BoardDAO(){
		try {
			InitialContext ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/myOracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	private static BoardDAO dao = new BoardDAO();

	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
		
		
	}
	
	
	//////////////////////////////////////////////
	
	@Override
	public void regist(String writer, String title, String content) {
		System.out.println(writer+"가 '"+title+"'로 글을 작성함.");
		String sql = "INSERT INTO my_board"
				+ " (board_id, writer, title, content)"
				+ " VALUES (board_seq.NEXTVAL, ?, ?, ?)";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public List<BoardVO> listBoard() {
		List<BoardVO> articles = new ArrayList<>();
		String sql = "SELECT * FROM my_board";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			
			while(rs.next()) {
				BoardVO vo = new BoardVO(
						rs.getInt("board_id"),
						rs.getString("writer"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getTimestamp("reg_date").toLocalDateTime(),
						rs.getInt("hit")
						);
				articles.add(vo);
						
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articles;
	}
	

	@Override
	public BoardVO contentBoard(int bId) {
		
		BoardVO vo = null;
		String sql = "SELECT * FROM my_board WHERE board_id ="+bId;
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			
			if(rs.next()) {
				vo = new BoardVO(
						rs.getInt("board_id"),
						rs.getString("writer"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getTimestamp("reg_date").toLocalDateTime(),
						rs.getInt("hit")
						); 				
			} 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("반환되는 객체: "+vo);
		return vo;
	}
	

	@Override
	public void updateBoard(String title, String content, int bId) {
		String sql = "UPDATE my_board SET title =?, content=? WHERE board_id=?";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, bId);
			System.out.println("업데이트 중..."+title+content+bId);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	@Override
	public void deleteBoard(int dId) {
		String sql = "DELETE FROM my_board WHERE board_id ="+dId;
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public List<BoardVO> searchBoard(String keyword, String category) {
		List<BoardVO> searchList = new ArrayList<>();
		String sql = "SELECT * FROM my_board WHERE "+category+" LIKE ?";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, "%"+keyword+"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
					BoardVO vo = new BoardVO(
								rs.getInt("board_id"),
								rs.getString("writer"),
								rs.getString("title"),
								rs.getString("content"),
								rs.getTimestamp("reg_date").toLocalDateTime(),
								rs.getInt("hit")
							);
					searchList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return searchList;
	}
	
	
	@Override
	public void upHit(int dId) {
		String sql = "UPDATE my_board SET hit = hit+1 WHERE board_id = "+dId;
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	

}





















