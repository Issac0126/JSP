package com.myweb.user.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.user.model.UserDAO;
import com.myweb.user.model.UserVO;

public class DeleteService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		
		String id = user.getUserId();
		String pw = request.getParameter("check_pw");
		
		UserDAO dao = UserDAO.getInstance();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;
		String htmlCode = null;
		
		int check = dao.userCheck(id, pw);
		if(check == 0) {
			htmlCode = "<script>\r\n"
					+ "alert('비밀번호가 틀렸습니다.');\r\n"
					+ "location.href='/MyWeb/myPage.user';\r\n"
					+ "</script>";
		}else if(check == 1) {
			try {
				out = response.getWriter();
				dao.deleteUser(id);
				
				session.removeAttribute("user"); //세션 삭제!
				
				htmlCode = "<script>\r\n"
						+ "alert('회원 탈퇴가 완료되었습니다.');\r\n"
						+ "location.href='/MyWeb';\r\n"
						+ "</script>";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		out.print(htmlCode);
		out.flush();
		out.close();
		
		
		
		
		
		
		
		
		
	}

}
