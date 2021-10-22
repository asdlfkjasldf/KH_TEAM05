package com.indimoa.manage.board.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.indimoa.board.model.vo.FaqBoard;
import com.indimoa.board.model.vo.FbBoard;
import com.indimoa.board.model.vo.GbBoard;
import com.indimoa.board.model.vo.NtBoard;
import com.indimoa.board.model.vo.TipBoard;
import com.indimoa.common.JdbcTemplate;
import com.indimoa.manage.board.dao.BoardManageMentDao;


public class BoardManagementUpdateService {

	public int updateFBoardList(FbBoard vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		
		result = new BoardManageMentDao().updateFBoard(conn, vo);
			
		JdbcTemplate.close(conn);
		return result;
	}

	public int updateGBoardList(GbBoard vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		
		result = new BoardManageMentDao().updateGBoard(conn, vo);
			
		JdbcTemplate.close(conn);
		return result;
	}

	public int updateTipBoardList(TipBoard vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		
		result = new BoardManageMentDao().updateTipBoard(conn, vo);
			
		JdbcTemplate.close(conn);
		return result;
	}

	public int updateNtBoardList(NtBoard vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		
		result = new BoardManageMentDao().updateNtBoardList(conn,vo);
		
		JdbcTemplate.close(conn);
		return result;
	}

	public int updateFaqBoardList(FaqBoard vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		
		result = new BoardManageMentDao().updateFaqBoardList(conn,vo);
		
		JdbcTemplate.close(conn);
		return result;
	}

}
