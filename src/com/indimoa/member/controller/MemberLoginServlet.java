package com.indimoa.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자의 정보를 JSON형식으로 전달하기 위해 ContentType 변경
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		
		MemberService mservice = new MemberService();
		String id = request.getParameter("mm_id");
		String pwd = request.getParameter("mm_pwd");
		System.out.println("mm_id: " + id);
		System.out.println("mm_pwd: " + pwd);
		
		PrintWriter out = response.getWriter();
		
		Gson gob = new GsonBuilder().setPrettyPrinting().create();   //console창에 보이게끔

		
		String gobStr = "";
		
		// 입력받은 사용자의 ID와 비밀번호를 인자로 하여 Service의 loginMember() 호출
		List<Member> voList = new ArrayList<Member>(); 
		Member m = mservice.loginMember(id, pwd);
		if (m != null) { 			// 로그인 성공
			System.out.println("로그인성공");
			HttpSession session = request.getSession();
			session.setAttribute("member", m);
			
			
			voList.add(m);
			voList.add(m);
		
			
//예시 1
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("result", "ok");
			map2.put("name", m.getMm_name());
			map2.put("memberInfo", m);
			
			gobStr = gob.toJson(map2);
//결과
//				{
//				  "result": "ok",
//				  "memberInfo": {
//				    "id": "  ",
//				    "passwd": "  ",
//				    "name": "  ",
//				    "email": "aaa@test.or.kr"
//				  },
//				  "name": "  "
//				}
			
		} else {			//로그인 실패
			System.out.println("로그인 실패");
			//예시1
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("result","fail");
			gobStr = gob.toJson(map2);
		}
		System.out.println("gobStr : " + gobStr);
		out.println(gobStr);
		out.flush();
		out.close();
		}
	
	

	
	}

//TODO		
//		JSONObject job = new JSONObject();
//
//		// 입력받은 사용자의 ID와 비밀번호를 인자로 하여 Service의 loginMember() 호출
//		Member m = mservice.loginMember(id, passwd);
//		if (m != null) {
//			HttpSession session = request.getSession();
//			session.setAttribute("member", m);
//			job.put("result", "ok");
//			job.put("name", m.getName());
//		} else {
//			job.put("result", "fail");
//		}
//
//		out.println(job.toJSONString());
