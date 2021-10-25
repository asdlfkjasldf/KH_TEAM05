package com.indimoa.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.indimoa.member.model.service.MemberService;
import com.indimoa.member.model.vo.Member;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/memberlogin")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request, response);
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("/memberlogin 진입");

		// 사용자의 정보를 JSON형식으로 전달하기 위해 ContentType 변경
		response.setContentType("application/json;charset=UTF-8");
		MemberService mservice = new MemberService();
		String id = request.getParameter("mm_id");
		String pwd = request.getParameter("mm_pwd");
		System.out.println("mm_id: " + id);
		System.out.println("mm_pwd: " + pwd);
		
		PrintWriter out = response.getWriter();
		
		Gson gob = new GsonBuilder().setPrettyPrinting().create();   //console창에 보이게끔
		
		String gobStr = "";
		
		// 입력받은 사용자의 ID와 비밀번호를 인자로 하여 Service의 loginMember() 호출
//		List<Member> voList = new ArrayList<Member>();
		
		if ("ADMIN".equals(id)) {
			if ("adminpwd1234".equals(pwd)) {
				//아디,비번이 어드민일 경우 관리자 페이지로 이동
				System.out.println("ADMIN이니까 이동");
				Member admin = mservice.loginAdmin(id, pwd);
				HttpSession session = request.getSession();
				//session.setAttribute("memberLoginInfo", admin);
				session.setAttribute("voList", admin);
				System.out.println(admin);
				response.sendRedirect("./boardmanagement");
			}
		}
		
		Member m = mservice.loginMember(id, pwd);
		System.out.println("로그인 성공?????");
		if (m != null) { 			// 로그인 성공
			HttpSession session = request.getSession();
			System.out.println("로그인 성공!!!!!!!!");
			session.setAttribute("memberLoginInfo", m);
			session.setAttribute("voList", m);
			if(m.getMm_membership().equals("1") ) {
				session.setAttribute("memberGameDevIdSS", "testDev00");	
			} else if(m.getMm_membership().equals("2") ) {
				session.setAttribute("memberGameDevIdSS", "testDev01");	
			}else if(m.getMm_membership().equals("3") ) {
				session.setAttribute("memberGameDevIdSS", "testDev02");	
			}
			
			System.out.println(m);
			
//			voList.add(m);
			System.out.println("로그인성공~~~~~~~~~~~~~~~~~");
			response.sendRedirect("main");
			//request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request, response);
		} else {			//로그인 실패
			
//			//예시1
//			Map<String, Object> map2 = new HashMap<String, Object>();
//			map2.put("result","fail");
//			gobStr = gob.toJson(map2);
			response.sendRedirect("main");
		}
	}
}

