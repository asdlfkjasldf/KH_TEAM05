package com.indimoa.member.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.io.PrintWriter;


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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("WEB-INF/view/newMember.jsp").forward(request, response);
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
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
		
		Member vo = new Member();
		vo.setMm_id(id);
		vo.setMm_pwd(pwd);
		vo.setMm_name(name);
		vo.setMm_email(email);
		vo.setMm_phn(phn);
		vo.setMm_com(com);
		vo.setMm_profile(profile);
		vo.setMm_nickname(nickname);
		
		int result = mservice.insertMember(vo);
		if (result > 1) {
			out.println("회원가입이 완료됐습니다.");
			response.sendRedirect("main.jsp");
		} else {
			
		}
		
		
	}
}
