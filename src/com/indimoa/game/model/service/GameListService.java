package com.indimoa.game.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.indimoa.common.JdbcTemplate;
import com.indimoa.game.model.dao.GameDAO;
import com.indimoa.game.model.vo.GameVO;

public class GameListService {
	
	public GameVO getGameVO(int bno) {
		GameVO vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = new GameDAO().getGameVO(conn, bno);
		JdbcTemplate.close(conn);
		return vo;
	}
	public int getGameCount() {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = new GameDAO().getGameCount(conn);
		JdbcTemplate.close(conn);
		return result;
	}
	public ArrayList<GameVO> selectGameList() {
		ArrayList<GameVO> volist = null;
		Connection conn = JdbcTemplate.getConnection();

		volist = new GameDAO().selectGmaeList(conn);

		JdbcTemplate.close(conn);
		return volist;
	}
	
	public ArrayList<GameVO> readGameListAll(){
		ArrayList<GameVO> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new GameDAO().readGmaeListAll(conn);
		
		JdbcTemplate.close(conn);
		return volist;
	}
	
	public int insertGame(GameVO vo) {
		int result = -1;
		int result2 = -1;
		Connection conn = JdbcTemplate.getConnection();
		JdbcTemplate.setAutoCommit(conn, false);
		
		if(result == 0) {  
			result = new GameDAO().insertGameList(conn, vo);
		System.out.println(" game update before");
		}
		JdbcTemplate.close(conn);
		return result;
	}
	

}