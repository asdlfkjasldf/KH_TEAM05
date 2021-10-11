package com.indimoa.manage.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.manage.member.model.service.MemberManagementListService;
import com.indimoa.member.model.vo.Member;

/**
 * Servlet implementation class MemberManagementDeleteServlet
 */
@WebServlet("/delete/member-from-management")
public class MemberManagementDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberManagementDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response);
//		
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 화면입력 전달되어 옴. request - parameter (==변수명) : t, c
		// http://localhost:8090/myBoard/boardwrite.kh?c=내용부분입력된값이지요&t=뭐라해야할지모를제목
		String mm_id = (request.getParameter("id"));  //내용부분입력된값이지요
		
		out.println("입력된 id: "+ mm_id);


		Member vo = new Member(mm_id);		
		
		int result = new MemberManagementListService().deleteMemberFromManagement(vo);
		if(result == 0) {
			out.println("<br>게시글 삭제되지 않았습니다.");
		} else {
			out.println("<br>게시글 삭제되었습니다.");
		}
		
	}

}
