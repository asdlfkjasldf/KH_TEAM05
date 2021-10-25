package com.indimoa.board.coltroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indimoa.board.model.service.TipBoardService;
import com.indimoa.board.model.vo.TipBoard;
import com.indimoa.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class TipBoardWriteServlet
 */
@WebServlet("/tboardwrite.do")
public class TipBoardWriteDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TipBoardWriteDoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		TipBoard oVo = null;
		String viewBno = request.getParameter("bno");
		System.out.println("viewBno:" + viewBno);
		if (viewBno == null || viewBno.equals("")) { // 기존 읽고 있던 글이 없다면 원본 새글쓰기로 인식
			oVo = new TipBoard();
		} else {
			int bno = Integer.parseInt(viewBno);
			// 알아와야함. bref, bre_level, bre_step
			oVo = new TipBoardService().getBoard(bno);
		}

		// 파일 저장 경로 (web 경로 밑에 해당 폴더를 생성해 주어야 한다)
		String fileSavePath = "upload";
		// 파일 크기 10M 제한
		int uploadSizeLimit = 10 * 2048 * 2048;
		String encType = "UTF-8";

		ServletContext context = getServletContext();
		String uploadPath = context.getRealPath(fileSavePath);
		System.out.println(uploadPath);
		MultipartRequest multi = new MultipartRequest(request, // request 객체
				uploadPath, // 서버 상 업로드 될 디렉토리
				uploadSizeLimit, // 업로드 파일 크기 제한
				encType, // 인코딩 방법
				new DefaultFileRenamePolicy() // 동일 이름 존재 시 새로운 이름 부여 방식
		);
		// 업로드 된 파일 이름 얻어오기
		String file = multi.getFilesystemName("uploadFile");
		if (file == null) {
			System.out.println("업로드 실패");
		} else {
			System.out.println("업로드 성공");
			file = fileSavePath + "/" + file;
		}

		System.out.println("oVo: " + oVo);
		String title = multi.getParameter("title"); // 내용부분입력된값이지요
		String content = multi.getParameter("content"); // 뭐라해야할지모를제목
		String writer = "";
		Member memberSS = (Member) request.getSession().getAttribute("member");
		if (memberSS != null && !(memberSS.getMm_id().equals(""))) {
			writer = memberSS.getMm_id();
		} /*
			 * else { // TODO 임시코드로 확인이 필요함
			 * System.out.println("!!!!!임시 아이디!!!! testuser03"); writer = "testDev00"; //
			 * "user01"; }
			 */

		TipBoard vo = new TipBoard(oVo.getTipNo(), writer, title, content, oVo.getTipDatetime(), oVo.getTipVisit(),
				oVo.getTipReply(), oVo.getTipReport(), oVo.getBref(), oVo.getBreLevel(), oVo.getBreStep());
		System.out.println("vo: " + vo);
		int result = new TipBoardService().insertBoard(vo);
//		if(result == 0) {
//			out.println("<br>게시글 되지 않았습니다. <br>작성된 글에 비속어가 포함되어 있습니다. <br>다시 작성해 주세요.");
//		} else {
//			out.println("<br>게시글 입력되었습니다.");
//		}

		// request.getRequestDispatcher("boardlist").forward(request, response);
		response.sendRedirect("tboardlist");

	}

}
