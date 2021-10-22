package com.indimoa.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.member.model.service.MemberService;

/**
 * Servlet implementation class DupNicknameChkServlet
 */
@WebServlet("/dupnicknamechk")
public class DupNicknameChkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DupNicknameChkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/view/nicknameCheck.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService mservice = new MemberService();
		int result = mservice.dupNicknameChk(request.getParameter("mm_nickname"));
		PrintWriter out = response.getWriter();
		
		if(result > 0) {
			out.append("<script>alert('이미 있는 닉네임 입니다!);</script>");
		} else {
			out.append("<script>alert('사용 가능한 닉네임 입니다!);</script>");
		}
		out.flush();
		out.close();
	}

}
