package com.indimoa.manage.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.indimoa.board.model.vo.FbBoard;
import com.indimoa.board.model.vo.GbBoard;
import com.indimoa.board.model.vo.TipBoard;
import com.indimoa.manage.board.service.BoardManagementDeleteService;

/**
 * Servlet implementation class BoardManagementDeleteServlet
 */
@WebServlet("/boardmanagementdelete")
public class BoardManagementDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardManagementDeleteServlet() {
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
		System.out.println("딜리트서블릿진입확인");
		String bmselect = request.getParameter("bmselect");
		int bno = Integer.parseInt(request.getParameter("bno"));
		//삭제라 제목,컨텐츠는 필요없다.
		//String title = request.getParameter("t");
		//String content = request.getParameter("c");
		
		Map<String, Object> mapBoardDelete = new HashMap<String, Object>();
		
		PrintWriter out = response.getWriter();
		
		if ("fb".equals(bmselect) ){
			
			FbBoard vo = new FbBoard(bno);
			int result = new BoardManagementDeleteService().deleteFBoardList(vo);
			if (result == -1) {
				mapBoardDelete.put("result", -1);
			}else {
				mapBoardDelete.put("result", 0);
			}
		}else if("gdb".equals(bmselect)) {
			GbBoard vo = new GbBoard(bno);
			int result = new BoardManagementDeleteService().deleteGBoardList(vo);
			if (result == -1) {
				mapBoardDelete.put("result", -1);
			}else {
				mapBoardDelete.put("result", 0);
			}
		}else if("tipb".equals(bmselect)) {
			TipBoard vo = new TipBoard(bno);
			int result = new BoardManagementDeleteService().deleteTipBoardList(vo);
		if (result == -1) {
			mapBoardDelete.put("result", -1);
		}else {
			mapBoardDelete.put("result", 0);
		}
		
		}
		
		Gson gsonBoardUpdate = new Gson();
		String gobStr = gsonBoardUpdate.toJson(mapBoardDelete);
		
		out.print(gobStr);
		out.flush();
		out.close();
	
	}
		
		

}
