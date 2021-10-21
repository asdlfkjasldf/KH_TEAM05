package com.indimoa.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.indimoa.board.model.dao.FaqBoardDao;
import com.indimoa.board.model.vo.FaqBoard;
import com.indimoa.common.JdbcTemplate;

public class FaqBoardService {

	public int getFaqBoardCount() {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = new FaqBoardDao().getBoardCount(conn);
		JdbcTemplate.close(conn);
		return result;
	}

	public ArrayList<FaqBoard> selectFaqBoardList(int start, int end) {
		ArrayList<FaqBoard> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		
		volist = new FaqBoardDao().selectFaqBoardList(conn,start,end);
		JdbcTemplate.close(conn);
		return volist;
	}

	public FaqBoard getFaqBoard(int bno) {
		FaqBoard vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = new FaqBoardDao().getFaqBoard(conn,bno);
		JdbcTemplate.close(conn);
		return vo;
	}

	public int insertFaqBoard(FaqBoard vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		
		result = new FaqBoardDao().insertFaqBoard(conn,vo);
		
		return result;
	}

}
