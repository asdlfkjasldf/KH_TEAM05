package com.indimoa.board.coltroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.board.model.service.GbBoardService;
import com.indimoa.board.model.vo.GbBoard;

/**
 * Servlet implementation class GbBoardWriteDoServlet
 */
@WebServlet("/gbboardwrite.do")
public class GbBoardWriteDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GbBoardWriteDoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		GbBoard oVo = null;
		String viewBno = request.getParameter("bno");
		System.out.println(viewBno);
		if (viewBno == null || viewBno.equals("")) { // 기존 읽고 있던 글이 없다면 원본 새글쓰기로 인식
			oVo = new GbBoard();
		} else {
			int bno = Integer.parseInt(viewBno);
			// 알아와야함. bref, bre_level, bre_step
			oVo = new GbBoardService().getBoard(bno);
		}

		System.out.println("oVo: " + oVo);
		String title = request.getParameter("title"); // 내용부분입력된값이지요
		String content = request.getParameter("content"); // 뭐라해야할지모를제목
		String heading = request.getParameter("heading"); // 뭐라해야할지모를제목
		String writer = (String) request.getSession().getAttribute("memberLoginInfo");
		// TODO 임시코드로 확인이 필요함
		if (writer == null || writer.equals("")) {
			writer = "testDev00"; // "user01";
		}

		GbBoard vo = new GbBoard(oVo.getGbNo(), writer, heading, title, content, oVo.getGbDatetime(), oVo.getGbVisit(), oVo.getGbReply(),
				oVo.getGbReport(), oVo.getBref(), oVo.getBreLevel(), oVo.getBreStep());
		System.out.println("vo: " + vo);
		int result = new GbBoardService().insertBoard(vo);
//		if(result == 0) {
//			out.println("<br>게시글 되지 않았습니다. <br>작성된 글에 비속어가 포함되어 있습니다. <br>다시 작성해 주세요.");
//		} else {
//			out.println("<br>게시글 입력되었습니다.");
//		}

		// request.getRequestDispatcher("boardlist").forward(request, response);
		response.sendRedirect("gbboardlist");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}