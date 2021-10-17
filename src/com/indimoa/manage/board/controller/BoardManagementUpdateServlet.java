package com.indimoa.manage.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
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
import com.indimoa.board.model.vo.FbBoard;
import com.indimoa.board.model.vo.GbBoard;
import com.indimoa.board.model.vo.TipBoard;
import com.indimoa.manage.board.service.BoardManagementUpdateService;

/**
 * Servlet implementation class BoardrManagementUpdateServlet
 */
@WebServlet("/boardmanagementupdate")
public class BoardManagementUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardManagementUpdateServlet() {
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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String bmselect = request.getParameter("bmselect"); //선택 옵션 파라미터 받기
		int bno = Integer.valueOf(request.getParameter("bno")); //바꿀 글번호
		String title = request.getParameter("t");	//받은 제목내용
		String content = request.getParameter("c"); //받은 글내용
		
		Map<String, Object> mapBoardUpdate = new HashMap<String, Object>();

		PrintWriter out = response.getWriter();
		
		
		
		if("fb".equals(bmselect) ) {
//			System.out.println("진입1");
			
			FbBoard vo = new FbBoard(title, content,bno);		
			
			int result = new BoardManagementUpdateService().updateFBoardList(vo);
			if(result == -1) {
				out.println("<br>게시글 수정되지 않았습니다. <br>작성된 글에 비속어가 포함되어 있습니다. <br>다시 작성해 주세요.");
			} else {
				out.println("<br>게시글 수정되었습니다.");
			}
		}else if("gdb".equals(bmselect)) {
//			System.out.println("진입2");
			GbBoard vo = new GbBoard(title, content,bno);		
			
			int result = new BoardManagementUpdateService().updateGBoardList(vo);
			if(result == -1) {
				out.println("<br>게시글 수정되지 않았습니다. <br>작성된 글에 비속어가 포함되어 있습니다. <br>다시 작성해 주세요.");
			} else {
				out.println("<br>게시글 수정되었습니다.");
			}
		}else if("tipb".equals(bmselect)) {
//			System.out.println("진입3");
			TipBoard vo = new TipBoard(title, content,bno);		
			
			int result = new BoardManagementUpdateService().updateTipBoardList(vo);
			if(result == -1) {
				out.println("<br>게시글 수정되지 않았습니다. <br>작성된 글에 비속어가 포함되어 있습니다. <br>다시 작성해 주세요.");
			} else {
				out.println("<br>게시글 수정되었습니다.");
			}
		}
		
		
		Gson gsonBoardUpdate = new Gson();
		String gobStr = gsonBoardUpdate.toJson(mapBoardUpdate);
		
		out.print(gobStr);
		out.flush();
		out.close();
	}

}
