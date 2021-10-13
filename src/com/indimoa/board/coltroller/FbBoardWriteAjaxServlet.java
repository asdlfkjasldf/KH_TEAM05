package com.indimoa.board.coltroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.board.model.service.FbBoardService;
import com.indimoa.board.model.vo.FbBoard;
import com.indimoa.board.model.vo.FbBoardR;

/**
 * Servlet implementation class FbBoardWriteDoServlet
 */
@WebServlet("/fbboardwrite.ajax")
public class FbBoardWriteAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FbBoardWriteAjaxServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String fbRContent = request.getParameter("fbRContent");
		String fbRNoStr = request.getParameter("fbRNo");
		int fbRNo = 0;
		try {
			fbRNo = Integer.parseInt(fbRNoStr);
		}catch(Exception e) {
			System.out.println("숫자변경 실패!!!");
			e.printStackTrace();
		}
		
		//TODO
		//String fbRId = request.getSession().getAttribute("로그인 attr 명");
		String fbRId = "testuser01";
		
		System.out.println("fbRContent: " +fbRContent);
		System.out.println("fbRNo: " +fbRNo);

		FbBoardR vo = new FbBoardR();
		vo.setFbRNo(fbRNo);
		vo.setFbRId(fbRId);
		vo.setFbRContent(fbRContent);
		int result = new FbBoardService().insertRBoard(vo);
		System.out.println("result : " + result);
		if(result > 0) {
			out.print("OK");
		} else {
			out.print("fail");
		}
		out.flush();
		out.close();   // ajax success 에 함수로 호출함.
		
	}

}
