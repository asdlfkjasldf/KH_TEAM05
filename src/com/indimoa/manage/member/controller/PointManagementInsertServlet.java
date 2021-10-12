package com.indimoa.manage.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.manage.member.model.service.MemberManagementListService;
import com.indimoa.member.model.vo.Member;

/**
 * Servlet implementation class PointManagementInsertServlet
 */
@WebServlet("/insert/point-from-management")
public class PointManagementInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PointManagementInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("insertPoint진입");
		// 입력한 데이터 수신
		// 여러개의 값을 수신할 때 getParameterValues()를 이용
		String targetids[] = request.getParameterValues("targetid");
		String point = request.getParameter("pointvalue");
//		System.out.println(targetids);
//		System.out.println(point);
		PrintWriter out = response.getWriter();
		
		out.println("<html><head></head><body>");
		if(targetids == null) {
			out.println("선택한 항목이 없습니다.");
		} else {
			out.println("당신이 선택한 항목입니다.<br>");
			for(String checkName: targetids) {
				out.println("[" + checkName + "] ");
				

				
				Member vo = new Member(Integer.parseInt(point),checkName);		
//				System.out.println(checkName);
//				System.out.println(point);
				System.out.println(vo);
				int result = new MemberManagementListService().insertPointFromManagement(vo);
				if(result == 0) {
					out.println("<br>포인트가 입력되지 않았습니다.");
				} else {
					out.println("<br>포인트가 입력되었습니다.");
				}
				
				}
			}	
		out.println("<br><a href='javascript:history.back();'>다시</a>");
		out.println("</body></html>");

		}
	}


