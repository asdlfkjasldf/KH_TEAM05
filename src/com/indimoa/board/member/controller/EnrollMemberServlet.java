package com.indimoa.board.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.board.comm.JDBCTemplate;
import com.indimoa.board.member.model.service.MemberService;
import com.indimoa.board.member.model.vo.Member;
import com.sun.xml.internal.fastinfoset.sax.Properties;



/**
 * Servlet implementation class EnrollMemberServlet
 */
@WebServlet("/enroll")   //회원가입
public class EnrollMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollMemberServlet() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   

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
		String profile = request.getParameter("mm_profile");
		String nickname = request.getParameter("mm_nickname");
		String membership = request.getParameter("mm_membership");
		int result = mservice.insertMember(new Member(id, pwd, name, email, phn, com, profile, nickname, membership));
		if (result > 0) {
			response.sendRedirect("index.jsp");
		} else {
			
		}
		
	}
}
