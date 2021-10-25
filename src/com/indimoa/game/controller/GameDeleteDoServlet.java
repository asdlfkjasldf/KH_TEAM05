package com.indimoa.game.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.game.model.service.GameService;
import com.indimoa.game.model.vo.Game;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class GameDeleteDoServlet
 */
@WebServlet("/GameDelete.do")
public class GameDeleteDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameDeleteDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int gno = Integer.parseInt(request.getParameter("no"));
		
		PrintWriter out = response.getWriter();
		
String imageSavePath = "upload";
		
		int uploadSizeLimit = 100*1024*1024;
		String encType ="UTF-8";
		
		ServletContext context = getServletContext();
		String uploadPath = context.getRealPath(imageSavePath);
		
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath,uploadSizeLimit,encType,new DefaultFileRenamePolicy());
		
		
		
		String gNostr= multi.getParameter("ggNo");
		String[] giNosStr = multi.getParameterValues("giNos");
		
		
		
		Game vo = new Game();
		//vo.setGiNo(gNostr);
		//vo.setGgNo(giNosStr);
		
		//int result = new GameService().
		
		
		
		//request.getRequestDispatcher("/WEB-INF/view/gamelist.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
