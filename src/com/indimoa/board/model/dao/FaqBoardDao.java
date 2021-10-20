package com.indimoa.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.indimoa.board.model.vo.FaqBoard;
import com.indimoa.common.JdbcTemplate;

public class FaqBoardDao {

	public int getBoardCount(Connection conn) {
		int result = 0;
		String sql = "select count(FQ_NO) from faq_board";
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

	public ArrayList<FaqBoard> selectFaqBoardList(Connection conn, int start, int end) {
		ArrayList<FaqBoard> volist = null;   
		String sql = "select fq_No, ad_Id, fq_Title, fq_Content, "
				+ "to_char(fq_datetime, 'YYYY-MM-DD hh:mm') fq_datetime, fq_visit , fq_reply "
				+ "from (select Rownum r, t1.* from (select * from faq_board order by fq_datetime desc) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<FaqBoard>();
			if (rset.next()) {
				do {
					FaqBoard vo = new FaqBoard();
					vo.setFqNo(rset.getInt("fq_No"));
					vo.setAdId(rset.getString("ad_Id"));
					vo.setFqTitle(rset.getString("fq_Title"));
					vo.setFqContent(rset.getString("fq_Content"));
					vo.setFqDatetime(rset.getString("fq_DateTime"));
					vo.setFqVisit(rset.getInt("fq_visit"));
					vo.setFqReply(rset.getInt("fq_reply"));
					volist.add(vo);
				} while (rset.next());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		System.out.println("[jhseong]-- FAQ의 리턴은"+ volist);
		return volist;
		
	}

}
