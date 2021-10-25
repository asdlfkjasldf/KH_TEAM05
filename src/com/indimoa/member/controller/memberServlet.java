package com.indimoa.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.indimoa.game.model.service.GameService;
import com.indimoa.game.model.vo.Game;
import com.indimoa.member.model.service.MemberService;
import com.indimoa.member.model.vo.Member;

/**
 * Servlet implementation class memberServlet
 */
@WebServlet("/myinfo")
public class memberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
//		int bno = Integer.parseInt(id);
		
		List<Member> voList = new ArrayList<Member>();
		Member m = new MemberService().getMember(id);
		HttpSession session = request.getSession();
		
		request.setAttribute("memberLoginInfo", m);
		session.setAttribute("voList", voList);
		
		voList.add(m);
		request.getRequestDispatcher("/WEB-INF/view/myInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
