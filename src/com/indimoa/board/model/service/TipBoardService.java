package com.indimoa.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.indimoa.common.JdbcTemplate;
import com.indimoa.board.model.dao.TipBoardDao;
import com.indimoa.board.model.vo.TipBoard;
import com.indimoa.board.model.vo.TipBoardImg;


public class TipBoardService {
	public TipBoard getBoard(int bno) {
		TipBoard vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = new TipBoardDao().getBoard(conn, bno);
		JdbcTemplate.close(conn);
		return vo;
	}

	public TipBoardImg getImage(int bno) {
		TipBoardImg img = null;
		Connection conn = JdbcTemplate.getConnection();
		img = new TipBoardDao().getImage(conn, bno);
		JdbcTemplate.close(conn);
		return img;
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

	public int updateBoard(TipBoard vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();

		result = new TipBoardDao().updateBoard(conn, vo);

		JdbcTemplate.close(conn);
		return result;
	}
	
	public int deleteBoard(int bno) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
//		JdbcTemplate.setAutoCommit(conn,false);
		System.out.println("여기여기");
		result = new TipBoardDao().deleteBoard(conn, bno);   // 0  // 1   // -1
		
		JdbcTemplate.close(conn);
		return result;
	}
	
	public int reportBoard(int bno) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();

		result = new TipBoardDao().reportBoard(conn, bno);

		JdbcTemplate.close(conn);
		return result;
	}

	
	public int insertBoard(TipBoard vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();

		result = new TipBoardDao().insertBoard(conn, vo);

		JdbcTemplate.close(conn);
		return result;
	}

}
