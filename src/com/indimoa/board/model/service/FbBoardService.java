package com.indimoa.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.indimoa.common.JdbcTemplate;
import com.indimoa.board.model.dao.FbBoardDao;
import com.indimoa.board.model.vo.FbBoard;

public class FbBoardService {
	public FbBoard getBoard(int bno) {
		FbBoard vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = new FbBoardDao().getBoard(conn, bno);
		JdbcTemplate.close(conn);
		return vo;
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

	public int insertBoard(FbBoard vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();

		result = new FbBoardDao().insertBoard(conn, vo);

		JdbcTemplate.close(conn);
		return result;
	}

}
