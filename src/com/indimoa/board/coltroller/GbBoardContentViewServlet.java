package com.indimoa.board.coltroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.board.model.service.GbBoardService;
import com.indimoa.board.model.vo.GbBoard;
import com.indimoa.board.model.vo.GbBoardImg;
import com.indimoa.board.model.vo.GbBoardR;

/**
 * Servlet implementation class GbBoardContentViewServlet
 */
@WebServlet("/gbboardcontent")
public class GbBoardContentViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GbBoardContentViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String no = request.getParameter("no");
		int bno = Integer.parseInt(no);
		GbBoard vo = new GbBoardService().getBoard(bno);
		GbBoardR vor = new GbBoardService().getBoardR(bno);
		GbBoardImg img = new GbBoardService().getImage(bno);


		ArrayList<GbBoardR> vorlist = new GbBoardService().selectBoardRList(bno);
		request.setAttribute("vorlist", vorlist);
		request.setAttribute("boardvo", vo);
		request.setAttribute("boardvor", vor);
		request.setAttribute("uploadfile", img);
		request.getRequestDispatcher("/WEB-INF/view/gbboardcontent.jsp").forward(request, response);
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
