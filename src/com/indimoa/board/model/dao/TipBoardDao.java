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
		String sql = "select TIP_NO,GD_GAMEDEVID,TIP_TITLE,TIP_CONTENT,TO_CHAR(TIP_DATETIME, 'yyyy/mm/dd'),TIP_VISIT,TIP_REPLY,TIP_REPORT "
				+ " from TipBoard where TIP_NO = ?";
//		TIP_NO       NOT NULL NUMBER(11)    
//		GD_GAMEDEVID NOT NULL VARCHAR2(20)  
//		TIP_TITLE    NOT NULL VARCHAR2(20)  
//		TIP_CONTENT  NOT NULL VARCHAR2(255) 
//		TIP_DATETIME NOT NULL TIMESTAMP(6)  
//		TIP_VISIT    NOT NULL NUMBER(10)    
//		TIP_REPLY    NOT NULL NUMBER(20)    
//		TIP_REPORT   NOT NULL VARCHAR2(20) 
//		private int tipNo;
//		private String gdGamedevid;
//		private String tipTitle;
//		private String tipContent;
//		private String tipDatetime;   // Date 대신 DAO에서 TO_DATE(), TO_CHAR() 
//		private int tipVisit;
//		private int tipReply;
//		private String tipReport;
		
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
				vo.setTipReport(rset.getString("TIP_REPORT"));
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
		String sql = "select count(bno) from board";
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
					vo.setTipReport(rset.getString("TIP_REPORT"));
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

		String sql = "select * from (select Rownum r, t1.* from "
				+ "(select * from TipBoard order by TIP_NO desc) t1 ) t2 where r between ? and ?";

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
					vo.setTipDatetime(rset.getString("TIP_DATETIME"));
					vo.setTipVisit(rset.getInt("TIP_VISIT"));
					vo.setTipReply(rset.getInt("TIP_REPLY"));
					vo.setTipReport(rset.getString("TIP_REPORT"));
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

//		String sqlUpdate = "update TipBoard set bre_step=bre_step+1 " + "where bref=? and bre_step>?";

		String sqlInsert = "INSERT INTO  Tip_Board (TIP_NO, GD_GAMEDEVID, TIP_TITLE, TIP_CONTENT, TIP_DATETIME, TIP_VISIT, TIP_REPLY, TIP_REPORT)"
				+ " VALUES (?, ?, ?, ?, sysdate, ?, ?, ?)";
		String sqlSeqNextVal = "select seq_tip_board_tip_no.nextval from dual";


		int nextVal = 1;

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

			pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setInt(1, nextVal);
			pstmt.setString(2, vo.getGdGamedevid());
			pstmt.setString(3, vo.getTipTitle());
			pstmt.setString(4, vo.getTipContent());
			pstmt.setInt(5, vo.getTipVisit());
			pstmt.setInt(6, vo.getTipReply());
			pstmt.setString(7, vo.getTipReport());
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
