package com.indimoa.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.member.model.dao.MemberDao;
import com.indimoa.member.model.service.MemberService;
import com.indimoa.member.model.vo.Member;


/**
 * Servlet implementation class SelectIdServlet
 */
@WebServlet("/selectid")
public class SelectIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("WEB-INF/view/findId.jsp").forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("mm_name");
		String email = request.getParameter("mm_email");
		System.out.println("mm_name : " + name);
		System.out.println("mm_email : " + email);

		//id 불러오기
		int id = new MemberService().selectId(name, email);
		System.out.println("mm_id : " + id);
		String page = "";
		if (email.equals(email)) {
			response.sendRedirect("showid");
			request.setAttribute("mm_id", id);
		} else {
			//TODO
			response.sendRedirect("selectid");
		}
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	}
		
}
