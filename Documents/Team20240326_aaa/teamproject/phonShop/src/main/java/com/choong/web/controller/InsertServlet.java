package com.choong.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.choong.biz.board.BoardDAO;
import com.choong.biz.board.BoardDTO;
import com.choong.biz.board.BoardFaqDTO;
import com.choong.biz.user.UserDTO;

@WebServlet("*.do5")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InsertServlet() {
        super();

    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//#1. 사용자 요청이 들어오면 요청 경로(path)를 추출
				final String URI = request.getRequestURI();
				final String PATH =	URI.substring(URI.lastIndexOf("/"));
				
				
				//요청에 따라 처리하기
				if(PATH.equals("/boardInsert.do5")) {
					boardInsert(request, response);
				}else if(PATH.equals("/boardFaqInsert.do5")) {
					boardFaqInsert(request, response);
				}
	}
	
	public void boardInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("글 추가 처리");
		HttpSession session = request.getSession();
		
		UserDTO user = (UserDTO) session.getAttribute("user");
		String boardUser = user.getUserId();
		String boardTitle = request.getParameter("boardTitle");
		String boardCategory = request.getParameter("boardCategory");
		String boardContent = request.getParameter("boardContent");
		String boardImage = request.getParameter("boardImage");
		
		
		System.out.println(boardUser);
		System.out.println(boardTitle);
		System.out.println(boardCategory);
		System.out.println(boardContent);
		
		BoardDTO dto = new BoardDTO();
		dto.setBoardTitle(boardTitle);
		dto.setBoardCategory(boardCategory);
		dto.setBoardUser(boardUser);
		dto.setBoardContent(boardContent);
		dto.setBoardImage(boardImage);
		


		BoardDAO dao = new BoardDAO();
		dao.insertBoard(dto);
		
		//추가한후에는 글 목록으로 이동
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("getBoard.do3");
		dispatcher.forward(request, response);
}
	public void boardFaqInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("글 추가 처리");
		HttpSession session = request.getSession();
		
		UserDTO user = (UserDTO) session.getAttribute("user");
		String boardFaqUser = user.getUserId();
		String boardFaqTitle = request.getParameter("boardFaqTitle");
		String boardFaqContent = request.getParameter("boardFaqContent");
		
		
		System.out.println(boardFaqUser);
		System.out.println(boardFaqTitle);
		System.out.println(boardFaqContent);
		
		BoardFaqDTO dto = new BoardFaqDTO();
		dto.setBoardFaqTitle(boardFaqTitle);
		dto.setBoardFaqUser(boardFaqUser);
		dto.setBoardFaqContent(boardFaqContent);
		


		BoardDAO dao = new BoardDAO();
		dao.insertBoardFaq(dto);
		
		//추가한후에는 글 목록으로 이동
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/getBoardFaq.do3");
		dispatcher.forward(request, response);
}
}
