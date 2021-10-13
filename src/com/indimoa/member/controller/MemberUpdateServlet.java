package com.indimoa.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.indimoa.member.model.service.MemberService;
import com.indimoa.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/memberupdate")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super(); 
        // TODO Auto-generated constructor stub
    }

    
    
    /**
   	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   	 */
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       	request.getRequestDispatcher("WEB-INF/view/myInfo.jsp").forward(request, response);
       }
       
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 기존의 생성된 세션과 세션에 담겨있던 “member” 객체를 불러온다.
				HttpSession session = request.getSession(false);
				Member m = (Member) session.getAttribute("member");
				MemberService mservice = new MemberService();
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
				PrintWriter out = response.getWriter();

				if (m != null && m.getMm_id().equals(id)) { // 만약 ID 값이 기존값과 일치한다면 수정 실행
					m.setMm_pwd(pwd);
					m.setMm_name(name);
					m.setMm_email(email);
					m.setMm_phn(phn);
					m.setMm_com(com);
					m.setMm_profile(profile);
					m.setMm_nickname(nickname);
					m.setMm_membership(membership);
					
					
					if (mservice.updateMember(m) > 0) {
						session.setAttribute("member", m);
						response.sendRedirect("WEB-INF/view/myInfo.jsp");
					} else {
						out.append("<script>alert('회원 정보 수정 오류!\n'+ '관리자에게 문의하세요!');</script>");
					}
				} else {
					RequestDispatcher view = request.getRequestDispatcher("WEB-INF/view/errorPage.jsp");
					request.setAttribute("msg", "회원 정보 수정 오류 발생!!");
					view.forward(request, response);
				}
				out.flush();
				out.close();
	}

}
