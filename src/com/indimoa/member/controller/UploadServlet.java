package com.indimoa.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		
		//파일 저장 경로 (web 경로 밑에 해당 폴더를 생성해 주어야 한다)
		String fileSavePath = "upload";
		
		//TODO
		//폴더가 없다면 만들어주는 코드
		int uploadSizeLimit = 10 * 1024 * 1024;
		String encType = "UTF-8";
		
		//enctype="multipart/form-data"로 전송되었는지 확인
		if(!ServletFileUpload.isMultipartContent(request))
			response.sendRedirect("/WEB-INF/view/Error.jsp");
		
		ServletContext context = getServletContext();
		String uploadPath = context.getRealPath(fileSavePath);
		System.out.println(uploadPath);
		
		MultipartRequest multi = new MultipartRequest(request, //request객체
			uploadPath,  //서버 상 업로드 될 디렉토리
			uploadSizeLimit,  //업로드 파일 크기 제한
			encType,  //인코딩 방법
			new DefaultFileRenamePolicy()  //동일 이름 존재 시 새로운 이름 부여 방식
			);
		
		//업로드 된 파일 이름 얻어오기
		String file = multi.getFilesystemName("uploadPath");
		
		if(file == null) {
			//업로드 실패 시
			System.out.println("업로드 실패");
		} else {
			//업로드 성공 시
			out.println("업로드 성공");
		}
	}

}

