package com.indimoa.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.indimoa.board.model.vo.NtBoard;
import com.indimoa.common.JdbcTemplate;

public class NtBoardDao {

	public ArrayList<NtBoard> selectNtBoardList(Connection conn, int start, int end) {
		ArrayList<NtBoard> volist = null;
		
		String sql = "select nt_No, ad_Id , nt_Title , nt_Content , to_char(nt_Datetime,'YYYY-MM-DD hh:mm') nt_Datetime from (select Rownum r, t1.* from (select * from notice_board order by Nt_datetime desc) t1) t2 where r between ? and ?";
		//String sql = "select * from NOTICE_BOARD order by";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<NtBoard>();
			if (rset.next()) {
				
			do{
				NtBoard vo = new NtBoard();
				vo.setNtNo(rset.getInt("nt_No"));
				vo.setAdId(rset.getString("ad_Id"));
				vo.setNtTitle(rset.getString("nt_Title"));
				vo.setNtContent(rset.getString("nt_Content"));
				vo.setNtDatetime(rset.getString("nt_Datetime"));
				volist.add(vo);
				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		System.out.println("[jhseong]-- 공지사항의 리턴은"+ volist);
		return volist;
	}

	public int getNtBoardCount(Connection conn) {
		int result = 0;
		String sql = "select count(NT_NO) from notice_board";
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
	
	public NtBoard getNtBoard(Connection conn, int bno) {
		NtBoard vo = null;
		
//		private int ntNo;
//		private String adId;
//		private	String ntTitle;
//		private String ntContent;
//		private String ntDatetime;
		
		String sql = "select nt_No, ad_Id , nt_Title, nt_Content, to_char(nt_datetime, 'YYYY-MM-DD hh:mm') nt_datetime from NOTICE_BOARD where nt_no = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				vo = new NtBoard();
				vo.setNtNo(rset.getInt("nt_no"));
				vo.setAdId(rset.getString("ad_id"));
				vo.setNtTitle(rset.getString("nt_title"));
				vo.setNtContent(rset.getString("nt_content"));
				vo.setNtDatetime(rset.getString("nt_datetime"));
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		
		
		return vo;
	}
	

	

}
