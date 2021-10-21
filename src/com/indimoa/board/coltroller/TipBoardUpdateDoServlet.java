package com.indimoa.board.coltroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.board.model.service.TipBoardService;
import com.indimoa.board.model.vo.TipBoard;

/**
 * Servlet implementation class TipBoardUpdateDoServlet
 */
@WebServlet("/tboardupdate.do")
public class TipBoardUpdateDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipBoardUpdateDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TipBoard oVo = null;
		String viewBno = request.getParameter("bno");
		System.out.println("제발 숫자:" + viewBno);
			int bno = Integer.parseInt(viewBno);
			oVo = new TipBoardService().getBoard(bno);

		System.out.println("oVo: " + oVo);
		String title = request.getParameter("title"); // 내용부분입력된값이지요
		String content = request.getParameter("content"); // 뭐라해야할지모를제목
		String writer = (String) request.getSession().getAttribute("memberLoginInfo");
		// TODO 임시코드로 확인이 필요함
		if (writer == null || writer.equals("")) {
			writer = "testuser01"; // "user01";
		}

		TipBoard vo = new TipBoard(oVo.getTipNo(), writer, title, content, oVo.getTipDatetime(), oVo.getTipVisit(),
				oVo.getTipReply(), oVo.getTipReport(), oVo.getBref(), oVo.getBreLevel(), oVo.getBreStep());
		System.out.println("vo: " + vo);
		int result = new TipBoardService().updateBoard(vo);
		if( result >0 ) {
			response.sendRedirect("tboardcontent?no="+vo.getTipNo());
		} else {
			response.sendRedirect("tboardcontent?no="+vo.getTipNo());
		}
	}

}
