package com.myweb.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//DAO(Data Access Object)
//웹 프로그램에서 데이터베이스 CRUD작업이 요구될 때마다 
//데이터베이스 접속 및 sql문 실행을 전담하는 비즈니스 로직으로 이루어진 객체
// *CRUD작업: CREATE, READ, UPDATE, DELETE
// 무분별한 객체 생성을 막기 위해 싱글톤 디자인 패턴으로 구축한다.
public class UserDAO {
	
	//커넥션 풀의 정보를 담을 변수를 선언.
	private DataSource ds;
	
	
	private UserDAO() {
		
		
		//커넥션 풀 정보 불러오기 //
		try {
			InitialContext ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/myOracle");
			//ds에 커넥션 풀이 들어감.
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	private static UserDAO dao = new UserDAO();
	
	public static UserDAO getInstance() {
		if(dao == null) {
			dao = new UserDAO();
		}
		return dao;
	}
	
	//////////////////////////////////////////
	
	//회원 중복 여부 확인
	public boolean confirmId(String id) {
		String sql = "SELECT * FROM my_user WHERE user_id=?";
		boolean flag = false;
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql) ){	
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) flag =true;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public void insertUser(UserVO vo) {
		String sql = "INSERT INTO my_user VALUES(?,?,?,?,?)";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getUserPw());
			pstmt.setString(3, vo.getUserName());
			pstmt.setString(4, vo.getUserEmail());
			pstmt.setString(5, vo.getUserAddress());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		};
	}
	
	
	//로그인 시, 아이디와 비밀번호가 맞는지 체크
	public int userCheck(String id, String pw) {
		int check = 0;
		String sql = "SELECT * FROM my_user WHERE user_id = ?";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){	
			
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(pw.equals(rs.getString("user_pw"))) {
					check = 1;
				} else {
					check = 0;
				}
			} else { //= 조회결과가 없었다.
				check = -1;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return check;
		
	}

	
	//아이디 성공 시, 정보를 세션에 저장
	public UserVO getUserInfo(String id) {
		UserVO user = null;
		String sql = "SELECT * FROM my_user WHERE user_id = '"+id+"'";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			
			if(rs.next()) {
				user = new UserVO(
						rs.getString("user_id"),
						rs.getString("user_pw"),
						rs.getString("user_name"),
						rs.getString("user_email"),
						rs.getString("user_address")
						);	
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

	
	public void changePassword(String userId, String newPw) {
		String sql = "UPDATE my_user"
				+ " SET user_pw =? WHERE user_id=?";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, newPw);
			pstmt.setString(2, userId);
			pstmt.executeUpdate();
			
			
			System.out.println("비밀번호 변경 업데이트 중");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateUser(UserVO vo) {
		String sql = "UPDATE my_user"
				+ " SET user_name = ?, user_email = ?, user_address = ?"
				+ " WHERE user_id = ?";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, vo.getUserName());
			pstmt.setString(2, vo.getUserEmail());
			pstmt.setString(3, vo.getUserAddress());
			pstmt.setString(4, vo.getUserId());
			
			System.out.println("회원 정보 수정 중 / id: "+vo.getUserId());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void deleteUser(String id) {
		String sql = "DELETE FROM my_user"
				+ " WHERE user_id = '"+id+"'";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			System.out.println(id+" 회원의 정보를 삭제합니다.");
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
}
