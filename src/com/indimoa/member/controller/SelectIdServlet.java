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
		
		String name = request.getParameter("mm_name");
		String enrollDate = request.getParameter("mm_enrolldate");
		String email = request.getParameter("mm_email");
		System.out.println("email : " + email);

		String id = new MemberService().selectId(name, email);
		System.out.println("mm_id : " + id);
		String page = "";
		if (id != null) {
			page = "/views/member/showId.jsp";
			request.setAttribute("mm_id", id);
		} else {
			page = "/views/member/findId.jsp";
		}
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
