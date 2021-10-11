package com.indimoa.game.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.indimoa.common.JdbcTemplate;
import com.indimoa.game.model.dao.GameDao;
import com.indimoa.game.model.vo.Game;

public class GameService {
	
	public Game getGame(int bno) {
		Game vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = new GameDao().getGame(conn, bno);
		JdbcTemplate.close(conn);
		return vo;
	}
	public int getGameCount() {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = new GameDao().getGameCount(conn);
		JdbcTemplate.close(conn);
		return result;
	}
	public ArrayList<Game> selectGameList() {
		ArrayList<Game> volist = null;
		Connection conn = JdbcTemplate.getConnection();

		volist = new GameDao().selectGmaeList(conn);

		JdbcTemplate.close(conn);
		return volist;
	}
	
	public ArrayList<Game> readGameListAll(){
		ArrayList<Game> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new GameDao().readGmaeListAll(conn);
		
		JdbcTemplate.close(conn);
		return volist;
	}
	
	public int insertGame(Game vo) {
		int result = -1;
		int result2 = -1;
		Connection conn = JdbcTemplate.getConnection();
		JdbcTemplate.setAutoCommit(conn, false);
		
		if(result == 0) {  
			result = new GameDao().insertGameList(conn, vo);
		System.out.println(" game update before");
		}
		JdbcTemplate.close(conn);
		return result;
	}
	

}