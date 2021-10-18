package com.indimoa.cart.model.service;

import static com.indimoa.common.JdbcTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.indimoa.cart.model.dao.CartDao;
import com.indimoa.cart.model.vo.Cart;
import com.indimoa.common.JdbcTemplate;


public class CartService {
	
	public CartService() {}
	
	//장바구니 들어갈 시 Member id 확인
	public Cart cartRetrive(String id) {
		Connection conn = getConnection();
		Cart c = new CartDao().cartRetrieve(id);
		close(conn);
		return c;
	}
	
	//Cart에 항목 추가
	public int cartAdd(Cart c) {
		Connection conn = getConnection();
		int result = new CartDao().cartAdd(c);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	//cart 항목 삭제
	public int cartDelete(String id) {
		Connection conn = getConnection();
		int result = new CartDao().cartDelete(conn, id);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}
	
	public int getCartCount() {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = new CartDao().getCartCount(conn);
		JdbcTemplate.close(conn);
		return result;
	}
	
	public ArrayList<Cart> selectCartList(int start, int end) {
		ArrayList<Cart> volist = null;
		Connection conn = JdbcTemplate.getConnection();

		volist = new CartDao().selectCartList(start, end);

		JdbcTemplate.close(conn);
		return volist;
	}

	public ArrayList<Cart> selectCartList() {
		ArrayList<Cart> volist = null;
		Connection conn = JdbcTemplate.getConnection();

		volist = new CartDao().selectCartList(conn);

		JdbcTemplate.close(conn);
		return volist;
	}

}
