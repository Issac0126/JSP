package com.myweb.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.myweb.user.model.UserDAO;
import com.myweb.user.model.UserVO;

public class ChangePwService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		/*
	    1. 폼 데이터 처리 (기존 비번, 변경 비번)
	    2. dao주소값을 받아오시고, userCheck()를 활용하여
	     기존 비번과 아이디 정보를 바탕으로 해당 비밀번호가 일치하는지를 검사.
	     (id는 세션에서 구해옵니다.)
	    
	    3. 기존 비밀번호가 일치한다면 비밀번호 변경 메서드 changePassword() 호출.
	    4. "비밀번호가 정상적으로 변경되었습니다." 경고창 출력 후 mypage 이동.
	    5. 현재 비밀번호가 불일치 -> "현재 비밀번호가 다릅니다." 경고창 출력 후 뒤로가기.
	    */
		
		
		UserDAO dao = UserDAO.getInstance();
		
		String oldPw = request.getParameter("old_pw");
		String newPw = request.getParameter("new_pw");
		
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		String userId = user.getUserId();
		
		response.setContentType("text/html; charset=UTF-8");
		String htmlCode = null;
		PrintWriter out;
		
		int result = dao.userCheck(userId, oldPw);
		
		
		try {
			out = response.getWriter();
			if(result == 1) {
				System.out.println("유저 아이디: "+userId+"새 비밀번호: "+newPw);
				dao.changePassword(userId, newPw);
				htmlCode = "<script>\r\n"
						+ "alert('비밀번호가 정상적으로 변경되었습니다.');\r\n"
						+ "location.href='/MyWeb/myPage.user';\r\n"
						+ "</script>";
				out.print(htmlCode);
				out.flush();
				out.close();
				
				
			} else {
				htmlCode = "<script>\r\n"
						+ "alert('비밀번호가 일치하지 않습니다.');\r\n"
						+ "history.back();\r\n"
						+ "</script>";
				out.print(htmlCode);
				out.flush();
				out.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}

}
