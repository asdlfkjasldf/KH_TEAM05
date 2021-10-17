package com.indimoa.manage.board.controller;

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
import com.indimoa.board.model.service.GbBoardService;
import com.indimoa.board.model.service.TipBoardService;
import com.indimoa.board.model.vo.*;
import com.indimoa.manage.board.service.BManagementService;


/**
 * Servlet implementation class BoardrManagementListServlet
 */
@WebServlet("/boardmanagement")
public class BoardManagementListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardManagementListServlet() {
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
		
		bCount = new BManagementService().fbGetBoardCount();

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
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		request.getRequestDispatcher("WEB-INF/Management/BoardManagementBoard.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String bmselect = request.getParameter("bmselect"); //선택 옵션 파라미터 받기
		
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
		
		bCount = new BManagementService().fbGetBoardCount();
		if("fb".equals(bmselect) ) {
			bCount = new BManagementService().fbGetBoardCount();
		}else if("gdb".equals(bmselect)) {
			bCount = new BManagementService().gbGetBoardCount();
		}else if("tipb".equals(bmselect)) {
			bCount = new BManagementService().tipGetBoardCount();
		}
		
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

		
		System.out.println(bmselect);
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		
		if("fb".equals(bmselect) ) {
			System.out.println("진입1");
			ArrayList<FbBoard> volist = new FbBoardService().selectBoardList(startRnum, endRnum);
			map1.put("volist", volist);
		}else if("gdb".equals(bmselect)) {
			System.out.println("진입2");
			ArrayList<GbBoard> volist = new GbBoardService().selectBoardList(startRnum, endRnum);
			map1.put("volist", volist);
		}else if("tipb".equals(bmselect)) {
			System.out.println("진입3");
			ArrayList<TipBoard> volist = new TipBoardService().selectBoardList(startRnum, endRnum);
			map1.put("volist", volist);
		}
			
		map1.put("startPage", startPage);
		map1.put("endPage", endPage);
		map1.put("pageCount", pageCount);
		map1.put("currentPage", currentPage);

		Gson gson1 = new Gson();
		String gobStr = gson1.toJson(map1);
		out.print(gobStr);
		out.flush();
		out.close();
	}

}
