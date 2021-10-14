package com.indimoa.board.coltroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.board.model.service.FbBoardService;
import com.indimoa.board.model.vo.FbBoard;

/**
 * Servlet implementation class FbBoardUpdateDoServlet
 */
@WebServlet("/fbboardupdate.do")
public class FbBoardUpdateDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FbBoardUpdateDoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		FbBoard oVo = null;
		String viewBno = request.getParameter("bno");
		System.out.println("제발 숫자:" + viewBno);
			int bno = Integer.parseInt(viewBno);
			oVo = new FbBoardService().getBoard(bno);

		System.out.println("oVo: " + oVo);
		String title = request.getParameter("title"); // 내용부분입력된값이지요
		String content = request.getParameter("content"); // 뭐라해야할지모를제목
		String writer = (String) request.getSession().getAttribute("memberLoginInfo");
		// TODO 임시코드로 확인이 필요함
		if (writer == null || writer.equals("")) {
			writer = "testuser01"; // "user01";
		}

		FbBoard vo = new FbBoard(oVo.getFbNo(), writer, title, content, oVo.getFbDatetime(), oVo.getFbVisit(),
				oVo.getFbReply(), oVo.getFbReport(), oVo.getBref(), oVo.getBreLevel(), oVo.getBreStep());
		System.out.println("vo: " + vo);
		int result = new FbBoardService().updateBoard(vo);
		if( result >0 ) {
			response.sendRedirect("fbboardcontent?no="+vo.getFbNo());
		} else {
			response.sendRedirect("fbboardcontent?no="+vo.getFbNo());
		}
	}

}
