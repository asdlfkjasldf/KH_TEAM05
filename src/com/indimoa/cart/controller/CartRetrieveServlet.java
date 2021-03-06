package com.indimoa.cart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.cart.model.dao.CartDao;
import com.indimoa.cart.model.service.CartService;
import com.indimoa.cart.model.vo.Cart;
import com.indimoa.member.model.service.MemberService;

/**
 * Servlet implementation class CartRetrieveServlet
 */
@WebServlet("/cartretrieve")
public class CartRetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartRetrieveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/cart.jsp").forward(request, response);
    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("mm_id");
		System.out.println("mm_id : " + id);
		
		CartDao dao = CartDao.getInstance();
		Cart result = dao.cartRetrieve(id);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(result);

	}

}
