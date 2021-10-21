package com.indimoa.board.coltroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.board.model.service.FaqBoardService;
import com.indimoa.board.model.vo.FaqBoard;


/**
 * Servlet implementation class FaqBoardListServlet
 */
@WebServlet("/faq")
public class FaqBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqBoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("faq게시판 진입");
		
		final int PAGE_SIZE = 5;
		final int PAGE_BLOCK = 3;
		int bCount = 0;
		int pageCount = 0;
		int startPage = 1;
		int endPage = 1;
		int currentPage = 1;
		int startRnum;
		int endRnum = 1;
		
		String pageNum = request.getParameter("p");
		if (pageNum != null) {
			currentPage = Integer.parseInt(pageNum);
		}
		bCount = new FaqBoardService().getFaqBoardCount();
		pageCount = (bCount / PAGE_SIZE) + (bCount % PAGE_SIZE == 0 ? 0 : 1);
		startRnum = (currentPage - 1) * PAGE_SIZE + 1;
		endRnum = startRnum + PAGE_SIZE - 1;
		if (endRnum > bCount) endRnum = bCount;
		
		if (currentPage % PAGE_BLOCK == 0) {
			startPage = (currentPage / PAGE_BLOCK - 1) * PAGE_BLOCK + 1;
		}else {
			startPage = (currentPage / PAGE_BLOCK) * PAGE_BLOCK + 1;
		}
		endPage = startPage + PAGE_BLOCK -1;
		if (endPage > pageCount) endPage=pageCount;
		
		ArrayList<FaqBoard> volist = new FaqBoardService().selectFaqBoardList(startRnum, endRnum);
		
		request.setAttribute("volist", volist);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		System.out.println(volist);
		request.getRequestDispatcher("WEB-INF/view/faqboard/faqboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
