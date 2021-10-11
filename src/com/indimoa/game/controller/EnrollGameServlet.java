package com.indimoa.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.game.medel.service.GameListService;
import com.indimoa.game.medel.vo.GameVO;

/**
 * Servlet implementation class EnrollGameServlet
 */
@WebServlet("/EnrollGameServlet")
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
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out  = response.getWriter();
		//화면에서 받아 올 데이터
		String ggTitle ="";
		String ggPrice ="";
		String ggSystemRequirement ="";
		String ggGenre ="";
		String ggDeveloper ="";
		Date ggReleaseDate =null;
		String ggPublisher ="";
		String ggLanguages ="";
		String ggInfomation ="";
		
		//화면 데이터를 vo에  넣기
		GameVO vo = new GameVO(ggTitle,ggPrice,ggSystemRequirement,ggGenre,ggDeveloper,ggReleaseDate,ggPublisher,ggLanguages,ggInfomation);
		
		//vo를 가지고 게임 등록하러 DAO로 
		int result = new GameListService().insertGame(vo);
		if(result == 1 ) {
			out.println("게임이 등록 되었습니다.");
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
