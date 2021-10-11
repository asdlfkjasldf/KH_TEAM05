package com.indimoa.cart.model.dao;

import static com.indimoa.common.JdbcTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.indomoa.cart.model.vo.Cart;

public class CartDao {
	
	public CartDao() {}
	public Cart cartRetrieve(Connection conn, String id) {
		Cart c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from cart where mm_id = ?";
		try {
			pstmt.getConnection().prepareStatement(query);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				c = new Cart();
				c.setCt_no(rset.getInt("ct_no"));
				c.setMm_id(rset.getString("mm_id"));
				c.setCt_content(rset.getString("ct_content"));
				c.setCt_date(rset.getTimestamp("ct_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return c;
	}
	
	public int cartAdd(Connection conn, Cart c) {
			PreparedStatement pstmt = null;
			int result = 0;
			String query = "insert into cart values(?, ?, ?, ?)";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, c.getCt_no());
				pstmt.setString(2, c.getMm_id());
				pstmt.setString(3, c.getCt_content());
				pstmt.setTimestamp(4, c.getCt_date());
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
	}
	
	
	public int cartDelete(Connection conn, String id) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from cart where mm_id like ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
}
