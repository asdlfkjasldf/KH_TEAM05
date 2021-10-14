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
import com.indimoa.member.model.vo.Member;

/**
 * Servlet implementation class FbBoardWriteDoServlet
 */
@WebServlet("/fbboardwrite.do")
public class FbBoardWriteDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FbBoardWriteDoServlet() {
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

		FbBoard oVo = null;
		String viewBno = request.getParameter("bno");
		System.out.println(viewBno);
		if (viewBno == null || viewBno.equals("")) { // 기존 읽고 있던 글이 없다면 원본 새글쓰기로 인식
			oVo = new FbBoard();
		} else {
			int bno = Integer.parseInt(viewBno);
			// 알아와야함. bref, bre_level, bre_step
			oVo = new FbBoardService().getBoard(bno);
		}

		System.out.println("oVo: " + oVo);
		String title = request.getParameter("title"); // 내용부분입력된값이지요
		String content = request.getParameter("content"); // 뭐라해야할지모를제목
		Member memberSS = (Member) request.getSession().getAttribute("member");
		String writer = memberSS.getMm_id();
		// TODO 임시코드로 확인이 필요함
		if (writer == null || writer.equals("")) {
			System.out.println("!!!!!임시 아이디!!!! testuser03");
			writer = "testuser03"; // "user01";
		}

		FbBoard vo = new FbBoard(oVo.getFbNo(), writer, title, content, oVo.getFbDatetime(), oVo.getFbVisit(), oVo.getFbReply(),
				oVo.getFbReport(), oVo.getBref(), oVo.getBreLevel(), oVo.getBreStep());
		System.out.println("vo: " + vo);
		int result = new FbBoardService().insertBoard(vo);
//		if(result == 0) {
//			out.println("<br>게시글 되지 않았습니다. <br>작성된 글에 비속어가 포함되어 있습니다. <br>다시 작성해 주세요.");
//		} else {
//			out.println("<br>게시글 입력되었습니다.");
//		}

		// request.getRequestDispatcher("boardlist").forward(request, response);
		response.sendRedirect("fbboardlist");

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
