package com.indimoa.board.coltroller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.board.model.service.NtBoardService;
import com.indimoa.board.model.vo.NtBoard;
import com.indimoa.common.JdbcTemplate;




//공지사항 게시판의 리스트 서블릿
/**
 * Servlet implementation class NtBoardListServlet
 */
@WebServlet("/notice")
public class NtBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NtBoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		System.out.println("공지사항 게시판 리스트서블릿진입확인");
		String bno =  request.getParameter("no");
		
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
		bCount = new NtBoardService().getNtBoardCount();
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
		
		ArrayList<NtBoard> volist = new NtBoardService().selectNtBoardList(startRnum, endRnum);
		
		request.setAttribute("volist", volist);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		
		request.getRequestDispatcher("WEB-INF/view/ntboard.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
