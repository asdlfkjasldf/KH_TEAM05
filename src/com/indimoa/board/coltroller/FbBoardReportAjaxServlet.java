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
 * Servlet implementation class FbBoardReportAjaxServlet
 */
@WebServlet("/fbboardreport.ajax")
public class FbBoardReportAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FbBoardReportAjaxServlet() {
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

		String fbRstr = request.getParameter("fbNo");
		int fbReport = 0;
		try {
			fbReport = Integer.parseInt(fbRstr);
		}catch(Exception e) {
			System.out.println("숫자변경 실패!!!");
			e.printStackTrace();
		}
		
		//TODO
		//String fbRId = request.getSession().getAttribute("로그인 attr 명");


		int result = new FbBoardService().reportBoard(fbReport);
		if(result > 0) {
			out.print("OK");
		} else {
			out.print("fail");
		}
		out.flush();
		out.close();   // ajax success 에 함수로 호출함.
		
	}

}
