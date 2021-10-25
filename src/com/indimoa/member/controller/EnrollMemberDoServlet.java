package com.indimoa.member.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.indimoa.member.model.service.MemberService;
import com.indimoa.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class EnrollMemberServlet
 */
@WebServlet("/enrollmemberdo")   //회원가입
public class EnrollMemberDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollMemberDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//request.getRequestDispatcher("/WEB-INF/view/newMember.jsp").forward(request, response);
    	
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	request.getRequestDispatcher("/WEB-INF/view/newMember.jsp").forward(request, response);
    	
    	System.out.println("DO페이지 진입");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("mm_id");
		System.out.println(id);
		String pwd = request.getParameter("mm_pwd");
		String name = request.getParameter("mm_name");
		String email = request.getParameter("mm_email");
		String phn = request.getParameter("mm_phn");
		String com = request.getParameter("mm_com");
		String nickname = request.getParameter("mm_nickname");
		String membership = request.getParameter("mm_membership");
		String point = request.getParameter("mm_point");
		
		String profile = request.getParameter("mm_profile");
		MemberService mservice = new MemberService();
//		
//		//첨부 파일 업로드 부분
//		
//				// 파일 경로
//				String imageSavePath = "upload";
//				
//				int uploadSizeLimit = 100*1024*1024;
//				String encType ="UTF-8";
//				
//				ServletContext context = getServletContext();
//				String uploadPath = context.getRealPath(imageSavePath);
//				
//				MultipartRequest multi = new MultipartRequest(request, uploadPath,uploadSizeLimit,encType,new DefaultFileRenamePolicy());
//				//request >  request 객체 
//				 //uploadPath > 서버 상 업로드 될 디렉토리 
//				 //uploadSizeLimit > 업로드 파일 크기 제한 
//				 //encType > 인코딩 방법 
//				 //new DefaultFileRenamePolicy() > 동일 이름 존재 시 새로운 이름 부여 방식 
//				Enumeration files = multi.getFileNames();
//				List<String> fileNames = new ArrayList<String>();
//				while(files.hasMoreElements()) {
//					String file =(String) files.nextElement();
//					String fileName = multi.getFilesystemName(file);
//					
//					out.println("<br> 첨부파일명 : " + fileName);
//					fileNames.add(fileName);
//				}
//		
//		
//		// 전달 받은 파라미터 값을 변수에 담아 새로운 객체를 생성한다
//		
//		
		//입력받는 값은 스트링이지만 이걸 숫자로 바꿀거야 만약에 숫자가 아니면 0이 뜨고 걸릴거야 하지만 작업은 쭉쭉 진행되
				int mm_point = 0;
				point = "0";
				try {
					mm_point =Integer.parseInt(point);// null 또는 "" 또는 "아1332ㅊ"
				} catch (Exception e) {
					e.printStackTrace();
					
				}
		
		
		
		
		
		Member vo = new Member(id,pwd,name,email,phn,com,nickname,membership,mm_point,profile);
		
		System.out.println("데이터: " +vo);
		
		
		int result = mservice.insertMember(vo);
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("userid", id);
			//TODO : 	session.setAttribute("memberLoginInfo", m);
			request.setAttribute("message1", "회원 가입 성공");
			response.sendRedirect("memberlogin");
		}else {
			request.setAttribute("message2", "회원 가입 실패");
			response.sendRedirect("enrollmember");
		}

//		request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request, response);
		//response.sendRedirect("myinfo");
		
	}
}
