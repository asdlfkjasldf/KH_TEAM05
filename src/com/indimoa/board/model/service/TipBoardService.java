package com.indimoa.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.indimoa.board.common.JdbcTemplate;
import com.indimoa.board.model.dao.TipBoardDao;
import com.indimoa.board.model.vo.TipBoard;


public class TipBoardService {
	public TipBoard getBoard(int bno) {
		TipBoard vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = new TipBoardDao().getBoard(conn, bno);
		JdbcTemplate.close(conn);
		return vo;
	}

	public int getBoardCount() {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = new TipBoardDao().getBoardCount(conn);
		JdbcTemplate.close(conn);
		return result;
	}

	public ArrayList<TipBoard> selectBoardList(int start, int end) {
		ArrayList<TipBoard> volist = null;
		Connection conn = JdbcTemplate.getConnection();

		volist = new TipBoardDao().selectBoardList(conn, start, end);

		JdbcTemplate.close(conn);
		return volist;
	}

	public ArrayList<TipBoard> selectBoardList() {
		ArrayList<TipBoard> volist = null;
		Connection conn = JdbcTemplate.getConnection();

		volist = new TipBoardDao().selectBoardList(conn);

		JdbcTemplate.close(conn);
		return volist;
	}

	public int insertBoard(TipBoard vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();

		result = new TipBoardDao().insertBoard(conn, vo);

		JdbcTemplate.close(conn);
		return result;
	}

}
