package com.indimoa.board.notice.coltroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.board.model.service.NtBoardService;
import com.indimoa.board.model.vo.NtBoard;

/**
 * Servlet implementation class NtBoardWriteServlet
 */
@WebServlet("/noticewrite")
public class NtBoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NtBoardWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//글쓰기 페이지로 이동시
		request.getRequestDispatcher("WEB-INF/view/ntboard_write.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ajax로 데이터 들어올시
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("t");
		String content = request.getParameter("c");
		String writer = (String)request.getSession().getAttribute("memberLgoinInfo"); //아직없음
		if( writer == null) {
			writer = "ADMIN";
		}
		
		out.println("입력된 title: " + title);
		out.println("입력된 content: " + content);
		
		NtBoard vo = new NtBoard(title,content, writer);
		
		int result = new NtBoardService().insertNtBoard(vo);
		if (result == -1) {
			out.println("<br>게시글 입력 실패");
		}else {
			out.println("<br>게시글 입력되었습니다.");
		}
		out.print("<a href=\"notice\">목록</a>");
		
		
	}

}
