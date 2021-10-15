package com.indimoa.game.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.game.model.service.GameService;
import com.indimoa.game.model.vo.Game;

/**
 * Servlet implementation class EnrollGameServletDo
 */
@WebServlet("/EnrollGameDo")
public class EnrollGameDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollGameDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
			  	response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		//GameService gservice = new GameService(); 

				//화면에서 받아 올 데이터
		//String gNostr =request.getParameter("ggNo"); ///번호 연습
		String gTitle =request.getParameter("ggTitle");
		String gPriceStr =request.getParameter("ggPrice");
		String gSystemRequirement =request.getParameter("ggSystemRequirement");
		String gGenre =request.getParameter("ggGenre");
		String gDeveloper =request.getParameter("ggDeveloper");
		String gReleaseDate = request.getParameter("ggReleaseDate");   //getParamater를 화면에 있는거 받아오니깐 무조건 String
		String gPublisher =request.getParameter("ggPublisher");
		String gLanguages =request.getParameter("ggLanguages");
		String gInfomation =request.getParameter("ggInfomation");

//		int gNo = 0;
//		try {
//			gNo= Integer.parseInt(gNostr);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		//입력받는 값은 스트링이지만 이걸 숫자로 바꿀거야 만약에 숫자가 아니면 0이 뜨고 걸릴거야 하지만 작업은 쭉쭉 진행되
		int gPrice =0;
		try {
			gPrice =Integer.parseInt(gPriceStr);
		} catch (Exception e) {
			e.printStackTrace();
		}


		Game vo = new Game();
		//vo.setGgNo(gNo);

		vo.setGgTitle(gTitle);
		vo.setGgPrice(gPrice);
		vo.setGgSystemRequirement(gSystemRequirement);
		vo.setGgGenre(gGenre);
		vo.setGgDeveloper(gDeveloper);
		vo.setGgReleaseDate(gReleaseDate);
		vo.setGgPublisher(gPublisher);
		vo.setGgLanguages(gLanguages);
		vo.setGgInfomation(gInfomation);

		int result = new GameService().insertGame(vo);

		
		response.sendRedirect("GameList");

		
	}

}



