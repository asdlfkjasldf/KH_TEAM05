package com.indimoa.board.coltroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.board.model.service.FbBoardService;

/**
 * Servlet implementation class FbBoardDeleteAjaxServlet
 */
@WebServlet("/fbboarddelete.ajax")
public class FbBoardDeleteAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FbBoardDeleteAjaxServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		String fbDstr = request.getParameter("fbNo");
		int fbDelete = 0;
		try {
			fbDelete = Integer.parseInt(fbDstr);
		} catch (Exception e) {
			System.out.println("숫자변경 실패!!!");
			e.printStackTrace();
		}
		System.out.println("fbDelete:"+fbDelete);
		// TODO
		// String fbRId = request.getSession().getAttribute("로그인 attr 명");
		int result = new FbBoardService().deleteBoard(fbDelete);
		if (result > 0) {
			out.print("OK");
		} else {
			out.print("fail");
		}
		out.flush();
		out.close(); // ajax success 에 함수로 호출함.
	}
}
