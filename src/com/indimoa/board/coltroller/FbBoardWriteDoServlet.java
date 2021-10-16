package com.indimoa.board.coltroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.indimoa.board.model.service.FbBoardService;
import com.indimoa.board.model.vo.FbBoard;
import com.indimoa.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FbBoardWriteDoServlet
 */
@WebServlet("/fbboardwrite.do")
public class FbBoardWriteDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FbBoardWriteDoServlet() {
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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		FbBoard oVo = null;
		String viewBno = request.getParameter("bno");
		System.out.println(viewBno);
		if (viewBno == null || viewBno.equals("")) { // 기존 읽고 있던 글이 없다면 원본 새글쓰기로 인식
			oVo = new FbBoard();
		} else {
			int bno = Integer.parseInt(viewBno);
			// 알아와야함. bref, bre_level, bre_step
			oVo = new FbBoardService().getBoard(bno);
		}

		System.out.println("oVo: " + oVo);
		String title = request.getParameter("title"); // 내용부분입력된값이지요
		String content = request.getParameter("content"); // 뭐라해야할지모를제목
		Member memberSS = (Member) request.getSession().getAttribute("member");
		String writer = memberSS.getMm_id();
		// TODO 임시코드로 확인이 필요함
		if (writer == null || writer.equals("")) {
			System.out.println("!!!!!임시 아이디!!!! testuser03");
			writer = "testuser03"; // "user01";
		}

		FbBoard vo = new FbBoard(oVo.getFbNo(), writer, title, content, oVo.getFbDatetime(), oVo.getFbVisit(),
				oVo.getFbReply(), oVo.getFbReport(), oVo.getBref(), oVo.getBreLevel(), oVo.getBreStep());
		System.out.println("vo: " + vo);
		int result = new FbBoardService().insertBoard(vo);

		// 파일 저장 경로 (web 경로 밑에 해당 폴더를 생성해 주어야 한다)
		String fileSavePath = "upload";
		// 파일 크기 10M 제한
		int uploadSizeLimit = 10 * 1024 * 1024;
		String encType = "UTF-8";

		// enctype="multipart/form-data" 로 전송되었는지 확인
		if (!ServletFileUpload.isMultipartContent(request))
			response.sendRedirect("view/error/Error.jsp");

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
		}
		
		response.sendRedirect("fbboardlist");

	}

}
