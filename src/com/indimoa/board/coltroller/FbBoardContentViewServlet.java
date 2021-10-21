package com.indimoa.board.coltroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.board.model.service.FbBoardService;
import com.indimoa.board.model.vo.FbBoard;
import com.indimoa.board.model.vo.FbBoardImg;
import com.indimoa.board.model.vo.FbBoardR;

/**
 * Servlet implementation class FbBoardContentViewServlet
 */
@WebServlet("/fbboardcontent")
public class FbBoardContentViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FbBoardContentViewServlet() {
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
		FbBoard vo = new FbBoardService().getBoard(bno);
		FbBoardR vor = new FbBoardService().getBoardR(bno);
		FbBoardImg img = new FbBoardService().getImage(bno);

		ArrayList<FbBoardR> vorlist = new FbBoardService().selectBoardRList(bno);
		request.setAttribute("vorlist", vorlist);
		request.setAttribute("boardvo", vo);
		request.setAttribute("boardvor", vor);
		request.setAttribute("uploadfile", img);
		request.getRequestDispatcher("/WEB-INF/view/fbboardcontent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
