package com.myweb.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.user.service.ChangePwService;
import com.myweb.user.service.DeleteService;
import com.myweb.user.service.IUserService;
import com.myweb.user.service.JoinService;
import com.myweb.user.service.LoginService;
import com.myweb.user.service.UpdateService;

@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//서비스 인터페이스 타입의 변수를 선언
	//요청이 무엇이냐에 따라 하나의 변수로 여러 종류의 객체를 대입.
	private IUserService sv; //흠 ;
	
    public UserController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//글자 깨짐 방지!!!!
		if(request.getMethod().equals("POST")) { 
			request.setCharacterEncoding("UTF-8");
		}
		
		
		String uri = request.getRequestURI();
		uri = uri.substring(request.getContextPath().length()+1, uri.lastIndexOf("."));
		
		System.out.println(request.getContextPath());		
		System.out.println("정제된 uri: "+uri);
		
		switch(uri) {
		case "joinPage" :
			System.out.println("회원 가입 페이지로 이동 요청!");
			//하단 둘 중 마음에 드는걸로
//			response.sendRedirect("/MyWeb/user/user_join.jsp"); 
			response.sendRedirect("user/user_join.jsp"); 
			break;
			
		case "join" :	
			System.out.println("회원 가입 요청이 들어옴!");
			sv = new JoinService();
			sv.execute(request, response);
			break;
			
		case "loginPage":
			System.out.println("로그인 페이지로 이동 요청!");
			response.sendRedirect("user/user_login.jsp");
			break;
			
		case "login":
			System.out.println("로그인 요청이 들어옴!");
			sv = new LoginService();
			sv.execute(request, response);
			break;
		case "myPage":	
			System.out.println("로그인 성공! 내 페이지로 이동.");
			response.sendRedirect("user/user_mypage.jsp");
			break;
			
		case "pwPage":
			System.out.println("비밀번호 변경 페이지로 이동 요청!");
			response.sendRedirect("user/user_change_pw.jsp");
			break;
			
		case "changePw" :
			System.out.println("비밀번호 변경 요청!");
			sv= new ChangePwService();
			sv.execute(request, response);
			break;
		
		case "modPage" :
			System.out.println("회원 정보 페이지로 이동 요청!");
			response.sendRedirect("user/user_update.jsp");
			break;
			
		case "update" : 
			System.out.println("회원 정보 수정 요청이 들어옴!");
			sv = new UpdateService();
			sv.execute(request, response);
			break;
			
		case "delPage" :
			System.out.println("탈퇴 페이지로 이동 요청!");
			response.sendRedirect("user/user_delete.jsp");
			break;
			
		case "delete" :
			System.out.println("계정 삭제 요청이 들어옴!");
			sv = new DeleteService();
			sv.execute(request, response);
			
			break;
			
		case "Logout" :
			System.out.println("로그아웃 요청이 들어옴!");
			request.getSession().invalidate();
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			String htmlCode = "<script>\r\n"
					+ "alert('로그아웃 처리되었습니다.');\r\n"
					+ "location.href='/MyWeb';\r\n"
					+ "</script>";
			out.print(htmlCode);
			out.flush();
			break;
		}
		
			
			
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
