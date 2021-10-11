package com.indimoa.cart.model.service;

import static com.indimoa.common.JdbcTemplate.*;

import java.sql.Connection;

import com.indimoa.cart.model.dao.CartDao;
import com.indomoa.cart.model.vo.Cart;

public class CartService {
	
	public CartService() {}
	
	//장바구니 들어갈 시 Member id 확인
	public Cart cartRetrive(String id) {
		Connection conn = getConnection();
		Cart c = new CartDao().cartRetrieve(conn, id);
		close(conn);
		return c;
	}
	
	//Cart에 항목 추가
	public int cartAdd(Cart c) {
		Connection conn = getConnection();
		int result = new CartDao().cartAdd(conn, c);
		
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

}
