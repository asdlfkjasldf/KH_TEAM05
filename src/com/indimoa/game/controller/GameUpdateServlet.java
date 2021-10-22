package com.indimoa.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.indimoa.board.model.service.FbBoardService;
import com.indimoa.board.model.vo.FbBoard;
import com.indimoa.board.model.vo.GbBoard;
import com.indimoa.board.model.vo.TipBoard;
import com.indimoa.game.model.service.GameService;
import com.indimoa.game.model.vo.Game;
import com.indimoa.manage.board.service.BoardManagementUpdateService;

/**
 * Servlet implementation class GameUpdateServlet
 */
@WebServlet("/GameUpdate")
public class GameUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GameUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String no = request.getParameter("no");
		int bno = Integer.parseInt(no);
		
		Game vo = new GameService().getGame(bno);
		request.setAttribute("gamevo", vo);
		
		
		//이미지 불러오기 위해
		
		ArrayList<Game> ivo = new GameService().getGameImage(bno);
		request.setAttribute("imagevo", ivo);
		
		
		
		
		request.getRequestDispatcher("/WEB-INF/view/gameUpdate.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
