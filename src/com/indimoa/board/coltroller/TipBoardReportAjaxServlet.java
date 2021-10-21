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
 * Servlet implementation class TipBoardReportAjaxServlet
 */
@WebServlet("/tboardreport.ajax")
public class TipBoardReportAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipBoardReportAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String tipRstr = request.getParameter("tipNo");
		int tipReport = 0;
		try {
			tipReport = Integer.parseInt(tipRstr);
		}catch(Exception e) {
			System.out.println("숫자변경 실패!!!");
			e.printStackTrace();
		}
		
		//TODO
		//String fbRId = request.getSession().getAttribute("로그인 attr 명");


		int result = new TipBoardService().reportBoard(tipReport);
		if(result > 0) {
			out.print("OK");
		} else {
			out.print("fail");
		}
		out.flush();
		out.close();   // ajax success 에 함수로 호출함.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
