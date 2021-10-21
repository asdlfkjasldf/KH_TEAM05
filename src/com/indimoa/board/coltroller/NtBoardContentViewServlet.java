package com.indimoa.board.coltroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.board.model.service.NtBoardService;
import com.indimoa.board.model.vo.NtBoard;

/**
 * Servlet implementation class NtBoardContentViewServlet
 */
@WebServlet("/noticecontentview")
public class NtBoardContentViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NtBoardContentViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//		request.setCharacterEncoding("UTF-8");
		String no =  request.getParameter("no");
		// bno를 가지고 db에 하나 읽어 와야함
		int bno = Integer.parseInt(no);
		// bno는 pk로 결과는 Board 모양 1개일 것임.
		NtBoard vo = new NtBoardService().getNtBoard(bno);
		request.setAttribute("boardvo", vo);
		request.getRequestDispatcher("WEB-INF/view/noticeboard/ntboard_content.jsp").forward(request, response);
		//jsp, todo
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
