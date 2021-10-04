package com.indimoa.board.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.board.member.model.service.MemberService;
import com.indimoa.board.member.model.vo.Member;



/**
 * Servlet implementation class EnrollMemberServlet
 */
@WebServlet("/enroll")   //회원가입
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String mm_id = "indimoa2021";
		String mm_pwd = "Indimoa2021";
		String mm_email = "indimoa@naver.com";
		String mm_phn = "010-0000-0000";
		String mm_com = "WINDOW";
		String mm_profile = "";
		String mm_nickname = "indimoa";
		String mm_membership = "";
		
		Member vo = new Member(mm_id, mm_pwd, mm_email, mm_phn, mm_com, mm_profile, mm_nickname, mm_membership);
		int result = new MemberService().insertMember(vo);
		//오류 발생-1, 가입성공 1, 가입실패 0, 기존회원있으면 2, 가장큰수 0xFF
		if(result ==1) {
			out.println(mm_id + "님 가입되었습니다. 환영합니다.");
		}else if(result == 2) {
			out.println("기존회원 id가 존재합니다.");
		}else {
			out.println("예기치 못한 오류 발생");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
