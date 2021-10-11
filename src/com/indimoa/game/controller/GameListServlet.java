package com.indimoa.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.game.model.service.GameListService;
import com.indimoa.game.model.vo.GameVO;



/**
 * Servlet implementation class GameListServlet
 */
@WebServlet("/GameListServlet")
public class GameListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//	ArrayList<GameVO> volist = new GameListService().selectGameList();
//	request.setAttribute("volist", volist);		
//	request.getRequestDispatcher("/WEB-INF/view/gamelist.jsp").forward(request, response);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out  = response.getWriter();
		
		// member를 db에서 읽어와야함.
		ArrayList<GameVO> volist  = new GameListService().readGameListAll();
		
		// member 리스트를 화면에 출력
		for (GameVO vo : volist) {
			out.println("<p>" + vo.toString() + "</p>");
		}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
