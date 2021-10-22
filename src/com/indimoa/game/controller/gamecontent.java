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
		
		
		//이미지 불러오기 위해
		
		ArrayList<Game> ivo = new GameService().getGameImage(bno);
		request.setAttribute("imagevo", ivo);
		
		
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
