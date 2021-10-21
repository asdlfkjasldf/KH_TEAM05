package com.indimoa.board.coltroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.board.model.service.GbBoardService;
import com.indimoa.board.model.vo.GbBoardR;

/**
 * Servlet implementation class GbBoardWriteAjaxServlet
 */
@WebServlet("/gbboardwrite.ajax")
public class GbBoardWriteAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GbBoardWriteAjaxServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String gbRContent = request.getParameter("gbRContent");
		String gbRNoStr = request.getParameter("gbRNo");
		int gbRNo = 0;
		try {
			gbRNo = Integer.parseInt(gbRNoStr);
		} catch (Exception e) {
			System.out.println("숫자변경 실패!!!");
			e.printStackTrace();
		}

		// TODO
		// String fbRId = request.getSession().getAttribute("로그인 attr 명");
		String gbRId = "testDev00";

		System.out.println("gbRContent: " + gbRContent);
		System.out.println("gbRNo: " + gbRNo);

		GbBoardR vo = new GbBoardR();
		vo.setGbRNo(gbRNo);
		vo.setGbRId(gbRId);
		vo.setGbRContent(gbRContent);
		int result = new GbBoardService().insertRBoard(vo);
		System.out.println("result : " + result);
		if (result > 0) {
			out.print("OK");
		} else {
			out.print("fail");
		}
		out.flush();
		out.close(); // ajax success 에 함수로 호출함.
	}

}
