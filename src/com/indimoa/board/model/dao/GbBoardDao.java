package com.indimoa.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.indimoa.common.JdbcTemplate;
import com.indimoa.board.model.vo.FbBoard;
import com.indimoa.board.model.vo.GbBoard;
import com.indimoa.board.model.vo.GbBoardImg;
import com.indimoa.board.model.vo.GbBoardR;

public class GbBoardDao {
	public GbBoard getBoard(Connection conn, int bno) {
		GbBoard vo = null;
		String sql = "select GB_NO, GD_GAMEDEVID, HE_HEADING, GB_TITLE, GB_CONTENT, TO_CHAR(GB_DATETIME, 'yyyy-mm-dd') GB_DATETIME, GB_VISIT, GB_REPLY, GB_REPORT, bref, bre_level, Bre_step "
				+ " from GAME_DEV_BOARD where GB_NO = ?";

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				vo = new GbBoard();
				vo.setGbNo(rset.getInt("GB_NO"));
				vo.setGdGamedevid(rset.getString("GD_GAMEDEVID"));
				vo.setHeHeading(rset.getString("HE_HEADING"));
				vo.setGbTitle(rset.getString("GB_TITLE"));
				vo.setGbContent(rset.getString("GB_CONTENT"));
				vo.setGbDatetime(rset.getString("GB_DATETIME"));
				vo.setGbVisit(rset.getInt("GB_VISIT"));
				vo.setGbReply(rset.getInt("GB_REPLY"));
				vo.setGbReport(rset.getInt("GB_REPORT"));
				vo.setBref(rset.getInt("BREF"));
				vo.setBreLevel(rset.getInt("BRE_LEVEL"));
				vo.setBreStep(rset.getInt("BRE_STEP"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		return vo;
	}

	public GbBoardR getBoardR(Connection conn, int bno) {
		GbBoardR vor = null;
		String sql = "select GB_R_NO, GB_R_ID, GB_R_CONTENT, GB_R_DATETIME"
				+ " from GAME_DEV_BOARD_R where GB_R_NO = ?";

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				vor = new GbBoardR();
				vor.setGbRNo(rset.getInt("GB_R_NO"));
				vor.setGbRId(rset.getString("GB_R_ID"));
				vor.setGbRContent(rset.getString("GB_R_CONTENT"));
				vor.setGbRDatetime(rset.getString("GB_R_DATETIME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		return vor;
	}
	
	public GbBoardImg getImage(Connection conn, int bno) {
		GbBoardImg img = null;
		String sql = "select * from gb_board_img where gb_no = ?";

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				img = new GbBoardImg();
				img.setGbNo(rset.getInt("gb_no"));
				img.setImgPath(rset.getString("img_path"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		return img;
	}
	
	public int getBoardCount(Connection conn) {
		int result = 0;
		String sql = "select count(gb_no) from GAME_DEV_BOARD";
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

	public ArrayList<GbBoard> selectBoardList(Connection conn) {
		ArrayList<GbBoard> volist = null;

		String sql = "select * from GAME_DEV_BOARD";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			volist = new ArrayList<GbBoard>();
			if (rset.next()) {
				do {
					GbBoard vo = new GbBoard();
					vo.setGbNo(rset.getInt("GB_NO"));
					vo.setGdGamedevid(rset.getString("GD_GAMEDEVID"));
					vo.setHeHeading(rset.getString("HE_HEADING"));
					vo.setGbTitle(rset.getString("GB_TITLE"));
					vo.setGbContent(rset.getString("GB_CONTENT"));
					vo.setGbDatetime(rset.getString("GB_DATETIME"));
					vo.setGbVisit(rset.getInt("GB_VISIT"));
					vo.setGbReply(rset.getInt("GB_REPLY"));
					vo.setGbReport(rset.getInt("GB_REPORT"));
					vo.setBref(rset.getInt("BREF"));
					vo.setBreLevel(rset.getInt("BRE_LEVEL"));
					vo.setBreStep(rset.getInt("BRE_STEP"));
					volist.add(vo);
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

	public ArrayList<GbBoardR> selectBoardRList(Connection conn, int bno) {
		ArrayList<GbBoardR> vorlist = null;

		String sql = "select GAME_DEV_BOARD_R.*,TO_CHAR(GB_R_DATETIME, 'yyyy-mm-dd')"
				+ " GB_R_DATETIME_char from GAME_DEV_BOARD_R where GB_R_NO = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rset = pstmt.executeQuery();
			vorlist = new ArrayList<GbBoardR>();
			if (rset.next()) {
				do {
					GbBoardR vor = new GbBoardR();
					vor.setGbRNo(rset.getInt("GB_R_NO"));
					vor.setGbRId(rset.getString("GB_R_ID"));
					vor.setGbRContent(rset.getString("GB_R_CONTENT"));
					vor.setGbRDatetime(rset.getString("GB_R_DATETIME_char"));
					vorlist.add(vor);
				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		System.out.println("[pearl]-- 리턴은" + vorlist);
		return vorlist;
	}

	
	public ArrayList<GbBoard> selectBoardList(Connection conn, int start, int end) {
		ArrayList<GbBoard> volist = null;

		String sql = "select t2.*,TO_CHAR(GB_DATETIME, 'yyyy-mm-dd') GB_DATETIME_char from (select Rownum r, t1.* from "
				+ "(select * from GAME_DEV_BOARD f1 left outer join (select count(gb_r_no) gbReply, gb_r_no from GAME_DEV_BOARD_R group by gb_r_no) f2 on f1.GB_NO = f2.gb_r_no order by GB_NO desc) t1 "
				+ " ) t2"
				+ " where r between ? and ?";

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<GbBoard>();
			if (rset.next()) {
				do {
					GbBoard vo = new GbBoard();
					vo.setGbNo(rset.getInt("GB_NO"));
					vo.setGdGamedevid(rset.getString("GD_GAMEDEVID"));
					vo.setHeHeading(rset.getString("HE_HEADING"));
					vo.setGbTitle(rset.getString("GB_TITLE"));
					vo.setGbContent(rset.getString("GB_CONTENT"));
					vo.setGbDatetime(rset.getString("GB_DATETIME_char"));
					vo.setGbVisit(rset.getInt("GB_VISIT"));
					vo.setGbReply(rset.getInt("gbReply"));
					vo.setGbReport(rset.getInt("GB_REPORT"));
					vo.setBref(rset.getInt("BREF"));
					vo.setBreLevel(rset.getInt("BRE_LEVEL"));
					vo.setBreStep(rset.getInt("BRE_STEP"));
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
		System.out.println("[pearl]--" + volist);
		return volist;
	}

	public int updateBoard(Connection conn, GbBoard vo) {
		int result = -1;
		String sql = "update game_dev_board set gb_title=?, gb_content=? where gb_no=?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getGbTitle());
			pstmt.setString(2, vo.getGbContent());
			pstmt.setInt(3, vo.getGbNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		System.out.println("update 결과 : " + result);
		return result;
	}

	public int deleteBoard(Connection conn, int bno) {
		int result = -1;
		String sql = "delete from game_dev_board where gb_no=?";

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println("delete 결과 : " + result);
		return result;
	}

	public int deleteRBoard(Connection conn, int bno) {
		int result = -1;
		String sql = "delete from game_dev_board_r where gb_r_no=?";
		PreparedStatement pstmt = null;
		System.out.println("durldurl : ");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println("delete 결과 : " + result);
		return result;
	}

	public int reportBoard(Connection conn, int bno) {
		int result = -1;
		String sql = "update game_dev_board set gb_report=gb_report+1 where gb_no=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println("report 결과 : " + result);
		return result;
	}
	
	public int getNextVal(Connection conn) {
		int nextVal = -1;
		String sqlSeqNextVal = "select SEQ_GB_BOARD_NO.nextval from dual";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sqlSeqNextVal);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				nextVal = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		System.out.println("insert 결과 : " + nextVal);
		return nextVal;
	}


	
	public int insertBoard(Connection conn, GbBoard vo, int nextVal) {
		int result = -1;

		String sqlUpdate = "update GAME_DEV_BOARD set bre_step=bre_step+1 " + "where bref=? and bre_step>?";

		String sqlInsert = "INSERT INTO  GAME_DEV_BOARD "
				+ "(GB_NO, GD_GAMEDEVID, HE_HEADING, GB_TITLE, GB_CONTENT, "
				+ "GB_DATETIME, GB_VISIT, GB_REPLY, GB_REPORT, bref, bre_level, bre_step)"
				+ " VALUES (?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?)";
//		String sqlSeqNextVal = "select SEQ_GB_BOARD_NO.nextval from dual";

		int bref = 0;
		int bre_level = 0;
		int bre_step = 1;
//		int nextVal = 0;

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
//			pstmt = conn.prepareStatement(sqlSeqNextVal);
//			rset = pstmt.executeQuery();
//			if (rset.next()) {
//				nextVal = rset.getInt(1);
//			}
//			JdbcTemplate.close(rset);
//			JdbcTemplate.close(pstmt);

			if (vo.getGbNo() != 0) { // 답글
				bref = vo.getBref();
				bre_step = vo.getBreStep();
				pstmt = conn.prepareStatement(sqlUpdate);
				pstmt.setInt(1, bref);
				pstmt.setInt(2, bre_step);
				result = pstmt.executeUpdate();
				JdbcTemplate.close(pstmt);

				bre_level = vo.getBreLevel() + 1;
				bre_step++;
			}
			pstmt = conn.prepareStatement(sqlInsert);
			if (vo.getGbNo() != 0) {
				pstmt.setInt(9, bref);
			} else {
				pstmt.setInt(9, nextVal);
			}
			pstmt.setInt(1, nextVal);
			pstmt.setString(2, vo.getGdGamedevid());
			pstmt.setString(3, vo.getHeHeading());
			pstmt.setString(4, vo.getGbTitle());
			pstmt.setString(5, vo.getGbContent());
			pstmt.setInt(6, vo.getGbVisit());
			pstmt.setInt(7, vo.getGbReply());
			pstmt.setInt(8, vo.getGbReport());
			pstmt.setInt(10, bre_level);
			pstmt.setInt(11, bre_step);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		System.out.println("insert 결과 : " + result);
		return result;
	}

	public int insertRBoard(Connection conn, GbBoardR vo) {
		int result = -1;
//		FB_R_NO       NOT NULL NUMBER(11)    
//		FB_R_ID       NOT NULL VARCHAR2(20)  
//		FB_R_CONTENT  NOT NULL VARCHAR2(100) 
//		FB_R_DATETIME NOT NULL TIMESTAMP(6) 
		String sqlInsert = "INSERT INTO GAME_DEV_BOARD_R (GB_R_NO, GB_R_ID, GB_R_CONTENT, GB_R_DATETIME)"
				+ " VALUES (?, ?, ?, sysdate)";

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setInt(1, vo.getGbRNo());
			pstmt.setString(2, vo.getGbRId());
			pstmt.setString(3, vo.getGbRContent());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		System.out.println("GAME_DEV_BOARD_R insert 결과 : " + result);
		return result;
	}
	
	public int insertImage(Connection conn, GbBoardImg img) {
		int result = -1;
		String sql = "INSERT INTO GB_BOARD_IMG (GB_NO, IMG_PATH) VALUES (?, ?)";

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, img.getGbNo());
			pstmt.setString(2, img.getImgPath());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		System.out.println("이미지 업로드 결과 : " + result);
		return result;
	}
}
