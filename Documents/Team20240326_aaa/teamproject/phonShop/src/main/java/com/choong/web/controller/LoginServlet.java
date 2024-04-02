package com.choong.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.choong.biz.user.UserDAO;
import com.choong.biz.user.UserDTO;


@WebServlet("*.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//먼저 한글 필터 처리 부터 하기   

    public LoginServlet() {
        super();
      
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//#1. 사용자 요청이 들어오면 요청 경로(path)를 추출
		final String URI = request.getRequestURI();
		final String PATH =	URI.substring(URI.lastIndexOf("/"));
		
		//요청에 따라 처리하기
		if(PATH.equals("/login.do")) {
			System.out.println("로그인 처리");
			
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			
			//db 연결해서 정보 가져오기
			UserDTO dto = new UserDTO();
			dto.setUserId(id);
			
			UserDAO dao = new UserDAO();
			UserDTO user = dao.getUser(id);
			
			
			
			//화면 이동
			
			HttpSession session = request.getSession();
			
			if(user !=null && user.getUserPassword().equals(password)) {
				//로그인 성공시 검색된 회원 객체를 세션에 저장하기 위해서 세션 객체를 얻기
				session.setAttribute("user", user);
				
				//로그인 성공시 게시판에 id값 넘겨주기 	
				
				
				//로그인 성공시 글 목록 화면으로 이동
				RequestDispatcher dispatcher = request.getRequestDispatcher("/home.do");
				dispatcher.forward(request, response);
			}else {
				//로그인 실패시 다시 로그인 화면으로 이동
				RequestDispatcher dispatcher = request.getRequestDispatcher("/loginView.do");
				dispatcher.forward(request, response);
			}
			
			
		}else if(PATH.equals("/home.do")) {
			System.out.println("글 목록 검색 처리");
		
			
			// 1. 사용자 입력정보 추출
			String searchCondition = request.getParameter("searchCondition");
			String searchKeyword = request.getParameter("searchKeyword");
			
			// Null Check
			if(searchCondition == null) searchCondition = "TITLE";
			if(searchKeyword == null) searchKeyword = "";
			
			// 세션에 검색 관련 정보를 저장한다. 
			HttpSession session = request.getSession();
			session.setAttribute("condition", searchCondition);
			session.setAttribute("keyword", searchKeyword);	

			// 2. DB 연동 처리
			UserDTO dto = new UserDTO();
		
			
			UserDAO dao = new UserDAO();
			List<UserDTO> userList = dao.getUserList();
			
			// 3. 화면 이동
			request.setAttribute("userList", userList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/phone/user/userManagementList.jsp");
			dispatcher.forward(request, response);	
	
			
			
		}
		
	}
	
	
	
	
	

}
