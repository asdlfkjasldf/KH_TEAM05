package com.indimoa.member.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.indimoa.member.model.service.MemberService;
import com.indimoa.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class EnrollMemberServlet
 */
@WebServlet("/enrollmember")   //회원가입
public class EnrollMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/WEB-INF/view/newMember.jsp").forward(request, response);
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String inputId = request.getParameter("inputId");
		PrintWriter out = response.getWriter();
		Map<String, Object> map1 = new HashMap<String,Object>();
		
		
		
		int result = new MemberService().dupIdChk(inputId);
		if (("ADMIN".equals(inputId)) || ("admin".equals(inputId)) ) {
			//운영자 계정 ID와 같을 경우 무조건 사용불가로 반환 DAO에서 SQL을 작성해 검사할건지 고려해봐야할 듯
			result = 1;
		}
		
		//1일 경우 중복id 있음 -1일경우 중복아님
		map1.put("result", result);
		
		Gson gson1 = new Gson();
		String gobStr = gson1.toJson(map1);
		out.print(gobStr);
		out.flush();
		out.close();
	}
	
}
