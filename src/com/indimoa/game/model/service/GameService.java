package com.indimoa.game.model.service;

import static com.indimoa.common.JdbcTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.indimoa.common.JdbcTemplate;
import com.indimoa.common.JdbcTemplate;
import com.indimoa.game.model.dao.GameDao;
import com.indimoa.game.model.vo.Game;

public class GameService {
	
	 public GameService() {
		 
	 }
	
	public Game getGame(int bno) {
		Game vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = new GameDao().getGame(conn, bno);
		JdbcTemplate.close(conn);
		return vo;
	}
//	public int getGameCount() {
//		int result = 0;
//		Connection conn = JdbcTemplate.getConnection();
//		result = new GameDao().getGameCount(conn);
//		JdbcTemplate.close(conn);
//		return result;
//	}
//	public ArrayList<Game> selectGameList() {
//		ArrayList<Game> volist = null;
//		Connection conn = JdbcTemplate.getConnection();
//
//		volist = new GameDao().selectGmaeList(conn, );
//
//		JdbcTemplate.close(conn);
//		return volist;
//	}
	
//	public ArrayList<Game> readGameListAll(){
//		ArrayList<Game> volist = null;
//		Connection conn = JdbcTemplate.getConnection();
//		volist = new GameDao().readGmaeListAll(conn);
//		
//		JdbcTemplate.close(conn);
//		return volist;
//	}
	
	public int getGameCount() {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = new GameDao().getGameCount(conn);
		JdbcTemplate.close(conn);
		return result;
	}
	
	public ArrayList<Game> selectGameList(int start, int end) {
		ArrayList<Game> volist = null;
		Connection conn = JdbcTemplate.getConnection();

		volist = new GameDao().selectGmaeList(conn, start, end);

		JdbcTemplate.close(conn);
		return volist;
	}
	
//	public ArrayList<Game> selectBoardList() {
//		ArrayList<Game> volist = null;
//		Connection conn = JdbcTemplate.getConnection();
//
//		volist = new GameDao().selectBoardList(conn);
//
//		JdbcTemplate.close(conn);
//		return volist;
//	}
	
//	public Game getBoard(int bno) {
//		Game vo = null;
//		Connection conn = JdbcTemplate.getConnection();
//		vo = new GameDao().getGamee(conn, bno);
//		JdbcTemplate.close(conn);
//		return vo;
//	}
	
	
	
	public int insertGame(Game ig, List<String> fileNames) { 
//		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
	
		//int result = new GameDao().insertGame(conn, ig); 
		int result = new GameDao().insertGame(conn, ig, fileNames);
		//int result2 = new GameDao().insertGameImage(conn, fileNames);

		if(result > 0) commit(conn);
		else rollback(conn);
		JdbcTemplate.close(conn);
		return result;
				
//			result = new GameDao().insertGame(conn, ig);
//		System.out.println(" GameService.insertGame 입니다.");
//		}
//		JdbcTemplate.close(conn);
//		return result;
		}
	
	
//	public int insertGame(Game vo) {
//		int result = -1;
//		int result2 = -1;
//		Connection conn = JdbcTemplate.getConnection();
//		JdbcTemplate.setAutoCommit(conn, false);
//		
//		if(result == 0) {  
//			result = new GameDao().insertGameList(conn, vo);
//		System.out.println(" game update before");
//		}
//		JdbcTemplate.close(conn);
//		return result;
//	}
	
	

}