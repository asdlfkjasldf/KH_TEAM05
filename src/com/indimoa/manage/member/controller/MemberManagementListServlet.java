package com.indimoa.manage.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.indimoa.manage.member.model.service.MemberManagementListService;
import com.indimoa.member.model.vo.Member;


/**
 * Servlet implementation class MemberManagementListServlet
 */
@WebServlet("/membermanagement")
public class MemberManagementListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberManagementListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchCondition = request.getParameter("sc");  //select 옵션 중에 고른 조건 
		String searchKeyword = request.getParameter("sk");  //input text에 들어간 키워드
		Member vo = new Member(searchCondition, searchKeyword);
		if (vo != null) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		final int PAGE_SIZE = 5;
		final int PAGE_BLOCK = 3; // 한 화면에 나타날 페이지 링크 수
		int bCount = 0; // 총 글 수
		int pageCount = 0; 
		int startPage = 1; // 화면에 나타날 시작 페이지
		int endPage = 1;  // 화면에 나타날 마지막
		int currentPage = 1; 
			//	Integer.parseInt 스트링을 인트로 Integer.parseInt Integer.parseInt
		int startRnum = 1; // 화면에 나타날 글
		int endRnum = 1; // 화면에 나타날 글
		String pageNum = request.getParameter("pagenum"); 
		if (pageNum != null) {
			currentPage = Integer.parseInt(request.getParameter("pagenum"));// 눌려진 페이지
		}

		
		
		System.out.println("doget 검색문진입");
//		out.println("입력된 title: "+ searchCondition); 작동확인
//		out.println("<br>입력된 content: "+ searchKeyword);

		
		

		
		
			System.out.println("vo : "+ vo);
			ArrayList<Member> searchvolist = new MemberManagementListService().selectBoardList(vo);
			System.out.println("searchvolist : " + searchvolist);	//검색 제대로 작동확인
			request.setAttribute("boardvolist", searchvolist);
			
			// 총 글수
			bCount = new MemberManagementListService().getBoardCount();
			//총 페이지수 = (총글개수 / 페이지당글수) + (총글개수에서 페이지당 글 수로 나눈 나머지가 0이 아니라면 나머지 페이지개수를 1 증가)
			pageCount = (bCount / PAGE_SIZE) + (bCount % PAGE_SIZE == 0 ? 0 : 1);
			//rownum 조건 계산
			
			startRnum = (currentPage-1) * PAGE_SIZE   + 1;   // 1//6//11/16//21
			endRnum = startRnum + PAGE_SIZE -1; 
			if(endRnum > bCount) endRnum=bCount;
			
			if(currentPage % PAGE_BLOCK == 0) {
				startPage = (currentPage / PAGE_BLOCK -1)  * PAGE_BLOCK + 1;
			} else {
				startPage = (currentPage / PAGE_BLOCK)  * PAGE_BLOCK + 1;
			}
			endPage = startPage + PAGE_BLOCK -1; 
			if(endPage > pageCount) endPage=pageCount;
			
			request.setAttribute("startPage", 1);
			request.setAttribute("endPage", 1);
			request.setAttribute("pageCount", 1);
//			아래 구문으로 적을 시 검색 페이지수가 아니라 모든 게시물의 페이징으로 나타남
//			request.setAttribute("startPage", startPage);
//			request.setAttribute("endPage", endPage);
//			request.setAttribute("pageCount", pageCount );
			//Page 이동하면서 Data도 전달함.
			if(searchKeyword != null) {
			request.getRequestDispatcher("WEB-INF\\Mangement\\MemberMangementBoard.jsp").forward(request, response);
			}
			
			
		}
		doPost(request, response);
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		response.setContentType("application/json;charset=UTF-8");


		
		final int PAGE_SIZE = 5;
		final int PAGE_BLOCK = 3; // 한 화면에 나타날 페이지 링크 수
		int bCount = 0; // 총 글 수
		int pageCount = 0; 
		int startPage = 1; // 화면에 나타날 시작 페이지
		int endPage = 1;  // 화면에 나타날 마지막
		int currentPage = 1; 
			//	Integer.parseInt 스트링을 인트로 Integer.parseInt Integer.parseInt
		int startRnum = 1; // 화면에 나타날 글
		int endRnum = 1; // 화면에 나타날 글
		String pageNum = request.getParameter("pagenum"); 
		if (pageNum != null) {
			currentPage = Integer.parseInt(request.getParameter("pagenum"));// 눌려진 페이지
		}
		
//		ajax용 추후 수정		
//		String searchmember = request.getParameter("pagenum"); 
//		String keywordoption = request.getParameter("keywordoption");
//		String keyword = request.getParameter("keyword");
//		System.out.println("keywordoption: " + keywordoption);
//		System.out.println("keyword: " + keyword);
//		
//		List<Member> membervolist  = new ArrayList<Member>(); 
//		Member m = keyword;
//		if (m != null) {
//			System.out.println("검색 준비 완료");
//			
//			
//		

		 
		
		
		
		
				
		// 총 글수
		bCount = new MemberManagementListService().getBoardCount();
		//총 페이지수 = (총글개수 / 페이지당글수) + (총글개수에서 페이지당 글 수로 나눈 나머지가 0이 아니라면 나머지 페이지개수를 1 증가)
		pageCount = (bCount / PAGE_SIZE) + (bCount % PAGE_SIZE == 0 ? 0 : 1);
		//rownum 조건 계산
		startRnum = (currentPage-1) * PAGE_SIZE   + 1;   // 1//6//11/16//21
		endRnum = startRnum + PAGE_SIZE -1; 
		if(endRnum > bCount) endRnum=bCount;
		
		if(currentPage % PAGE_BLOCK == 0) {
			startPage = (currentPage / PAGE_BLOCK -1)  * PAGE_BLOCK + 1;
		} else {
			startPage = (currentPage / PAGE_BLOCK)  * PAGE_BLOCK + 1;
		}
		endPage = startPage + PAGE_BLOCK -1; 
		if(endPage > pageCount) endPage=pageCount;
		
		ArrayList<Member> volist = new MemberManagementListService().selectBoardList(startRnum,endRnum);
		
		
		//Data 전달을 위해서 request에 셋
		request.setAttribute("boardvolist", volist);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount );
		//Page 이동하면서 Data도 전달함.
		request.getRequestDispatcher("WEB-INF\\Mangement\\MemberMangementBoard.jsp").forward(request, response);
	}		
	

}
