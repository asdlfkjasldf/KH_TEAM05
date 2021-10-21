package com.indimoa.board.coltroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.board.model.service.FaqBoardService;
import com.indimoa.board.model.vo.FaqBoard;
//jhSeong
/**
 * Servlet implementation class FaqBoardUpdateServlet
 */
@WebServlet("/faqupdate")
public class FaqBoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqBoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out = response.getWriter();
		int bno = Integer.parseInt(request.getParameter("no"));
		
		
		ArrayList<FaqBoard> volist= new FaqBoardService().loadFaqBoardContent(bno);
		System.out.println(volist);
		request.setAttribute("loadedboardvo", volist);
		
		request.getRequestDispatcher("WEB-INF/view/faqboard/faqboard_update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("t");
		String content = request.getParameter("c");
		int bno = Integer.parseInt(request.getParameter("no"));
		
		FaqBoard vo = new FaqBoard(title, content, bno);
		
		int result = new FaqBoardService().updateFaqBoard(vo);
		if (result == -1) {
			
		}else {
			
		}
		
		request.getRequestDispatcher("./faqcontentview?no="+Integer.toString(bno)).forward(request, response);
		
	}

}
