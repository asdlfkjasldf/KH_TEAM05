package com.indimoa.board.coltroller;

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
 * Servlet implementation class NtBoardDeleteServlet
 */
@WebServlet("/noticedelete")
public class NtBoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NtBoardDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("no"));
//		Map<String, Object> mapNtBoardUpdate = new HashMap<String, Object>();
		
		PrintWriter out = response.getWriter();
		
		NtBoard vo = new NtBoard(bno);
		
		int result = new NtBoardService().deleteNtBoard(vo);
		if (result == -1) {
			out.println("<br>게시글 삭제 실패");
			out.println("<br><a href='history.go(-1)'>돌아가기</a>");
		}else {
			out.println("<br>게시글 삭제되었습니다.");
			out.println("<a href='./notice'>목록</a>");
		}
		
		
		//request.getRequestDispatcher("/noticedelete").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
