package com.indimoa.manage.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.manage.member.model.service.MemberManagementListService;
import com.indimoa.member.model.vo.Member;

/**
 * Servlet implementation class MemberManagementDeleteServlet
 */
@WebServlet("/admindeletemembers")
public class MemberManagementDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberManagementDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
		
		// 입력한 데이터 수신
		// 여러개의 값을 수신할 때 getParameterValues()를 이용
		String checkNames[] = request.getParameterValues("checkName");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head></head><body>");
		if(checkNames == null) {
			out.println("선택한 항목이 없습니다.");
		} else {
			out.println("당신이 선택한 항목입니다.<br>");
			for(String checkName: checkNames) {
				out.println("[" + checkName + "] ");
				
				Member vo = new Member(checkName);		
				System.out.println(vo);
				int result = new MemberManagementListService().deleteMemberFromManagement(vo);
				if(result == 0) {
					out.println("<br>게시글 삭제되지 않았습니다.");
				} else {
					out.println("<br>게시글 삭제되었습니다.");
				}
				
				
				
			}
		}
		out.println("<br><a href='javascript:history.back(-2);'>다시</a>");
		out.println("</body></html>");

	}

}
