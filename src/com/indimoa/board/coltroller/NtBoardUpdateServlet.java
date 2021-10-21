package com.indimoa.board.coltroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.board.model.service.NtBoardService;
import com.indimoa.board.model.vo.NtBoard;

/**
 * Servlet implementation class NtBoardUpdateServlet
 */
@WebServlet("/noticeupdate")
public class NtBoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NtBoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out = response.getWriter();
		int bno = Integer.parseInt(request.getParameter("no"));
		
		
		ArrayList<NtBoard> volist = new NtBoardService().loadNtBoardContent(bno);
		System.out.println(volist);
		request.setAttribute("loadedboardvo", volist);
			
		request.getRequestDispatcher("WEB-INF/view/noticeboard/ntboard_update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("t");	//받은 제목내용
		String content = request.getParameter("c"); //받은 글내용
		int bno = Integer.parseInt(request.getParameter("no"));
//		Map<String, Object> mapNtBoardUpdate = new HashMap<String, Object>();
		
		//PrintWriter out = response.getWriter();
		
		NtBoard vo = new NtBoard(title, content,bno);
		
		int result = new NtBoardService().updateNtBoard(vo);
		if(result == -1) {
			//out.println("<script>alert('글의 수정이 실패되었습니다.');</script>");
		} else {
			//out.println("<br>글의 수정이 성공");
		}
		
		
		request.getRequestDispatcher("/noticecontentview?no="+Integer.toString(bno)).forward(request, response);
		
//		Gson gsonNtBoardUpdate = new Gson();
//		String gobStr = gsonNtBoardUpdate.toJson(mapNtBoardUpdate);
//		
//		out.print(gobStr);;
//		out.flush();
//		out.close();
	}

}
