package com.indimoa.board.coltroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.board.model.service.TipBoardService;

/**
 * Servlet implementation class TipBoardDeleteAjaxServlet
 */
@WebServlet("/tboarddelete.ajax")
public class TipBoardDeleteAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipBoardDeleteAjaxServlet() {
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
		PrintWriter out = response.getWriter();
		
		String tipDstr = request.getParameter("tipNo");
		int tipDelete = 0;
		try {
			tipDelete = Integer.parseInt(tipDstr);
		} catch (Exception e) {
			System.out.println("숫자변경 실패!!!");
			e.printStackTrace();
		}
		System.out.println("tipDelete:"+tipDelete);
		// TODO
		// String fbRId = request.getSession().getAttribute("로그인 attr 명");
		int result = new TipBoardService().deleteBoard(tipDelete);
		if (result > 0) {
			out.print("OK");
		} else {
			out.print("fail");
		}
		out.flush();
		out.close(); // ajax success 에 함수로 호출함.
	}

}
