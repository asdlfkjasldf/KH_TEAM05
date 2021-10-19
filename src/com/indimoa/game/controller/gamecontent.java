package com.indimoa.game.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.game.model.service.GameService;
import com.indimoa.game.model.vo.Game;

/**
 * Servlet implementation class gamecontent
 */
@WebServlet("/gamecontent")
public class gamecontent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gamecontent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//		request.setCharacterEncoding("UTF-8");

		String no = request.getParameter("no");
		int bno = Integer.parseInt(no);
		
		Game vo = new GameService().getGame(bno);
		request.setAttribute("gamevo", vo);
		
		
		
//		ArrayList<Game> volist = new GameService().readGameListAll();
//		
//		for (Game vo : volist) {
////			System.out.println("<p>"+vo.toString()+"</p>");
//			
//			request.setAttribute("volist", volist);
//			
//		}
		
		
		
		request.getRequestDispatcher("/WEB-INF/view/gamecontent.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
