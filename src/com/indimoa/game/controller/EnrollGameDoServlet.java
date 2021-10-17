package com.indimoa.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class EnrollGameServletDo
 */
@WebServlet("/EnrollGameDo")
public class EnrollGameDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollGameDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
			  	response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		GameService gservice = new GameService();

				//화면에서 받아 올 데이터
		//String gNostr =request.getParameter("ggNo"); ///번호 연습

		//첨부 파일 업로드 부분
		
		// 파일 경로
		String imageSavePath = "upload";
		
		int uploadSizeLimit = 100*1024*1024;
		String encType ="UTF-8";
		
		ServletContext context = getServletContext();
		String uploadPath = context.getRealPath(imageSavePath);
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath,uploadSizeLimit,encType,new DefaultFileRenamePolicy());
		//request >  request 객체 
		 //uploadPath > 서버 상 업로드 될 디렉토리 
		 //uploadSizeLimit > 업로드 파일 크기 제한 
		 //encType > 인코딩 방법 
		 //new DefaultFileRenamePolicy() > 동일 이름 존재 시 새로운 이름 부여 방식 
		Enumeration files = multi.getFileNames();
		List<String> fileNames = new ArrayList<String>();
		while(files.hasMoreElements()) {
			String file =(String) files.nextElement();
			String fileName = multi.getFilesystemName(file);
			
			//이거 못쓰는거 아냐????
			out.println("<br> 첨부파일명 : " + fileName);
			fileNames.add(fileName);
		}
		
		String gTitle = multi.getParameter("ggTitle");  //null   ""
		String gPriceStr =multi.getParameter("ggPrice");
		String gSystemRequirement =multi.getParameter("ggSystemRequirement");
		String gGenre =multi.getParameter("ggGenre");
		String gDeveloper =multi.getParameter("ggDeveloper");
		String gReleaseDate = multi.getParameter("ggReleaseDate");   //getParamater를 화면에 있는거 받아오니깐 무조건 String
		String gPublisher =multi.getParameter("ggPublisher");
		String gLanguages =multi.getParameter("ggLanguages");
		String gInfomation =multi.getParameter("ggInfomation");

//		int gNo = 0;
//		try {
//			gNo= Integer.parseInt(gNostr);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		//입력받는 값은 스트링이지만 이걸 숫자로 바꿀거야 만약에 숫자가 아니면 0이 뜨고 걸릴거야 하지만 작업은 쭉쭉 진행되
		int agPrice =0;
		try {
			agPrice =Integer.parseInt(gPriceStr);   // null 또는 "" 또는 "아1332ㅊ"
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		

		Game vo = new Game();
		//vo.setGgNo(gNo);
		vo.setGgTitle(gTitle);
		vo.setGgPrice(agPrice);
		vo.setGgSystemRequirement(gSystemRequirement);
		vo.setGgGenre(gGenre);
		vo.setGgDeveloper(gDeveloper);
		vo.setGgReleaseDate(gReleaseDate);
		vo.setGgPublisher(gPublisher);
		vo.setGgLanguages(gLanguages);
		vo.setGgInfomation(gInfomation);
		
		System.out.println("여기 데이터 들어오나: " +vo);
		

		int result = new GameService().insertGame(vo, fileNames);
//		if(result == 1 ) {
//			out.println(gTitle+"님 등록 되었습니다.");
//		} else if(result == 2) {
//			out.println("기존회원 id가 존재합니다. ");
//		} else {  // 오류발생:-1,그외 등등, 가입실패:0
//			out.println("예기치 못한 오류 발생. 다시 시도해 주세요. ");
//		}
		
		
		response.sendRedirect("GameList");

		
	}

}



