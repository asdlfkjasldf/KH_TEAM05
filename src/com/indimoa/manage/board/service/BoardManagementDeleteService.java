package com.indimoa.manage.board.service;

import java.sql.Connection;

import com.indimoa.board.model.vo.FbBoard;
import com.indimoa.board.model.vo.GbBoard;
import com.indimoa.board.model.vo.TipBoard;
import com.indimoa.common.JdbcTemplate;
import com.indimoa.manage.board.dao.BoardManageMentDao;

public class BoardManagementDeleteService {

	public int deleteFBoardList(FbBoard vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		
		result = new BoardManageMentDao().deleteFBoard(conn,vo);
		
		JdbcTemplate.close(conn);
		return result;
	}

	public int deleteGBoardList(GbBoard vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		
		result = new BoardManageMentDao().deleteGBoard(conn,vo);
		
		JdbcTemplate.close(conn);
		return result;
	}

	public int deleteTipBoardList(TipBoard vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		
		result = new BoardManageMentDao().deleteTipBoard(conn,vo);
		
		JdbcTemplate.close(conn);
		return result;
	}

}
