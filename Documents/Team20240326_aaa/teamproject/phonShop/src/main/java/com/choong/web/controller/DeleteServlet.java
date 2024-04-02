package com.choong.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.choong.biz.board.BoardDAO;
import com.choong.biz.board.BoardDTO;
import com.choong.biz.board.BoardFaqDTO;
import com.choong.biz.order.OrderDAO;
import com.choong.biz.order.OrderDTO;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("*.do4")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//#1. 사용자 요청이 들어오면 요청 경로(path)를 추출
		final String URI = request.getRequestURI();
		final String PATH =	URI.substring(URI.lastIndexOf("/"));
		if(PATH.equals("/orderDelete.do4")) {
			orderDelete(request,response);
			
			
		}else if(PATH.equals("/boardDelete.do4")) {
			boardDelete(request,response);
		}else if(PATH.equals("/boardFaqDelete.do4")) {
			boardFaqDelete(request,response);
		}
		
	}
	protected void orderDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("글 삭제 처리");
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		
		
		// 2. DB 연동 처리
		OrderDTO dto = new OrderDTO();
		dto.setOrderId(orderId);
		
		OrderDAO boardDAO = new OrderDAO();
		boardDAO.orderDelete(dto);
		
		// 3. 페이지 네비게이션
		RequestDispatcher dispatcher = 
			request.getRequestDispatcher("/getOrder.do3");
		dispatcher.forward(request, response);

	}
	
	protected void boardDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("글 삭제 처리");
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		
		
		// 2. DB 연동 처리
		BoardDTO dto = new BoardDTO();
		dto.setBoardNumber(boardNumber);
		
		BoardDAO BoardDAO = new BoardDAO();
		BoardDAO.deleteBoard(dto);
		
		// 3. 페이지 네비게이션
		RequestDispatcher dispatcher = 
			request.getRequestDispatcher("/getBoard.do3");
		dispatcher.forward(request, response);

	}
	
	protected void boardFaqDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("글 삭제 처리");
	    String[] boardNumberStrings = request.getParameterValues("boardFaqNumber");
	    
	    if (boardNumberStrings != null) {
	        int[] boardNumbers = new int[boardNumberStrings.length];
	        for (int i = 0; i < boardNumberStrings.length; i++) {
	            boardNumbers[i] = Integer.parseInt(boardNumberStrings[i]);
	        }
	        
	        // 2. DB 연동 처리
	        BoardDAO boardDAO = new BoardDAO();
	        for (int boardFaqNumber : boardNumbers) {
	            BoardFaqDTO dto = new BoardFaqDTO();
	            dto.setBoardFaqNumber(boardFaqNumber);
	            boardDAO.deleteBoardFaq(dto);
	        }
	    }
	    
	    // 3. 페이지 네비게이션
	    RequestDispatcher dispatcher = 
	        request.getRequestDispatcher("/getBoardFaq.do3");
	    dispatcher.forward(request, response);
	}
}
