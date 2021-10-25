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
	
	
	
	public ArrayList<Game> getGameImage(int bno) {
		ArrayList<Game> ivo = null;
		Connection conn = JdbcTemplate.getConnection();
		ivo = new GameDao().getGameImage(conn, bno);
		JdbcTemplate.close(conn);
		return ivo;
	}

	
	
	
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


	public int insertGame(Game ig, List<String> fileNames) {
//		int result = -1;
		Connection conn = JdbcTemplate.getConnection();

		// int result = new GameDao().insertGame(conn, ig);
		int result = new GameDao().insertGame(conn, ig, fileNames);
		// int result2 = new GameDao().insertGameImage(conn, fileNames);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		JdbcTemplate.close(conn);
		return result;
	}


	// 기존 GAME 객체의 정보를 수정하는 메소드
	public int updateGame(Game g, List<String> fileNamess, int[] giNos ) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();

		result = new GameDao().updateGame(conn, g, fileNamess ,giNos);

		JdbcTemplate.close(conn);

		

		return result;
	}

		public ArrayList<Game> searchGame(Game vo) {
			ArrayList<Game> vosearchresult = null;
			Connection conn = JdbcTemplate.getConnection();
			vosearchresult = new GameDao().searchGame(conn,vo);
			
			JdbcTemplate.close(conn);
			return vosearchresult;
		} 
	

}