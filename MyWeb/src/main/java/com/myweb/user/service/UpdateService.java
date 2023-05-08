
package com.myweb.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.myweb.user.model.UserDAO;
import com.myweb.user.model.UserVO;

public class UpdateService implements IUserService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		/*
		 1. form에서 넘어오는 데이터(파라미터)들 가져오기
		 2. 데이터를 UserVO로 포장하기
		 3. dao의 updateUser()를 호출해서 회원정보 수정 진행하기
		 4. 수정된 정보로 세션 데이터를 교환(덮어 씌우기)
		 5. alert()을 이용해서 사용자에게 응답을 주고 마이페이지로 이동.
		 */
		
		HttpSession session = request.getSession(); 
		UserVO user = (UserVO) session.getAttribute("user");
		
		UserVO vo = new UserVO( //1번&2번
				request.getParameter("id"),
				user.getUserPw(),
				request.getParameter("name"),
				request.getParameter("email"),
				request.getParameter("address")
				);
//		vo.setUserId(request.getParameter("id")); //두번째 방법
		
		UserDAO dao = UserDAO.getInstance(); //3번
		dao.updateUser(vo);
				
		session.setAttribute("user", vo); //4번
	
		response.setContentType("text/html; charset=UTF-8");
		String htmlCode;
		
		
		try {
			PrintWriter out = response.getWriter();
			htmlCode = "<script>\r\n"
					+ "alert('회원정보 수정이 완료되었습니다.');\r\n"
					+ "location.href='/MyWeb/myPage.user';\r\n"
					+ "</script>";
			out.print(htmlCode);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
				
				
				
				
	}


}















