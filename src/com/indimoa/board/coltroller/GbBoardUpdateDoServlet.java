package com.indimoa.board.coltroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.board.model.service.GbBoardService;
import com.indimoa.board.model.vo.GbBoard;

/**
 * Servlet implementation class GbBoardUpdateDoServlet
 */
@WebServlet("/gbboardupdate.do")
public class GbBoardUpdateDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GbBoardUpdateDoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GbBoard oVo = null;
		String viewBno = request.getParameter("bno");
		System.out.println("제발 숫자:" + viewBno);
		int bno = Integer.parseInt(viewBno);
		oVo = new GbBoardService().getBoard(bno);

		System.out.println("oVo: " + oVo);
		String title = request.getParameter("title"); // 내용부분입력된값이지요
		String content = request.getParameter("content"); // 뭐라해야할지모를제목
		String heading = request.getParameter("heading"); // 뭐라해야할지모를제목
		String writer = (String) request.getSession().getAttribute("memberLoginInfo");
		// TODO 임시코드로 확인이 필요함
		if (writer == null || writer.equals("")) {
			writer = "testuser01"; // "user01";
		}

		GbBoard vo = new GbBoard(oVo.getGbNo(), writer, heading, title, content, oVo.getGbDatetime(), oVo.getGbVisit(),
				oVo.getGbReply(), oVo.getGbReport(), oVo.getBref(), oVo.getBreLevel(), oVo.getBreStep());
		System.out.println("vo: " + vo);
		int result = new GbBoardService().updateBoard(vo);
		if (result > 0) {
			response.sendRedirect("gbboardcontent?no=" + vo.getGbNo());
		} else {
			response.sendRedirect("gbboardcontent?no=" + vo.getGbNo());
		}
	}

}
