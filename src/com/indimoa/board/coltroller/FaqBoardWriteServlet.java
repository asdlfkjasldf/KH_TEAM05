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
 * Servlet implementation class FaqBoardWriteServlet
 */
@WebServlet("/faqwrite")
public class FaqBoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqBoardWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/view/faqboard/faqboard_write.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("t");
		String content = request.getParameter("c");
		//jhSeong todo
		String writer = (String)request.getSession().getAttribute("memberLgoinInfo"); //아직없음
		if( writer == null) {
			writer = "ADMIN";
		}
		out.println("입력된 title: " + title);
		out.println("입력된 content: " + content);
		
		FaqBoard vo = new FaqBoard(title, content, writer);
		
		int result = new FaqBoardService().insertFaqBoard(vo);
		if (result == -1) {
			out.println("<br>게시글 입력 실패");
		}else {
			out.println("<br>게시글 입력되었습니다.");
		}
		out.print("<a href='./faq'>목록</a>");
	}

}
