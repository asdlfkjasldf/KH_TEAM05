package com.indimoa.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

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
 * Servlet implementation class GameUpdateDoServlet
 */
@WebServlet("/GameUpdate.do")
public class GameUpdateDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameUpdateDoServlet() {
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
		
String imageSavePath = "upload";
		
		int uploadSizeLimit = 100*1024*1024;
		String encType ="UTF-8";
		
		ServletContext context = getServletContext();
		String uploadPath = context.getRealPath(imageSavePath);
		
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath,uploadSizeLimit,encType,new DefaultFileRenamePolicy());
		
		
		Enumeration files = multi.getFileNames();
		List<String> fileNamess = new ArrayList<String>();
		while(files.hasMoreElements()) {
			String file =(String) files.nextElement();
			String fileName = multi.getFilesystemName(file);
			
			//이거 못쓰는거 아냐????
			System.out.println(fileName);
			out.println("<br> 첨부파일명 : " + fileName);
			fileNamess.add(fileName);
		}
		
		String gNostr= multi.getParameter("ggNo");
		String gTitle = multi.getParameter("ggTitle");  //null   ""
		String gPriceStr =multi.getParameter("ggPrice");
		String gSystemRequirement =multi.getParameter("ggSystemRequirement");
		String gGenre =multi.getParameter("ggGenre");
		String gDeveloper =multi.getParameter("ggDeveloper");
		String gReleaseDate = multi.getParameter("ggReleaseDate");   //getParamater를 화면에 있는거 받아오니깐 무조건 String
		String gPublisher =multi.getParameter("ggPublisher");
		String gLanguages =multi.getParameter("ggLanguages");
		String gInfomation =multi.getParameter("ggInfomation");
		

		String goriginFileAddress=multi.getParameter("originFileAddress");
		
		String[] giNosStr = multi.getParameterValues("giNos");
		
		int[] giNos = new int[4];
		try {
			for(int i=0; i < giNosStr.length; i++) {
				giNos[i]= Integer.parseInt(giNosStr[i]);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		int gNo = 0;
		try {
			gNo= Integer.parseInt(gNostr);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		int agPrice =0;
		try {
			agPrice =Integer.parseInt(gPriceStr);   // null 또는 "" 또는 "아1332ㅊ"
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		

		Game voo = new Game();
		voo.setGgNo(gNo);
		//voo.setGgNo(Integer.parseInt(gNo));
		voo.setGgTitle(gTitle);
		voo.setGgPrice(agPrice);
		voo.setGgSystemRequirement(gSystemRequirement);
		voo.setGgGenre(gGenre);
		voo.setGgDeveloper(gDeveloper);
		voo.setGgReleaseDate(gReleaseDate);
		voo.setGgPublisher(gPublisher);
		voo.setGgLanguages(gLanguages);
		voo.setGgInfomation(gInfomation);
		
		voo.setOriginFileAddress(goriginFileAddress);
		
		int result = new GameService().updateGame(voo, fileNamess, giNos );
		
	response.sendRedirect("gamecontent?no=" + voo.getGgNo());
		
	}

}
