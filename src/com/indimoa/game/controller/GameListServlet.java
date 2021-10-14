package com.indimoa.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.game.model.service.GameService;
import com.indimoa.game.model.vo.Game;

/**
 * Servlet implementation class GameListServlet
 */
@WebServlet("/GameList")
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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out  = response.getWriter();
		
		final int PAGE_SIZE = 10; // 한 페이지 당 글수
		final int PAGE_BLOCK =5; // 한 화면에 나타날 페이지 링크 수
		int gCount = 0; // 총 글수
		int pageCount = 0; // 총 페이지수
		int startPage = 1; // 화면에 나타날 시작페이지
		int endPage = 1; // 화면에 나타날 마지막페이지
		int currentPage = 1;
		int startRnum = 1; // 화면에 글
		int endRnum = 1; // 화면에 글
		
		String pageNum = request.getParameter("pagenum");
		if (pageNum != null) { // 눌려진 페이지가 있음.
			currentPage = Integer.parseInt(pageNum); // 눌려진 페이지
		}
		
		// 총 글수
				gCount = new GameService().getGameCount();
				System.out.println("gCount : "+gCount);
				// 총 페이지수 = (총글개수 / 페이지당글수) + (총글개수에서 페이지당글수로 나눈 나머지가 0이 아니라면 페이지개수를 1 증가)
				pageCount = (gCount / PAGE_SIZE) + (gCount % PAGE_SIZE == 0 ? 0 : 1);
				// rownum 조건 계산
				startRnum = (currentPage - 1) * PAGE_SIZE + 1; // 1//6//11/16//21
				endRnum = startRnum + PAGE_SIZE - 1;
				if (endRnum > gCount)
					endRnum = gCount;

				if (currentPage % PAGE_BLOCK == 0) {
					startPage = (currentPage / PAGE_BLOCK - 1) * PAGE_BLOCK + 1;
				} else {
					startPage = (currentPage / PAGE_BLOCK) * PAGE_BLOCK + 1;
				}
				endPage = startPage + PAGE_BLOCK - 1;
				if (endPage > pageCount)
					endPage = pageCount;
				
				System.out.println("startRnum : " + startRnum);
				System.out.println("endRnum : "+ endRnum);
				
				
				
				ArrayList<Game> volist = new GameService().selectGameList(startRnum,endRnum );
				System.out.println("GameServlet:"+volist);
				
				
				//한번만 작동해도되!!!!!!!!
				request.setAttribute("volist", volist);
				request.setAttribute("startPage", startPage);
				request.setAttribute("endPage", endPage);
				request.setAttribute("pageCount", pageCount);
				request.setAttribute("currentPage", currentPage);
				request.getRequestDispatcher("/WEB-INF/view/gamelist.jsp").forward(request, response);
			}
				
				
				
				
		
		// member를 db에서 읽어와야함.
//		ArrayList<Game> volist  = new GameService().readGameListAll();
//		request.setAttribute("volist", volist);		
//		request.getRequestDispatcher("/WEB-INF/view/gamelist.jsp").forward(request, response);
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
