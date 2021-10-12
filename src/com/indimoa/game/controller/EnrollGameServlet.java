package com.indimoa.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.game.model.service.GameService;
import com.indimoa.game.model.vo.Game;

/**
 * Servlet implementation class EnrollGameServlet
 */
@WebServlet("/EnrollGameServlet")   //게임등록
public class EnrollGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		GameService gameService = new GameService();
		
		
		//화면에서 받아 올 데이터
		String ggTitle =request.getParameter("");
		String ggPrice =request.getParameter("");
		String ggSystemRequirement =request.getParameter("");
		String ggGenre =request.getParameter("");
		String ggDeveloper =request.getParameter("");
//		Date ggReleaseDate = request.getParameter("");
		String ggPublisher =request.getParameter("");
		String ggLanguages =request.getParameter("");
		String ggInfomation =request.getParameter("");
		
		//화면 데이터를 vo에  넣기
		
		//vo를 가지고 게임 등록하러 DAO로 
//		int result = new GameService().insertGame(vo);
//		if(result == 1 ) {
//			out.println("게임이 등록 되었습니다.");
//		}
	}

}
