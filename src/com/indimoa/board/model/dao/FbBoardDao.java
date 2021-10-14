package com.indimoa.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.indimoa.common.JdbcTemplate;
import com.indimoa.board.model.vo.FbBoard;
import com.indimoa.board.model.vo.FbBoardR;
import com.indimoa.board.model.vo.TipBoard;

public class FbBoardDao {
	public FbBoard getBoard(Connection conn, int bno) {
		FbBoard vo = null;
		String sql = "select FB_NO,MM_ID,FB_TITLE,FB_CONTENT,TO_CHAR(FB_DATETIME, 'yyyy-mm-dd') FB_DATETIME,FB_VISIT,FB_REPLY,FB_REPORT, bref, bre_level, Bre_step "
				+ " from FREE_BOARD_M where FB_NO = ?";

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				vo = new FbBoard();
				vo.setFbNo(rset.getInt("FB_NO"));
				vo.setMmId(rset.getString("MM_ID"));
				vo.setFbTitle(rset.getString("FB_TITLE"));
				vo.setFbContent(rset.getString("FB_CONTENT"));
				vo.setFbDatetime(rset.getString("FB_DATETIME"));
				vo.setFbVisit(rset.getInt("FB_VISIT"));
				vo.setFbReply(rset.getInt("FB_REPLY"));
				vo.setFbReport(rset.getInt("FB_REPORT"));
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

	public FbBoardR getBoardR(Connection conn, int bno) {
		FbBoardR vor = null;
		String sql = "select FB_R_NO, FB_R_ID, FB_R_CONTENT,TO_CHAR(FB_R_DATETIME, 'yyyy-mm-dd') FB_R_DATETIME"
				+ " from FREE_BOARD_M_R where FB_R_NO = ?";
//		FB_R_NO       NOT NULL NUMBER(11)    
//		FB_R_ID       NOT NULL VARCHAR2(20)  
//		FB_R_CONTENT  NOT NULL VARCHAR2(100) 
//		FB_R_DATETIME NOT NULL TIMESTAMP(6) 
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				vor = new FbBoardR();
				vor.setFbRNo(rset.getInt("FB_R_NO"));
				vor.setFbRId(rset.getString("FB_R_ID"));
				vor.setFbRContent(rset.getString("FB_R_CONTENT"));
				vor.setFbRDatetime(rset.getString("FB_R_DATETIME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		return vor;
	}

	public int getBoardCount(Connection conn) {
		int result = 0;
		String sql = "select count(fb_no) from FREE_BOARD_M";
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

	public ArrayList<FbBoard> selectBoardList(Connection conn) {
		ArrayList<FbBoard> volist = null;

		String sql = "select * from FREE_BOARD_M";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			volist = new ArrayList<FbBoard>();
			if (rset.next()) {
				do {
					FbBoard vo = new FbBoard();
					vo.setFbNo(rset.getInt("FB_NO"));
					vo.setMmId(rset.getString("MM_ID"));
					vo.setFbTitle(rset.getString("FB_TITLE"));
					vo.setFbContent(rset.getString("FB_CONTENT"));
					vo.setFbDatetime(rset.getString("FB_DATETIME"));
					vo.setFbVisit(rset.getInt("FB_VISIT"));
					vo.setFbReply(rset.getInt("FB_REPLY"));
					vo.setFbReport(rset.getInt("FB_REPORT"));
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

	public ArrayList<FbBoardR> selectBoardRList(Connection conn, int bno) {
		ArrayList<FbBoardR> vorlist = null;

		String sql = "select FREE_BOARD_M_R.*,TO_CHAR(FB_R_DATETIME, 'yyyy-mm-dd')"
				+ " FB_R_DATETIME_char from FREE_BOARD_M_R where FB_R_NO = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rset = pstmt.executeQuery();
			vorlist = new ArrayList<FbBoardR>();
			if (rset.next()) {
				do {
					FbBoardR vor = new FbBoardR();
					vor.setFbRNo(rset.getInt("FB_R_NO"));
					vor.setFbRId(rset.getString("FB_R_ID"));
					vor.setFbRContent(rset.getString("FB_R_CONTENT"));
					vor.setFbRDatetime(rset.getString("FB_R_DATETIME_char"));
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

	public ArrayList<FbBoard> selectBoardList(Connection conn, int start, int end) {
		ArrayList<FbBoard> volist = null;

		String sql = "select t2.*,TO_CHAR(FB_DATETIME, 'yyyy-mm-dd') FB_DATETIME_char from (select Rownum r, t1.* from "
				+ " (select * from FREE_BOARD_M f1 left outer join (select count(fb_r_no) fbReply, fb_r_no from free_board_m_r group by fb_r_no) f2 on f1.FB_NO = f2.fb_r_no order by FB_NO desc) t1 "
				+ " ) t2 " + " where r between ? and ? and fb_report<10";

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<FbBoard>();
			if (rset.next()) {
				do {
					FbBoard vo = new FbBoard();
					vo.setFbNo(rset.getInt("FB_NO"));
					vo.setMmId(rset.getString("MM_ID"));
					vo.setFbTitle(rset.getString("FB_TITLE"));
					vo.setFbContent(rset.getString("FB_CONTENT"));
					vo.setFbDatetime(rset.getString("FB_DATETIME_char"));
					vo.setFbVisit(rset.getInt("FB_VISIT"));
					vo.setFbReply(rset.getInt("fbReply"));
					vo.setFbReport(rset.getInt("FB_REPORT"));
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

	public int updateBoard(Connection conn, FbBoard vo) {
		int result = -1;
		String sql = "update free_board_m set fb_title=?, fb_content=? where fb_no=?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getFbTitle());
			pstmt.setString(2, vo.getFbContent());
			pstmt.setInt(3, vo.getFbNo());
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
		String sql = "update free_board_m set fb_report=10 where fb_no=?";
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

	public int reportBoard(Connection conn, int bno) {
		int result = -1;
		String sql = "update free_board_m set fb_report=fb_report+1 where fb_no=?";
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
	
	public int insertBoard(Connection conn, FbBoard vo) {
		int result = -1;

		String sqlUpdate = "update FREE_BOARD_M set bre_step=bre_step+1 " + "where bref=? and bre_step>?";

		String sqlInsert = "INSERT INTO FREE_BOARD_M (FB_NO,MM_ID,FB_TITLE,FB_CONTENT,FB_DATETIME,FB_VISIT,FB_REPLY,FB_REPORT,bref, bre_level, bre_step)"
				+ " VALUES (?, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?)";
		String sqlSeqNextVal = "select SEQ_FB_BOARD_NO.nextval from dual";

		int bref = 0;
		int bre_level = 0;
		int bre_step = 1;
		int nextVal = 0;

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sqlSeqNextVal);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				nextVal = rset.getInt(1);
			}
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);

			if (vo.getFbNo() != 0) { // 답글
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
			if (vo.getFbNo() != 0) {
				pstmt.setInt(8, bref);
			} else {
				pstmt.setInt(8, nextVal);
			}

			pstmt.setInt(1, nextVal);
			pstmt.setString(2, vo.getMmId());
			pstmt.setString(3, vo.getFbTitle());
			pstmt.setString(4, vo.getFbContent());
			pstmt.setInt(5, vo.getFbVisit());
			pstmt.setInt(6, vo.getFbReply());
			pstmt.setInt(7, vo.getFbReport());
			pstmt.setInt(9, bre_level);
			pstmt.setInt(10, bre_step);
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

	public int insertRBoard(Connection conn, FbBoardR vo) {
		int result = -1;
//		FB_R_NO       NOT NULL NUMBER(11)    
//		FB_R_ID       NOT NULL VARCHAR2(20)  
//		FB_R_CONTENT  NOT NULL VARCHAR2(100) 
//		FB_R_DATETIME NOT NULL TIMESTAMP(6) 
		String sqlInsert = "INSERT INTO  FREE_BOARD_M_R (FB_R_NO,FB_R_ID,FB_R_CONTENT,FB_R_DATETIME)"
				+ " VALUES (?, ?, ?, sysdate)";

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setInt(1, vo.getFbRNo());
			pstmt.setString(2, vo.getFbRId());
			pstmt.setString(3, vo.getFbRContent());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		System.out.println("FREE_BOARD_M_R insert 결과 : " + result);
		return result;
	}
}
