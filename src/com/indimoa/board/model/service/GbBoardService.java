package com.indimoa.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.indimoa.common.JdbcTemplate;
import com.indimoa.board.model.dao.FbBoardDao;
import com.indimoa.board.model.dao.GbBoardDao;
import com.indimoa.board.model.vo.FbBoard;
import com.indimoa.board.model.vo.FbBoardImg;
import com.indimoa.board.model.vo.GbBoard;
import com.indimoa.board.model.vo.GbBoardImg;
import com.indimoa.board.model.vo.GbBoardR;

public class GbBoardService {
	public GbBoard getBoard(int bno) {
		GbBoard vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = new GbBoardDao().getBoard(conn, bno);
		JdbcTemplate.close(conn);
		return vo;
	}

	public GbBoardR getBoardR(int bno) {
		GbBoardR vor = null;
		Connection conn = JdbcTemplate.getConnection();
		vor = new GbBoardDao().getBoardR(conn, bno);
		JdbcTemplate.close(conn);
		return vor;
	}
	
	public GbBoardImg getImage(int bno) {
		GbBoardImg img = null;
		Connection conn = JdbcTemplate.getConnection();
		img = new GbBoardDao().getImage(conn, bno);
		JdbcTemplate.close(conn);
		return img;
	}
	
	public int getBoardCount() {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = new GbBoardDao().getBoardCount(conn);
		JdbcTemplate.close(conn);
		return result;
	}

	public ArrayList<GbBoard> selectBoardList(int start, int end) {
		ArrayList<GbBoard> volist = null;
		Connection conn = JdbcTemplate.getConnection();

		volist = new GbBoardDao().selectBoardList(conn, start, end);

		JdbcTemplate.close(conn);
		return volist;
	}
	
	public ArrayList<GbBoardR> selectBoardRList(int bno) {
		ArrayList<GbBoardR> vorlist = null;
		Connection conn = JdbcTemplate.getConnection();

		vorlist = new GbBoardDao().selectBoardRList(conn, bno);

		JdbcTemplate.close(conn);
		return vorlist;
	}

	public ArrayList<GbBoard> selectBoardList() {
		ArrayList<GbBoard> volist = null;
		Connection conn = JdbcTemplate.getConnection();

		volist = new GbBoardDao().selectBoardList(conn);

		JdbcTemplate.close(conn);
		return volist;
	}

	public int updateBoard(GbBoard vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();

		result = new GbBoardDao().updateBoard(conn, vo);

		JdbcTemplate.close(conn);
		return result;
	}
	
	public int deleteBoard(int bno) {
		int result = -1;
		int result2 = -1;
		Connection conn = JdbcTemplate.getConnection();
//		JdbcTemplate.setAutoCommit(conn,false);
		System.out.println("여기여기");
		result = new GbBoardDao().deleteRBoard(conn, bno);   // 1  // -1   // 3
		result2 = new GbBoardDao().deleteBoard(conn, bno);   // 0  // 1   // -1
		System.out.println("댓글삭제갯수:" + result);
		System.out.println("원본삭제갯수:" + result2);
		if(result > 0  && result2 < 0) {
			JdbcTemplate.rollback(conn);
			result = 1;
		}
		else {
			JdbcTemplate.commit(conn);
			result = 1;
		}
		
		JdbcTemplate.close(conn);
		return result;
	}
	
	public int reportBoard(int bno) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();

		result = new GbBoardDao().reportBoard(conn, bno);

		JdbcTemplate.close(conn);
		return result;
	}
	
	public int insertBoard(GbBoard vo, String file) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		
		int bno = new GbBoardDao().getNextVal(conn);
		
		result = new GbBoardDao().insertBoard(conn, vo, bno);

		if(result>0) {
			GbBoardImg img = new GbBoardImg(file, bno);
			result = new GbBoardDao().insertImage(conn, img);
		}
		
		JdbcTemplate.close(conn);
		return result;
	}
	
	public int insertRBoard(GbBoardR vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();

		result = new GbBoardDao().insertRBoard(conn, vo);

		JdbcTemplate.close(conn);
		return result;
	}
}
