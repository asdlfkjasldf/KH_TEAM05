package com.indimoa.game.model.dao;

import com.indimoa.common.JdbcTemplate;

import static com.indimoa.common.JdbcTemplate.commit;
import static com.indimoa.common.JdbcTemplate.rollback;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.indimoa.game.model.vo.Game;
import com.indimoa.member.model.dao.MemberDao;
import com.indimoa.member.model.vo.Member;

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
				vo.setGgTitle(rset.getString("GG_TITLE"));
				vo.setGgPrice(rset.getInt("GG_PRICE"));
				vo.setGgSystemRequirement(rset.getNString("GG_SYSTEM_REQUIREMENTS"));
				vo.setGgGenre(rset.getString("GG_GENRE"));
				vo.setGgDeveloper(rset.getString("GG_DEVELOPER"));
				vo.setGgReleaseDate(rset.getString("GG_RELEASE_DATE"));
				vo.setGgPublisher(rset.getString("GG_PUBLISHER"));
				vo.setGgLanguages(rset.getString("GG_LANGUAGES"));
				vo.setGgInfomation(rset.getString("GG_INFORMATION"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	

	
						//게임 리스트업하는 메소드
	public ArrayList<Game> selectGmaeList(Connection conn, int start, int end) {
		ArrayList<Game> volist = null;
		//String sql = "select * from game";
		//게임이미지 테이블과 조인한것
		//String sql ="select * from game t1 left outer join game_image t2 on t1.gg_no = t2.gg_no";
		
		String sql ="select * from (select Rownum r, t1.* from (select * from game t1 left outer join game_image t2 using (gg_no) order by gg_no desc) t1 ) t2 where r between ? and ?";
		//String sql ="select * from (select Rownum r, t1.* from (select * from game order by gg_no asc) t1 ) t2 where r between ? and ?";
		//이게 뭘 의미 할까?????????????????
		
		
		//System.out.println("sql:" + sql);
		//System.out.println("start:" + start);
		//System.out.println("end:" + end);
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
					//vo = new Game();
					vo.setGgNo(rset.getInt("GG_NO"));
					vo.setGgTitle(rset.getString("GG_TITLE"));
					vo.setGgPrice(rset.getInt("GG_PRICE"));
					vo.setGgSystemRequirement(rset.getString("GG_SYSTEM_REQUIREMENTS"));
					vo.setGgGenre(rset.getString("GG_GENRE"));
					vo.setGgDeveloper(rset.getString("GG_DEVELOPER"));
					vo.setGgReleaseDate(rset.getString("GG_RELEASE_DATE"));
					vo.setGgPublisher(rset.getString("GG_PUBLISHER"));
					vo.setGgLanguages(rset.getString("GG_LANGUAGES"));
					vo.setGgInfomation(rset.getString("GG_INFORMATION"));
					
					//파일관ㄴ련해서넣ㄹ어야되
					vo.setGiNo(rset.getInt("GI_NO"));
				    vo.setOriginFileAddress(rset.getString("ORIGIN_FILE_ADDRESS"));
				    
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

	
	
	
	

	
	
	
	// DataBase에 Member 객체를 추가하는 메소드
	public int insertGame(Connection conn, Game g, List<String> fileNames) { 
		int result = -1;
	
		String sql = "INSERT INTO GAME"	 
				+ "(GG_NO,"
				+ "GG_TITLE,"
				+ "GG_PRICE,"
				+ "GG_SYSTEM_REQUIREMENTS,"
				+ "GG_GENRE,"
				+ "GG_DEVELOPER,"
				+ "GG_RELEASE_DATE,"
				+ "GG_PUBLISHER,"
				+ "GG_LANGUAGES,"
				+ "GG_INFORMATION)"
				+ "values (?,?,?,?,?,"
				+ "?,TO_DATE(?,'YY/MM/DD'),?,?,?)";
		
		String sqlSeqNextVal = "select SEQ_GAME_GG_NO.nextval from dual";
		
		//TODO
//		GI_NO               NOT NULL NUMBER(11)    
//		GG_NO               NOT NULL NUMBER(11)    
//		ORIGIN_FILE_ADDRESS NOT NULL VARCHAR2(300) 
		
		String sql2 = "INSERT INTO GAME_IMAGE"	 
				+ "(GI_NO,GG_NO,ORIGIN_FILE_ADDRESS)"
				+ "values (SEQ_GAME_IMAGE_GI_NO.nextval,?,?)";
		
		int nextVal = 0;
		
		//SEQ_GAME_GG_NO.nextval,"
		//System.out.println("insertGame sql:"+ sql);
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			//sqlSeqNextVal
			pstmt = conn.prepareStatement(sqlSeqNextVal);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				nextVal = rset.getInt(1);
			}
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
			
			System.out.println("nextval: "+ nextVal);
			
			//sql
			pstmt = conn.prepareStatement(sql);
			int i = 0;
			pstmt.setInt(++i, nextVal);  
			pstmt.setString(++i,g.getGgTitle());
			pstmt.setInt(++i, g.getGgPrice());
			pstmt.setString(++i, g.getGgSystemRequirement());
			pstmt.setString(++i, g.getGgGenre());
			pstmt.setString(++i, g.getGgDeveloper());
			pstmt.setString(++i, g.getGgReleaseDate());
			pstmt.setString(++i, g.getGgPublisher());
			pstmt.setString(++i, g.getGgLanguages());
			pstmt.setString(++i, g.getGgInfomation());
			result = pstmt.executeUpdate();
			
			//sql2
			//SEQ_GAME_IMAGE_GI_NO.nextval
			System.out.println("fileNames: " + fileNames);
			for(String filename :  fileNames) {
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1,nextVal);
				pstmt.setString(2, filename);

				result = pstmt.executeUpdate();
				System.out.println("game_image table에 insert 성공");
				JdbcTemplate.close(pstmt);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
			
		}
		System.out.println("게임 등록 insert 결과 : "+ result);
		return result;
	}

	
	
	

	
	public int getGameCount(Connection conn) {
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
	
	public int updateGame(Connection conn, Game g) {
		int result =0;
		String sql = "UPDATE GAME SET "
				+ "GG_TITLE=? ,GG_PRICE=?,GG_SYSTEM_REQUIREMENTS=?, GG_GENRE=?,"
				+ "GG_DEVELOPER=?, GG_RELEASE_DATE=?, GG_PUBLISHER=?, GG_LANGUAGES=?, GG_INFORMATION=?"
				+ "where gg_no=?";
		
		
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, g.getGgTitle());
			pstmt.setInt(2, g.getGgPrice());
			pstmt.setString(3, g.getGgSystemRequirement());
			pstmt.setString(4, g.getGgGenre());
			pstmt.setString(5, g.getGgDeveloper());
			pstmt.setString(6, g.getGgReleaseDate());
			pstmt.setString(7, g.getGgPublisher());
			pstmt.setString(8, g.getGgLanguages());
			pstmt.setString(9, g.getGgInfomation());
			pstmt.setInt(10, g.getGgNo());
			result =pstmt.executeUpdate();		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		System.out.println("update 결과 : " + result);
		return result;
	}
	
	

	

}