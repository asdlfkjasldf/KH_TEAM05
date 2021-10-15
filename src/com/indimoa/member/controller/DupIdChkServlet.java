package com.indimoa.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.google.gson.Gson;
import com.indimoa.member.model.service.MemberService;


/**
 * Servlet implementation class DupIdChkServlet
 */
@WebServlet("/dupidchk")
public class DupIdChkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DupIdChkServlet() {}

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/view/newMember.jsp").forward(request, response);		
	}  
    
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService mservice = new MemberService();
		int result = mservice.dupIdChk(request.getParameter("mm_id"));
		PrintWriter out = response.getWriter();
		
		if(result > 0) {
			System.out.println("이미 있는 아이디입니다.");
		} else {
			System.out.println("사용 가능한 아이디입니다.");
		}
		out.flush();
		out.close();
	//TODO test로 확인
	}

}
