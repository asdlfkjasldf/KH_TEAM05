package com.indimoa.game.model.dao;

import com.indimoa.common.JdbcTemplate;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.indimoa.game.model.vo.Game;

public class GameDao {

	public Game getGame(Connection conn, int bno) {
		Game vo = null;
		String sql = "select GG_NO,GG_TITLE,GG_PRICE,GG_SYSTEM_REQUIREMENTS,GG_GENRE,GG_DEVELOPER,GG_RELEASE_DATE,GG_PUBLISHER,GG_LANGUAGES,GG_INFORMATION"
				+ " from Game where GG_NO = ?";
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

	
	public ArrayList<Game> selectBoardList(Connection conn) {
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
				vo.setGgReleaseDate(rset.getDate("GG_RELEASE_DATE"));
					vo.setGgPublisher(rset.getString("GG_PUBLISHER"));
					vo.setGgLanguages(rset.getString("GG_LANGUAGES"));
					vo.setGgInfomation(rset.getString("GG_INFORMATION"));
				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		System.out.println("[pearl]-- 리턴은" + volist);
		return volist;
	}
	
	
	public ArrayList<Game> selectGmaeList(Connection conn, int start, int end) {
		ArrayList<Game> volist = null;
		String sql = "select * from game";
		sql ="select * from (select Rownum r, t1.* from (select * from game order by gg_no asc) t1 ) t2 where r between ? and ?";
		//이게 뭘 의미 할까?????????????????
		
		
		System.out.println("sql:" + sql);
		System.out.println("start:" + start);
		System.out.println("end:" + end);
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
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
					vo.setGgReleaseDate(rset.getDate("GG_RELEASE_DATE"));
					vo.setGgPublisher(rset.getString("GG_PUBLISHER"));
					vo.setGgLanguages(rset.getString("GG_LANGUAGES"));
					vo.setGgInfomation(rset.getString("GG_INFORMATION"));
					volist.add(vo);
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
		System.out.println("[gameDao selectGmaeList일껄?]--" + volist);
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
		ResultSet rset = null;
		System.out.println("0");
		try {
			pstmt  = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				System.out.println("1");
				volist = new ArrayList<Game>();
				do {
					Game vo = new Game();
					
					vo.setGgNo(rset.getInt("GG_NO"));
					vo.setGgTitle(rset.getString("GG_TITLE"));
					vo.setGgPrice(rset.getString("GG_PRICE"));
					vo.setGgSystemRequirement(rset.getString("GG_SYSTEM_REQUIREMENTS"));
					vo.setGgGenre(rset.getString("GG_GENRE"));
					vo.setGgDeveloper(rset.getString("GG_DEVELOPER"));
				vo.setGgReleaseDate(rset.getDate("GG_RELEASE_DATE"));
					vo.setGgPublisher(rset.getString("GG_PUBLISHER"));
					vo.setGgLanguages(rset.getString("GG_LANGUAGES"));
					vo.setGgInfomation(rset.getString("GG_INFORMATION"));
					volist.add(vo);
					System.out.println("3");
				}while (rset.next());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("4");
		}finally {
			try {
				rset.close();
				pstmt.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("DAO readGmaeListAll"+ volist);
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
	
	public int insertMember(Connection conn, Game g) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into member(GG_TITLE, GG_PRICE, GG_SYSTEM_REQUIREMENTS, GG_DEVELOPER, GG_RELEASE_DATE, GG_PUBLISHER, GG_LANGUAGES, GG_INFORMATION) "
				+ "values (?, ?, ?, ?, ?,sysdate, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, g.getGgTitle());
			pstmt.setString(2, g.getGgPrice());
			pstmt.setString(3, g.getGgSystemRequirement());
			pstmt.setString(4, g.getGgGenre());
			pstmt.setString(5, g.getGgDeveloper());
			pstmt.setDate(6, g.getGgReleaseDate());
			pstmt.setString(7, g.getGgPublisher());
			pstmt.setString(8, g.getGgLanguages());
			pstmt.setString(9, g.getGgInfomation());
			
			
			// executeupdate() 는 실행 결과를 반영된 행의 개수로 리턴하므로
			// 1 이상은 실행 성공, 0 이하(구문 에러 포함)는 실패이다.
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		return result;
	}

	public int getBoardCount(Connection conn) {
		int result = 0;
		String sql = "select count(GG_NO) from game";
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

	
	public Game getGamee(Connection conn, int bno) {
		Game vo = null;
//		String sql = "select TIP_NO,GD_GAMEDEVID,TIP_TITLE,TIP_CONTENT,TO_CHAR(TIP_DATETIME, 'yyyy-mm-dd') TIP_DATETIME, TIP_VISIT,TIP_REPLY,TIP_REPORT,bref, bre_level, Bre_step "
//				+ " from Tip_Board where TIP_NO = ?";
		
		String sql = "select GG_NO,GG_TITLE,GG_PRICE,GG_SYSTEM_REQUIREMENTS,GG_GENRE, GG_DEVELOPER, GG_RELEASE_DATE,GG_PUBLISHER,TIP_REPORT,GG_LANGUAGES, GG_INFORMATION "
				+ " from GAME where GG_NO = ?";
		
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				vo = new Game();
//				vo.setTipNo(rset.getInt("TIP_NO"));
//				vo.setGdGamedevid(rset.getString("GD_GAMEDEVID"));
//				vo.setTipTitle(rset.getString("TIP_TITLE"));
//				vo.setTipContent(rset.getString("TIP_CONTENT"));
//				vo.setTipDatetime(rset.getString("TIP_DATETIME"));
//				vo.setTipVisit(rset.getInt("TIP_VISIT"));
//				vo.setTipReply(rset.getInt("TIP_REPLY"));
//				vo.setTipReport(rset.getInt("TIP_REPORT"));
//				vo.setBref(rset.getInt("BREF"));
//				vo.setBreLevel(rset.getInt("BRE_LEVEL"));
//				vo.setBreStep(rset.getInt("BRE_STEP"));
				
				vo.setGgNo(rset.getInt("GG_NO"));
				vo.setGgTitle(rset.getString("GG_TITLE"));
				vo.setGgPrice(rset.getString("GG_PRICE"));
				vo.setGgSystemRequirement(rset.getString("GG_SYSTEM_REQUIREMENTS"));
				vo.setGgGenre(rset.getString("GG_GENRE"));
				vo.setGgDeveloper(rset.getString("GG_DEVELOPER"));
				vo.setGgReleaseDate(rset.getDate("GG_RELEASE_DATE"));
				vo.setGgPublisher(rset.getString("GG_PUBLISHER"));
				vo.setGgLanguages(rset.getString("GG_LANGUAGES"));
				vo.setGgInfomation(rset.getString("GG_INFORMATION"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		return vo;
	}



	

}