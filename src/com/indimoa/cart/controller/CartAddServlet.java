package com.indimoa.cart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.cart.model.dao.CartDao;
import com.indimoa.cart.model.service.CartService;
import com.indimoa.cart.model.vo.Cart;



/**
 * Servlet implementation class CartAddServlet
 */
@WebServlet("/cartadd")
public class CartAddServlet extends HttpServlet {
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		processRequest(request, response);
//	}
//    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//    	RequestDispatcher view = null;
//    	CartService cartService = new CartService();
//    	GameService gameService = new GameService();  //TODO
//    	Status status = new Status();   //TODO
//    	request.setAttribute("status", status);
//    	HttpSession httpSession = request.getSession();
//    	int mm_id = Integer.parseInt(request.getParameter("mm_id"));
//    	int gg_no = Integer.parseInt(request.getParameter("gg_no"));
//    	
//    	ArrayList<Game> game = null;
//    	GameService gs = new GameService();
//    	Game g = GameService.getAllGame();
//    	request.setAttribute("game", game);
//    	request.setAttribute("member", HttpSession.getAttribute("member"));
//    	try {
//    		CartService = new CartService();
//    		CartService.cartAdd(mm_id, gg_no);
//    		if(!status.isSuccessful()) {
//    			view = request.getRequestDispatcher("");  //성공시 이곳으로 이동
//    			view.forward(request, response);
//    		}
//    	}
//		
//	}
    
    
	public CartAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/cart.jsp");
    	rd.forward(request, response);
    }
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		Cart cart = new Cart();
		cart.setMm_id(request.getParameter("mm_id"));
		CartDao dao = CartDao.getInstance();
		int result = dao.cartAdd(cart);
		PrintWriter out = response.getWriter();
		out.println(result);
		
		
		
		
		CartService cservice = new CartService();
		String no = request.getParameter("ct_no");
		String id = request.getParameter("mm_id");
		String content = request.getParameter("ct_content");
		String date = request.getParameter("ct_date");
		String price = request.getParameter("ct_price");
		
		Cart vo = new Cart();
		vo.setMm_id(id);
		vo.setCt_content(content);

		
		int result1 = cservice.cartAdd(new Cart());   //TODO
		if (result1 > 0) {
			out.println("장바구니에 들어갔습니다.");
			response.sendRedirect("cartlist");
		}else {
			out.println("장바구니가 비어있습니다.");
			response.sendRedirect("cartlist");
		}
		
		
	}

}
