package com.indimoa.game.model.dao;

import com.indimoa.common.JdbcTemplate;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.indimoa.game.model.vo.Game;

public class GameDao {

	public Game getGame(Connection conn, int bno) {
		Game vo = null;
		String sql = "select GG_NO,GG_TITLE,GG_PRICE,GG_SYSTEM_REQUIREMENTS,GG_GENRE,GG_DEVELOPER,GG_RELEASE_DATE,GG_PUBLISHER,GG_LANGUAGES,GG_INFORMATION"
				+ " from GameVO where GG_NO = ?";
		// GG_NO
//		 GG_TITLE VARCHAR(20) NOT NULL,
//	    GG_PRICE NUMBER(11) NOT NULL,
//	    GG_SYSTEM_REQUIREMENTS VARCHAR(255) NOT NULL,
//	    GG_GENRE VARCHAR(255) NOT NULL,
//	    GG_DEVELOPER VARCHAR(30) NOT NULL, 
//	    GG_RELEASE_DATE TIMESTAMP NOT NULL,
//	    GG_PUBLISHER VARCHAR(20) NOT NULL,
//	    GG_LANGUAGES VARCHAR(30) NOT NULL,
//	    GG_INFORMATION VARCHAR(2000) NOT NULL,

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				vo = new Game();
				vo.setGgNo(rset.getInt("GG_NO"));
				vo.setGgTitle(rset.getNString("GG_TITLE"));
				vo.setGgPrice(rset.getNString("GG_PRICE"));
				vo.setGgSystemRequirement(rset.getNString("GG_SYSTEM_REQUIREMENTS"));
				vo.setGgGenre(rset.getNString("GG_GENRE"));
				vo.setGgDeveloper(rset.getNString("GG_DEVELOPER"));
//				vo.setGgReleaseDate(rset.getString("GG_RELEASE_DATE"));
				vo.setGgPublisher(rset.getNString("GG_PUBLISHER"));
				vo.setGgLanguages(rset.getNString("GG_LANGUAGES"));
				vo.setGgInfomation(rset.getString("GG_INFORMATION"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	
	
	
	public int getGameCount(Connection conn) {
		int result = 0;
		String sql = "select count(bno) from game";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		return result;
	}

	
	
	
	
	public ArrayList<Game> selectGmaeList(Connection conn) {
		ArrayList<Game> volist = null;
		String sql = "select * from game";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			volist = new ArrayList<Game>();
			if (rset.next()) {
				do {
					Game vo = new Game();
					vo = new Game();
					vo.setGgNo(rset.getInt("GG_NO"));
					vo.setGgTitle(rset.getString("GG_TITLE"));
					vo.setGgPrice(rset.getString("GG_PRICE"));
					vo.setGgSystemRequirement(rset.getNString("GG_SYSTEM_REQUIREMENTS"));
					vo.setGgGenre(rset.getString("GG_GENRE"));
					vo.setGgDeveloper(rset.getString("GG_DEVELOPER"));
//					vo.setGgReleaseDate(rset.getString("GG_RELEASE_DATE"));
					vo.setGgPublisher(rset.getString("GG_PUBLISHER"));
					vo.setGgLanguages(rset.getString("GG_LANGUAGES"));
					vo.setGgInfomation(rset.getString("GG_INFORMATION"));
				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("[pearl]--" + volist);
		return volist;
	}

	
	
	
	// 게임 등록 메소드
	public int enrollGame(String ggTitle, String ggPrice, String ggSystemRequirement, String ggGenre,
			String ggDeveloper, Date ggReleaseDate, String ggPublisher, String ggLanguages, String ggInfomation) { 
//	public int enrollGame(Connection conn, GameVO gameVO)//이건 안되나??
//	{
		String sql = "INSERT INTO GAME VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			Connection conn = JdbcTemplate.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ggTitle);
			pstmt.setString(2, ggPrice);
			pstmt.setString(3, ggSystemRequirement);
			pstmt.setString(4, ggGenre);
			pstmt.setString(5, ggDeveloper);
//			pstmt.setString(6, ggReleaseDate);
			pstmt.setString(7, ggPublisher);
			pstmt.setString(8, ggLanguages);
			pstmt.setString(9, ggInfomation);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	
	
	
	
//게임 읽기 메소드
	public ArrayList<Game> readGmaeListAll(Connection conn) {
		ArrayList<Game> volist = null;
		String sql = "select * from GAME";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("0");
		try {
			pstmt  = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("1");
				volist = new ArrayList<Game>();
				do {
					Game vo = new Game();
					
					vo.setGgNo(rs.getInt("GG_NO"));
					vo.setGgTitle(rs.getString("GG_TITLE"));
					vo.setGgPrice(rs.getString("GG_PRICE"));
					vo.setGgSystemRequirement(rs.getNString("GG_SYSTEM_REQUIREMENTS"));
					vo.setGgGenre(rs.getString("GG_GENRE"));
					vo.setGgDeveloper(rs.getString("GG_DEVELOPER"));
//					vo.setGgReleaseDate(rs.getString("GG_RELEASE_DATE"));
					vo.setGgPublisher(rs.getString("GG_PUBLISHER"));
					vo.setGgLanguages(rs.getString("GG_LANGUAGES"));
					vo.setGgInfomation(rs.getString("GG_INFORMATION"));
					volist.add(vo);
					System.out.println("3");
				}while (rs.next());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("4");
		}finally {
			try {
				rs.close();
				pstmt.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("리턴은"+ volist);
		return volist;
	}
	public int insertGameList(Connection conn, Game vo) {
		int result =-1;
		ArrayList<Game> volist = null;

		String sqlInsert = "INSERT INTO GAME"
				+ "(GG_NO, GG_TITLE, GG_PRICE, GG_SYSTEM_REQUIREMENTS, GG_GENRE , MM_ENRGG_DEVELOPEROLLDATE, GG_RELEASE_DATE, GG_PUBLISHER, GG_LANGUAGES, GG_INFORMATION)"
				+ " VALUES(?,?,?,?,?,?, ?,?,?,?)";
		PreparedStatement pstmt = null;
		

		try {
					
					pstmt = conn.prepareStatement(sqlInsert);
					pstmt.setInt(1, vo.getGgNo());
					pstmt.setString(2, vo.getGgTitle());
					pstmt.setString(3, vo.getGgPrice());
					pstmt.setString(4, vo.getGgSystemRequirement());
					pstmt.setString(5, vo.getGgGenre());
					pstmt.setString(6, vo.getGgDeveloper());
//					pstmt.setString(7, vo.getGgReleaseDate());
					pstmt.setString(8, vo.getGgPublisher());
					pstmt.setString(9, vo.getGgLanguages());
					pstmt.setString(10, vo.getGgInfomation());
					
					result = pstmt.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			} finally {
				JdbcTemplate.close(pstmt);
			}
		System.out.println("[admin]-- 리턴은" + volist);
		return result;
	}
	
	
	//다른 방법
	

}