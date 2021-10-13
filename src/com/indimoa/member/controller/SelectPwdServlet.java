package com.indimoa.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.member.model.service.MemberService;


/**
 * Servlet implementation class SelectPwdServlet
 */
@WebServlet("/selectpwd")
public class SelectPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("WEB-INF/view/findPwd.jsp").forward(request, response);
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("mm_id");
		String name = request.getParameter("mm_name");
		String email = request.getParameter("mm_email");
		System.out.println("mm_id : " + id);
		System.out.println("mm_name : " + name);
		System.out.println("mm_email : " + email);
		// id불러오기
		int mid = new MemberService().selectId(name, email);
		System.out.println("mm_id : " + mid);
		String page = "";
		if (id.equals(id)) {
			page = "/WEB-INF/view/showPwd.jsp";
		}else {
			//TODO
			page = "/WEB-INF/view/findPwd.jsp";
		}
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	}
}

