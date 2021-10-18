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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.indimoa.member.model.dao.MemberDao;
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
	

		
		MemberService mservice = new MemberService();
		String id = request.getParameter("mm_id");
		String pwd = request.getParameter("mm_pwd");
		System.out.println("mm_id: " + id);
		System.out.println("mm_pwd: " + pwd);
		String url = ""; // forward할 주소를 지정하는 변수
		Member member = null;
		
		PrintWriter out = response.getWriter();
		MemberDao mDao = MemberDao.getInstance();
		
		
		// userid와 pwd DB에 있는지 유효성 검사
				int result = mDao.userCheck(id, pwd);

				switch (result) {
				case 1: // id와 pwd가 일치할 때
					// 사용자 정보를 DB에서 가져옴
					try {
						member = mDao.loginMember(id, pwd);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					HttpSession session = request.getSession();
					session.setAttribute("loginUser", member);
					request.setAttribute("message", "로그인에 성공하였습니다.");
					response.sendRedirect("index");
					break;
				case 0: // userid 일치 pwd 불일치
					request.setAttribute("message", "비밀번호가 맞지 않습니다.");
					response.sendRedirect("login");
					break;
				case -1: // userid가 존재하지 않음
					request.setAttribute("message", "존재하지않는 회원입니다.");
					response.sendRedirect("enrollmember");
					break;
				}

//				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//				dispatcher.forward(request, response);
			}
		
		
		
		
		
		
//		Gson gob = new GsonBuilder().setPrettyPrinting().create();   //console창에 보이게끔
//
//		
//		String gobStr = "";
//		
//		// 입력받은 사용자의 ID와 비밀번호를 인자로 하여 Service의 loginMember() 호출
//		List<Member> voList = new ArrayList<Member>(); 
//		Member m = mservice.loginMember(id, pwd);
//		if (m != null) { 			// 로그인 성공
//			System.out.println("로그인성공");
//			HttpSession session = request.getSession();
//			session.setAttribute("loginInfo", m);
//			
//			
//			voList.add(m);
//			voList.add(m);
//		
//			
////예시 1
//			Map<String, Object> map2 = new HashMap<String, Object>();
//			map2.put("result", "ok");
//			map2.put("name", m.getMm_name());
//			map2.put("memberInfo", m);
//			
//			gobStr = gob.toJson(map2);
////결과
////				{
////				  "result": "ok",
////				  "memberInfo": {
////				    "id": "  ",
////				    "passwd": "  ",
////				    "name": "  ",
////				    "email": "aaa@test.or.kr"
////				  },
////				  "name": "  "
////				}
//			
//		} else {			//로그인 실패
//			System.out.println("로그인 실패");
//			//예시1
//			Map<String, Object> map2 = new HashMap<String, Object>();
//			map2.put("result","fail");
//			gobStr = gob.toJson(map2);
//		}
//		System.out.println("gobStr : " + gobStr);
//		out.println(gobStr);
//		out.flush();
//		out.close();
//		}
	
	

	
	}

//TODO		
//		JSONObject job = new JSONObject();
//
//		// 입력받은 사용자의 ID와 비밀번호를 인자로 하여 Service의 loginMember() 호출
//		Member m = mservice.loginMember(id, passwd);
//		if (m != null) {
//			HttpSession session = request.getSession();
//			session.setAttribute("loginInfo", m);
//			job.put("result", "ok");
//			job.put("name", m.getName());
//		} else {
//			job.put("result", "fail");
//		}
//		
//		PrintWriter out = resopnse.getWriter();
//		out.println(job.toJSONString());
//		out.flush();
//		out.close();
