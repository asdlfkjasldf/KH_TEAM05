package com.indimoa.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.indimoa.common.JdbcTemplate;
import com.indimoa.board.model.vo.TipBoard;

public class TipBoardDao {
	public TipBoard getBoard(Connection conn, int bno) {
		TipBoard vo = null;
		String sql = "select TIP_NO,GD_GAMEDEVID,TIP_TITLE,TIP_CONTENT,TO_CHAR(TIP_DATETIME, 'yyyy-mm-dd') TIP_DATETIME, TIP_VISIT,TIP_REPLY,TIP_REPORT,bref, bre_level, Bre_step "
				+ " from Tip_Board where TIP_NO = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				vo = new TipBoard();
				vo.setTipNo(rset.getInt("TIP_NO"));
				vo.setGdGamedevid(rset.getString("GD_GAMEDEVID"));
				vo.setTipTitle(rset.getString("TIP_TITLE"));
				vo.setTipContent(rset.getString("TIP_CONTENT"));
				vo.setTipDatetime(rset.getString("TIP_DATETIME"));
				vo.setTipVisit(rset.getInt("TIP_VISIT"));
				vo.setTipReply(rset.getInt("TIP_REPLY"));
				vo.setTipReport(rset.getInt("TIP_REPORT"));
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

	public int getBoardCount(Connection conn) {
		int result = 0;
		String sql = "select count(tip_no) from Tip_Board";
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

	public ArrayList<TipBoard> selectBoardList(Connection conn) {
		ArrayList<TipBoard> volist = null;

		String sql = "select * from Tip_Board";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			volist = new ArrayList<TipBoard>();
			if (rset.next()) {
				do {
					TipBoard vo = new TipBoard();
					vo = new TipBoard();
					vo.setTipNo(rset.getInt("TIP_NO"));
					vo.setGdGamedevid(rset.getString("GD_GAMEDEVID"));
					vo.setTipTitle(rset.getString("TIP_TITLE"));
					vo.setTipContent(rset.getString("TIP_CONTENT"));
					vo.setTipDatetime(rset.getString("TIP_DATETIME"));
					vo.setTipVisit(rset.getInt("TIP_VISIT"));
					vo.setTipReply(rset.getInt("TIP_REPLY"));
					vo.setTipReport(rset.getInt("TIP_REPORT"));
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

	public ArrayList<TipBoard> selectBoardList(Connection conn, int start, int end) {
		ArrayList<TipBoard> volist = null;

		String sql = "select t2.*,TO_CHAR(TIP_DATETIME, 'yyyy-mm-dd') TIP_DATETIME_char from (select Rownum r, t1.* from "
				+ "(select * from Tip_Board order by BREF desc, BRE_STEP asc) t1 ) t2 where r between ? and ?";

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
			volist = new ArrayList<TipBoard>();
			if (rset.next()) {
				do {
					TipBoard vo = new TipBoard();
					vo = new TipBoard();
					vo.setTipNo(rset.getInt("TIP_NO"));
					vo.setGdGamedevid(rset.getString("GD_GAMEDEVID"));
					vo.setTipTitle(rset.getString("TIP_TITLE"));
					vo.setTipContent(rset.getString("TIP_CONTENT"));
					vo.setTipDatetime(rset.getString("TIP_DATETIME_char"));
					vo.setTipVisit(rset.getInt("TIP_VISIT"));
					vo.setTipReply(rset.getInt("TIP_REPLY"));
					vo.setTipReport(rset.getInt("TIP_REPORT"));
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

	public int insertBoard(Connection conn, TipBoard vo) {
		int result = -1;

		String sqlUpdate = "update Tip_Board set bre_step=bre_step+1 " + "where bref=? and bre_step>?";

		String sqlInsert = "INSERT INTO  Tip_Board (TIP_NO, GD_GAMEDEVID, TIP_TITLE, TIP_CONTENT, TO_CHAR(TIP_DATETIME, 'yyyy-mm-dd') TIP_DATETIME, TIP_VISIT, TIP_REPLY, TIP_REPORT,bref, bre_level, bre_step)"
				+ " VALUES (?, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?)";
		String sqlSeqNextVal = "select seq_tip_board_tip_no.nextval from dual";

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

			System.out.println("nextVal: "+ nextVal);
			if (vo.getTipNo() != 0) { // 답글
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
			if (vo.getTipNo() != 0) {
				pstmt.setInt(8, bref);
			} else {
				pstmt.setInt(8, nextVal);
			}
			pstmt.setInt(1, nextVal);
			pstmt.setString(2, vo.getGdGamedevid());
			pstmt.setString(3, vo.getTipTitle());
			pstmt.setString(4, vo.getTipContent());
			pstmt.setInt(5, vo.getTipVisit());
			pstmt.setInt(6, vo.getTipReply());
			pstmt.setInt(7, vo.getTipReport());
			pstmt.setInt(9, bre_level);
			pstmt.setInt(10, bre_step);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		System.out.println("insert 결과 : "+ result);
		return result;
	}

}
