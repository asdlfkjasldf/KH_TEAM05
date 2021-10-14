package com.indimoa.manage.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.board.model.service.FbBoardService;
import com.indimoa.board.model.service.GbBoardService;
import com.indimoa.board.model.service.TipBoardService;
import com.indimoa.board.model.vo.*;
import com.indimoa.manage.board.service.BManagementService;

/**
 * Servlet implementation class BoardrManagementListServlet
 */
@WebServlet("/boardrmanagement")
public class BoardrManagementListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardrManagementListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		final int PAGE_SIZE = 5;
		final int PAGE_BLOCK = 3;
		int bCount = 0;
		int pageCount = 0;
		int startPage = 1;
		int endPage = 1;
		int currentPage = 1;
		int startRnum = 1;
		int endRnum;
		
		String pageNum = request.getParameter("p");
		if(pageNum != null) {
			currentPage = Integer.parseInt(pageNum);
		}
		bCount = new BManagementService().getBoardCount();
		pageCount = (bCount / PAGE_SIZE) + (bCount % PAGE_SIZE == 0 ? 0 : 1);
		// rownum 조건 계산
		startRnum =  (currentPage - 1) * PAGE_SIZE + 1; 
		endRnum = startRnum + PAGE_SIZE - 1;
		if(endRnum > bCount) {
			endRnum = bCount;
		}
		if(currentPage % PAGE_BLOCK == 0) {
			startPage = (currentPage / PAGE_BLOCK) * PAGE_BLOCK + 1;
		} else {
			startPage = (currentPage / PAGE_BLOCK) * + 1;
		}
		endPage = startPage + PAGE_BLOCK - 1;
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
//		System.out.println("메소드진입");
		String bmselect = request.getParameter("bmselect");
		out.println(bmselect);
 
//		String strResult = "";
		
		if(bmselect == null) {
			out.println("선택한 항목이 없습니다.");
		}else {
			out.println("당신이 선택한 항목입니다.<br>");
			out.println(bmselect);
			
		}
		
		
//		if(bmselect.equals("fb") ) {
//			ArrayList<FbBoard> volist = new FbBoardService().selectBoardList(startRnum, endRnum);
//			request.setAttribute("volist", volist);
//		}else if(bmselect.equals("gdb")) {
//			System.out.println("진입2");
//			ArrayList<GbBoard> volist = new GbBoardService().selectBoardList(startRnum, endRnum);
//			request.setAttribute("volist", volist);
//		}else if(bmselect.equals("tipb")) {
//			System.out.println("진입3");
//			ArrayList<TipBoard> volist = new TipBoardService().selectBoardList(startRnum, endRnum);
//			request.setAttribute("volist", volist);
//		}
//		
		
		
		
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("currentPage", currentPage);
		request.getRequestDispatcher("WEB-INF/Management/BoardManagementBoard.jsp").forward(request, response);
				
	}

}
