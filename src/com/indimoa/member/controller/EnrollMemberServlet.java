package com.indimoa.member.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.member.model.service.MemberService;
import com.indimoa.member.model.vo.Member;

/**
 * Servlet implementation class EnrollMemberServlet
 */
@WebServlet("/enrollmember")   //회원가입
public class EnrollMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService mservice = new MemberService();
		// 전달 받은 파라미터 값을 변수에 담아 새로운 객체를 생성한다
		String id = request.getParameter("mm_id");
		String pwd = request.getParameter("mm_pwd");
		String name = request.getParameter("mm_name");
		String email = request.getParameter("mm_email");
		String phn = request.getParameter("mm_phn");
		String com = request.getParameter("mm_com");
		String enrolldate = request.getParameter("mm_enrolldate");
		String profile = request.getParameter("mm_profile");
		String nickname = request.getParameter("mm_nickname");
		String membership = request.getParameter("mm_membership");
		String point = request.getParameter("mm_point");
		
		int result = mservice.insertMember(new Member());   //TODO
		if (result > 0) {
			response.sendRedirect("index.jsp");
		} else {
			
		}
		
	}
}
