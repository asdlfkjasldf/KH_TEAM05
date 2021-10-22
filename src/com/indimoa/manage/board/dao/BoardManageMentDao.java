package com.indimoa.manage.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.indimoa.board.model.vo.FaqBoard;
import com.indimoa.board.model.vo.FbBoard;
import com.indimoa.board.model.vo.GbBoard;
import com.indimoa.board.model.vo.NtBoard;
import com.indimoa.board.model.vo.TipBoard;
import com.indimoa.common.JdbcTemplate;;

public class BoardManageMentDao {

	public int updateFBoard(Connection conn, FbBoard vo) {
		int result = -1;

		String sqlUpdate = "UPDATE free_board_m SET FB_TITLE = ? , FB_CONTENT = ? WHERE FB_NO = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sqlUpdate);
			pstmt.setString(1, vo.getFbTitle());
			pstmt.setString(2, vo.getFbContent());
			pstmt.setInt(3, vo.getFbNo());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}

	public int updateGBoard(Connection conn, GbBoard vo) {
		int result = -1;

		String sqlUpdate = "UPDATE game_dev_board SET GB_TITLE = ? , GB_CONTENT = ? WHERE GB_NO = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sqlUpdate);
			pstmt.setString(1, vo.getGbTitle());
			pstmt.setString(2, vo.getGbContent());
			pstmt.setInt(3, vo.getGbNo());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}

	public int updateTipBoard(Connection conn, TipBoard vo) {
		int result = -1;

		String sqlUpdate = "UPDATE tip_board SET TIP_TITLE = ? , TIP_CONTENT = ? WHERE TIP_NO = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sqlUpdate);
			pstmt.setString(1, vo.getTipTitle());
			pstmt.setString(2, vo.getTipContent());
			pstmt.setInt(3, vo.getTipNo());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int updateNtBoardList(Connection conn, NtBoard vo) {
		int result = -1;

		String sqlUpdate = "UPDATE notice_board SET NT_TITLE = ? , NT_CONTENT = ? WHERE NT_NO = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sqlUpdate);
			pstmt.setString(1, vo.getNtTitle());
			pstmt.setString(2, vo.getNtContent());
			pstmt.setInt(3, vo.getNtNo());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}

	public int updateFaqBoardList(Connection conn, FaqBoard vo) {
		int result = -1;

		String sqlUpdate = "UPDATE faq_board SET FQ_TITLE = ? , FQ_CONTENT = ? WHERE FQ_NO = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sqlUpdate);
			pstmt.setString(1, vo.getFqTitle());
			pstmt.setString(2, vo.getFqContent());
			pstmt.setInt(3, vo.getFqNo());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}

	public int deleteFBoard(Connection conn, FbBoard vo) {
		int result = -1;
		
		String sqlDelete = "DELETE FROM free_board_m WHERE FB_NO = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sqlDelete);
			pstmt.setInt(1, vo.getFbNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}

	public int deleteGBoard(Connection conn, GbBoard vo) {
		int result = -1;
		
		String sqlDelete = "DELETE FROM game_dev_board WHERE GB_NO = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sqlDelete);
			pstmt.setInt(1, vo.getGbNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}

	public int deleteTipBoard(Connection conn, TipBoard vo) {
		int result = -1;
		
		String sqlDelete = "DELETE FROM tip_board WHERE TIP_NO = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sqlDelete);
			pstmt.setInt(1, vo.getTipNo());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}

	public int deleteNtBoard(Connection conn, NtBoard vo) {
		int result = -1;
		
		String sqlDelete = "DELETE FROM notice_board WHERE NT_NO = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sqlDelete);
			pstmt.setInt(1, vo.getNtNo());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int deleteNtBoard(Connection conn, FaqBoard vo) {
		int result = -1;
		
		String sqlDelete = "DELETE FROM faq_board WHERE FQ_NO = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sqlDelete);
			pstmt.setInt(1, vo.getFqNo());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}

}
