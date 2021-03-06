package com.indimoa.board.coltroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.board.model.service.FbBoardService;
import com.indimoa.board.model.service.TipBoardService;
import com.indimoa.board.model.vo.FbBoardImg;
import com.indimoa.board.model.vo.TipBoard;

/**
 * Servlet implementation class TipBoardContentViewServlet
 */
@WebServlet("/tboardcontent")
public class TipBoardContentViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipBoardContentViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String no = request.getParameter("no");
		int bno = Integer.parseInt(no);
		TipBoard vo = new TipBoardService().getBoard(bno);
		FbBoardImg img = new FbBoardService().getImage(bno);

		request.setAttribute("boardvo", vo);
		request.setAttribute("uploadfile", img);
		request.getRequestDispatcher("/WEB-INF/view/tboardcontent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
