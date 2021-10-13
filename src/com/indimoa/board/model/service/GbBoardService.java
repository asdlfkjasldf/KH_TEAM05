package com.indimoa.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.indimoa.common.JdbcTemplate;
import com.indimoa.board.model.dao.GbBoardDao;
import com.indimoa.board.model.vo.GbBoard;
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

	public int insertBoard(GbBoard vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();

		result = new GbBoardDao().insertBoard(conn, vo);

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
