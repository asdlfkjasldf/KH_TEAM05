package com.indimoa.cart.model.dao;

import static com.indimoa.common.JdbcTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.indimoa.cart.model.vo.Cart;
import com.indimoa.common.JdbcTemplate;


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
				c.setCt_price(rset.getInt("ct_price"));
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
			String query = "insert into cart values(?, ?, ?, ?, ?)";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, c.getCt_no());
				pstmt.setString(2, c.getMm_id());
				pstmt.setString(3, c.getCt_content());
				pstmt.setTimestamp(4, c.getCt_date());
				pstmt.setInt(5, c.getCt_price());
				
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
	
	
	public int getCartCount(Connection conn) {
		int result = 0;
		String sql = "select count(ct_no) from CART";
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
	
	
	public ArrayList<Cart> selectCartList(Connection conn) {
		ArrayList<Cart> volist = null;

		String sql = "select * from Cart";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			volist = new ArrayList<Cart>();
			if (rset.next()) {
				do {
					Cart vo = new Cart();
					vo = new Cart();
					vo.setCt_no(rset.getInt("ct_no"));
					vo.setMm_id(rset.getString("mm_id"));
					vo.setCt_content(rset.getString("ct_content"));
					vo.setCt_date(rset.getTimestamp("ct_date"));
					vo.setCt_price(rset.getInt("ct_price"));
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

	public ArrayList<Cart> selectCartList(Connection conn, int start, int end) {
		ArrayList<Cart> volist = null;

		String sql = "select * from (select Rownum r, t1.* from "
				+ "(select * from Cart order by CT_NO desc) t1 ) t2 where r between ? and ?";

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<Cart>();
			if (rset.next()) {
				do {
					Cart vo = new Cart();
					vo = new Cart();
					vo.setCt_no(rset.getInt("ct_no"));
					vo.setMm_id(rset.getString("mm_id"));
					vo.setCt_content(rset.getString("ct_content"));
					vo.setCt_date(rset.getTimestamp("ct_date"));
					vo.setCt_price(rset.getInt("ct_price"));
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
	
}
