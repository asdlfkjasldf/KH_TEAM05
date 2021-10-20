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

}
