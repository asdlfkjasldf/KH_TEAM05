package com.indimoa.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.indimoa.common.JdbcTemplate;
import com.indimoa.board.model.dao.FbBoardDao;
import com.indimoa.board.model.vo.FbBoard;
import com.indimoa.board.model.vo.FbBoardR;

public class FbBoardService {
	public FbBoard getBoard(int bno) {
		FbBoard vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = new FbBoardDao().getBoard(conn, bno);
		JdbcTemplate.close(conn);
		return vo;
	}
	
	public FbBoardR getBoardR(int bno) {
		FbBoardR vor = null;
		Connection conn = JdbcTemplate.getConnection();
		vor = new FbBoardDao().getBoardR(conn, bno);
		JdbcTemplate.close(conn);
		return vor;
	}

	public int getBoardCount() {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = new FbBoardDao().getBoardCount(conn);
		JdbcTemplate.close(conn);
		return result;
	}

	public ArrayList<FbBoard> selectBoardList(int start, int end) {
		ArrayList<FbBoard> volist = null;
		Connection conn = JdbcTemplate.getConnection();

		volist = new FbBoardDao().selectBoardList(conn, start, end);

		JdbcTemplate.close(conn);
		return volist;
	}

	public ArrayList<FbBoard> selectBoardList() {
		ArrayList<FbBoard> volist = null;
		Connection conn = JdbcTemplate.getConnection();

		volist = new FbBoardDao().selectBoardList(conn);

		JdbcTemplate.close(conn);
		return volist;
	}

	public ArrayList<FbBoardR> selectBoardRList(int bno) {
		ArrayList<FbBoardR> vorlist = null;
		Connection conn = JdbcTemplate.getConnection();

		vorlist = new FbBoardDao().selectBoardRList(conn,bno);

		JdbcTemplate.close(conn);
		return vorlist;
	}
	
	public int updateBoard(FbBoard vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();

		result = new FbBoardDao().updateBoard(conn, vo);

		JdbcTemplate.close(conn);
		return result;
	}
	
	public int deleteBoard(int bno) {
		int result = -1;
		int result2 = -1;
		Connection conn = JdbcTemplate.getConnection();
//		JdbcTemplate.setAutoCommit(conn,false);
		System.out.println("여기여기");
		result = new FbBoardDao().deleteRBoard(conn, bno);   // 1  // -1   // 3
		result2 = new FbBoardDao().deleteBoard(conn, bno);   // 0  // 1   // -1
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

		result = new FbBoardDao().reportBoard(conn, bno);

		JdbcTemplate.close(conn);
		return result;
	}
	
	public int insertBoard(FbBoard vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();

		result = new FbBoardDao().insertBoard(conn, vo);

		JdbcTemplate.close(conn);
		return result;
	}
 
	public int insertRBoard(FbBoardR vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();

		result = new FbBoardDao().insertRBoard(conn, vo);

		JdbcTemplate.close(conn);
		return result;
	}
}
