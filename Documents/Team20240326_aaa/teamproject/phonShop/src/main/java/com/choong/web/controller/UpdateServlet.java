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
import com.choong.biz.product.ProductDAO;
import com.choong.biz.product.ProductDTO;


@WebServlet("*.do6")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//먼저 한글 필터 처리 부터 하기   

    public UpdateServlet() {
        super();
      
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//#1. 사용자 요청이 들어오면 요청 경로(path)를 추출
		final String URI = request.getRequestURI();
		final String PATH =	URI.substring(URI.lastIndexOf("/"));
		
		//요청에 따라 처리하기
		if(PATH.equals("/orderUpdate.do6")) {
			orderUpdate(request, response);
		}else if(PATH.equals("/boardUpdate.do6")) {
			boardUpdate(request, response);
		}else if(PATH.equals("/boardFaqUpdate.do6")) {
			boardFaqUpdate(request, response);
		}else if(PATH.equals("/getproductManagement.do6")) {
			productUpdate(request, response);
		}
		
		
	}
	
	
	public void productUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		 String productCode = request.getParameter("productCode");
	      String productDisplayStatus = request.getParameter("productDisplayStatus");
	      int productSalePrice = Integer.parseInt(request.getParameter("productSalePrice"));
	      int productInventoryQuantity = Integer.parseInt(request.getParameter("productInventoryQuantity"));
	      String productName = request.getParameter("productName");
	      int productSaleCount = Integer.parseInt(request.getParameter("productSaleCount"));
	      int productDiscountStatus = Integer.parseInt(request.getParameter("productDiscountStatus"));
	      int productOriginalPrice = Integer.parseInt(request.getParameter("productOriginalPrice"));
	      int productCostPrice = Integer.parseInt(request.getParameter("productCostPrice"));
	      String productPaymentType = request.getParameter("productPaymentType");
	      String productContent = request.getParameter("productContent");
	      String productImage = request.getParameter("productImage");
	      String productHashtags = request.getParameter("productHashtags");
	      String mainCategory = request.getParameter("mainCategory");
	      String subCategory = request.getParameter("subCategory");
	      int productBest = Integer.parseInt(request.getParameter("productBest"));

		
      
        //체크
        
        if(productName==null || productName.equals("")){
           
           request.getSession().setAttribute("messageType","오류 메시지");
           request.getSession().setAttribute("messageContent","필수 입력란은 모두 입력해주세요.");
           
           RequestDispatcher dispatcher = request.getRequestDispatcher("/");
           dispatcher.forward(request, response);
           
        //   return;
        }
        

        
        ProductDTO dto = new ProductDTO();
        dto.setProductCode(productCode);
        dto.setProductDisplayStatus(productDisplayStatus);
        dto.setProductSalePrice(productSalePrice);
        dto.setProductInventoryQuantity(productInventoryQuantity);
        dto.setProductName(productName);
        dto.setProductSaleCount(productSaleCount);
        dto.setProductDiscountStatus(productDiscountStatus);
        dto.setProductOriginalPrice(productOriginalPrice);
        dto.setProductCostPrice(productCostPrice);
        dto.setProductPaymentType(productPaymentType);
        dto.setProductContent(productContent);
        dto.setProductImage(productImage);
        dto.setProductHashtags(productHashtags);
        dto.setMainCategory(mainCategory);
        dto.setSubCategory(subCategory);
        dto.setProductBest(productBest);

   
        
        ProductDAO productDAO = new ProductDAO();
        productDAO.productUpdate(dto); //리턴값
        
        
         RequestDispatcher dispatcher = request.getRequestDispatcher("/getProductList.do3");
         dispatcher.forward(request, response);
         
         
         
         
}
	
	
	
		public void orderUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("글 수정 처리");
			
			int orderId = Integer.parseInt(request.getParameter("orderId"));  
			String orderDelivery = request.getParameter("orderDelivery");
			
			OrderDTO dto = new OrderDTO();
			dto.setOrderId(orderId);
			dto.setOrderDelivery(orderDelivery);

			
			System.out.println(dto.getOrderId());
			System.out.println(dto.getOrderDelivery());
			
			OrderDAO dao = new OrderDAO();
			dao.updateOrder(dto);
			
			//업데이트 후에는 글 목록으로 이동
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("getOrder.do3");
			dispatcher.forward(request, response);
	}
	
		public void boardUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("글 수정 처리");
			
			int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));  
			String boardTitle = request.getParameter("boardTitle");
			String boardCategory = request.getParameter("boardCategory");
			String boardContent = request.getParameter("boardContent");
			String boardImage = request.getParameter("boardImage");

			
			
			BoardDTO dto = new BoardDTO();
			dto.setBoardNumber(boardNumber);
			dto.setBoardTitle(boardTitle);
			dto.setBoardCategory(boardCategory);
			dto.setBoardContent(boardContent);
			dto.setBoardImage(boardImage);
		

			
			
			BoardDAO dao = new BoardDAO();
			dao.updateBoard(dto);
			
			//업데이트 후에는 글 목록으로 이동
			System.out.println(dto);
			RequestDispatcher dispatcher = request.getRequestDispatcher("getBoard.do3");
			dispatcher.forward(request, response);
	}
		
		public void boardFaqUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("글 수정 처리");
			
			int boardFaqNumber = Integer.parseInt(request.getParameter("boardFaqNumber"));  
			String boardFaqTitle = request.getParameter("boardFaqTitle");
			String boardFaqContent = request.getParameter("boardFaqContent");

			
			
			BoardFaqDTO dto = new BoardFaqDTO();
			dto.setBoardFaqNumber(boardFaqNumber);
			dto.setBoardFaqTitle(boardFaqTitle);
			dto.setBoardFaqContent(boardFaqContent);
		
			System.out.println(boardFaqNumber);
			
			
			BoardDAO dao = new BoardDAO();
			dao.updateBoardFaq(dto);
			
			//업데이트 후에는 글 목록으로 이동
			System.out.println(dto);
			RequestDispatcher dispatcher = request.getRequestDispatcher("getBoardFaq.do3");
			dispatcher.forward(request, response);
	}
		
		
}



