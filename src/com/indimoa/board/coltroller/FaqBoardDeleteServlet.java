package com.indimoa.board.coltroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.board.model.service.FaqBoardService;
import com.indimoa.board.model.vo.FaqBoard;

/**
 * Servlet implementation class FaqBoardDeleteServlet
 */
@WebServlet("/faqdelete")
public class FaqBoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqBoardDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("no"));
		
		PrintWriter out = response.getWriter();
		
		FaqBoard vo = new FaqBoard(bno);
		int result = new FaqBoardService().deleteFaqBoard(vo);
		if (result == -1) {
			out.println("<br>게시글 삭제 실패");
			out.println("<br><a href='history.go(-1)'>돌아가기</a>");
		}else {
			out.println("<br>게시글이 삭제되었습니다.");
			out.println("<a href='./faq'>목록</a>");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
