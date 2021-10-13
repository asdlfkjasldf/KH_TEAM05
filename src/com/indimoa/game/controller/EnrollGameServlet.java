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
		
		GameService gservice = new GameService(); 
		
				//화면에서 받아 올 데이터
		String gTitle =request.getParameter("ggTitle");
		String gPrice =request.getParameter("ggPrice");
		String gSystemRequirement =request.getParameter("ggSystemRequirement");
		String gGenre =request.getParameter("ggGenre");
		String gDeveloper =request.getParameter("ggDeveloper");
		String gReleaseDate = request.getParameter("ggReleaseDate");   //getParamater를 화면에 있는거 받아오니깐 무조건 String
		String gPublisher =request.getParameter("ggPublisher");
		String gLanguages =request.getParameter("ggLanguages");
		String gInfomation =request.getParameter("ggInfomation");
		
		
		Game vo = new Game();
		vo.setGgTitle(gTitle);
		vo.setGgPrice(gPrice);
		vo.setGgSystemRequirement(gSystemRequirement);
		vo.setGgGenre(gGenre);
		vo.setGgDeveloper(gDeveloper);
//		vo.setGgReleaseDate(gReleaseDate); // 타입 변경해야 될것 같은데???????????????
		vo.setGgPublisher(gPublisher);
		vo.setGgLanguages(gLanguages);
		vo.setGgInfomation(gInfomation);
		
		int result = gservice.insertGame(vo);
		
		
		//화면 데이터를 vo에  넣기
		
		//vo를 가지고 게임 등록하러 DAO로 
//		int result = new GameService().insertGame(vo);
//		if(result == 1 ) {
//			out.println("게임이 등록 되었습니다.");
//		}
		request.getRequestDispatcher("/WEB-INF/view/enrollgame.jsp").forward(request, response);
	}
	
	
}
