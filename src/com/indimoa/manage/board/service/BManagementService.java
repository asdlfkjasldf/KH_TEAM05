package com.indimoa.manage.board.service;

import java.sql.Connection;

import com.indimoa.board.model.dao.FbBoardDao;
import com.indimoa.board.model.dao.GbBoardDao;
import com.indimoa.board.model.dao.TipBoardDao;
import com.indimoa.common.JdbcTemplate;

public class BManagementService {

	public int fbGetBoardCount() {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = new FbBoardDao().getBoardCount(conn);
		JdbcTemplate.close(conn);
		return result;
	}
	public int gbGetBoardCount() {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = new GbBoardDao().getBoardCount(conn);
		JdbcTemplate.close(conn);
		return result;
	}
	public int tipGetBoardCount() {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = new TipBoardDao().getBoardCount(conn);
		JdbcTemplate.close(conn);
		return result;
	}
	

}
