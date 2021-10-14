package com.indimoa.board.coltroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.board.model.service.FbBoardService;
import com.indimoa.board.model.vo.FbBoard;
import com.indimoa.board.model.vo.FbBoardR;

/**
 * Servlet implementation class FbBoardUpdateServlet
 */
@WebServlet("/fbboardupdate")
public class FbBoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FbBoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String noStr = request.getParameter("no");
		int bno = 1;
		try {
			bno = Integer.parseInt(noStr);
		}catch(Exception e) {
			System.out.println("숫자변환실패");
			e.printStackTrace();
		}
		FbBoard vo = new FbBoardService().getBoard(bno);
		request.setAttribute("boardvo", vo);
		request.getRequestDispatcher("/WEB-INF/view/fbboardupdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
