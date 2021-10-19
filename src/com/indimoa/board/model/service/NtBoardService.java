package com.indimoa.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.indimoa.board.model.dao.NtBoardDao;
import com.indimoa.board.model.vo.NtBoard;
import com.indimoa.common.JdbcTemplate;



public class NtBoardService {
	
	

	
	
	
	public ArrayList<NtBoard> selectNtBoardList(int startRnum, int endRnum) {
		ArrayList<NtBoard> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		
		volist = new NtBoardDao().selectNtBoardList(conn,startRnum,endRnum);
		
		JdbcTemplate.close(conn);
		return volist;
	}

	public int getNtBoardCount() {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = new NtBoardDao().getNtBoardCount(conn);
		JdbcTemplate.close(conn);
		return result;
	}
	
	public NtBoard getNtBoard(int bno) {
		NtBoard vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = new NtBoardDao().getNtBoard(conn, bno);
		JdbcTemplate.close(conn);
		return vo;
	}

	public int insertNtBoard(NtBoard vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		
		result = new NtBoardDao().insertNtBoard(conn,vo);
		
		return result;
	}

}
