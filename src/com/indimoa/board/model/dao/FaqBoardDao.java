package com.indimoa.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.indimoa.board.model.vo.FaqBoard;
import com.indimoa.common.JdbcTemplate;
//jhSeong 작성
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

	public FaqBoard getFaqBoard(Connection conn, int bno) {
		// 조회수 때문에 update문 한번 실행 필요함 조회수가 +1 되야히니까
		FaqBoard vo = null;
//		private int fqNo;
//		private String adId;
//		private String fqTitle;
//		private String fqContent;
//		private String fqDatetime;
//		private int fqVisit;
//		private int fqReply;
		
		String sqlUpdateView = "update faq_board set fq_visit = fq_visit+1 where fq_no = ?";
		String sql = "SELECT fq_No, ad_Id, fq_Title, fq_Content, to_char(fq_DateTime, 'YYYY-MM-DD hh:mi') fq_DateTime , fq_Visit FROM Faq_board WHERE fq_No = ?";
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		try {
			//조회수 업데이트를 위해 두번 수행됨
			pstmt = conn.prepareStatement(sqlUpdateView);
			pstmt.setInt(1, bno);
			rset = pstmt.executeQuery();
			JdbcTemplate.close(pstmt);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				vo = new FaqBoard();
				vo.setFqNo(rset.getInt("fq_no"));
				vo.setAdId(rset.getString("ad_Id"));
				vo.setFqTitle(rset.getString("fq_Title"));
				vo.setFqContent(rset.getString("fq_Content"));
				vo.setFqDatetime(rset.getString("fq_Datetime"));
				vo.setFqVisit(rset.getInt("fq_Visit"));	
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		
		
		
		return vo;
	}

	public int insertFaqBoard(Connection conn, FaqBoard vo) {
		int result = -1;
		String sqlInsert = "INSERT INTO faq_board"
				+ "(fq_no, fq_title, fq_content, ad_id, fq_datetime, fq_visit, fq_reply) "
				+ "values(SEQ_Faq_Board_NO.nextval, ? ,? ,? ,systimestamp,0 ,0)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setString(1, vo.getFqTitle());
			pstmt.setString(2, vo.getFqContent());
			pstmt.setString(3, vo.getAdId());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		
		
		return result;
	}

	public ArrayList<FaqBoard> loadFaqBoardContent(Connection conn, int bno) {
		ArrayList<FaqBoard> volist = null;
		
		String sqlload = "select fq_no, ad_Id, fq_title, fq_content, to_char(fq_Datetime, 'YYYY-MM-DD hh:mm') fq_Datetime, fq_visit, fq_reply FROM faq_board where fq_no = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sqlload);
			pstmt.setInt(1, bno);
			rset = pstmt.executeQuery();
			volist = new ArrayList<FaqBoard>();
			if (rset.next()) {
				do {
					FaqBoard vo = new FaqBoard();
					vo.setFqNo(rset.getInt("fq_No"));
					vo.setAdId(rset.getString("ad_Id"));
					vo.setFqTitle(rset.getString("fq_Title"));
					vo.setFqContent(rset.getString("fq_Content"));
					vo.setFqDatetime(rset.getString("fq_Datetime"));
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

	public int updateFaqBoard(Connection conn, FaqBoard vo) {
		int result = -1;
		String sqlUpdate = "update faq_board set fq_title = ?, fq_content = ? where fq_no = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sqlUpdate);
			pstmt.setString(1, vo.getFqTitle());
			pstmt.setString(2, vo.getFqContent());
			pstmt.setInt(3, vo.getFqNo());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}

}
