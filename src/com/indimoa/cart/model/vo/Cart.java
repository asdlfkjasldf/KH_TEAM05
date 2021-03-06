package com.indimoa.cart.model.vo;

import java.sql.Timestamp;

public class Cart {
	private int ct_no;
	private String mm_id;
	private String ct_content;
	private String ct_date;
	private int ct_price;
	public Cart() {}
	
	public Cart(int ct_no, String mm_id, String ct_content, String ct_date, int ct_price) {
		super();
		this.ct_no = ct_no;
		this.mm_id = mm_id;
		this.ct_content = ct_content;
		this.ct_date = ct_date;
		this.ct_price = ct_price;
	}
	
	public Cart(int ct_no) {
		this.ct_no = ct_no;
	}

	

	@Override
	public String toString() {
		return "Cart [ct_no=" + ct_no + ", mm_id=" + mm_id + ", ct_content=" + ct_content + ", ct_date=" + ct_date
				+ ", ct_price=" + ct_price + "]";
	}

	public int getCt_no() {
		return ct_no;
	}

	public void setCt_no(int ct_no) {
		this.ct_no = ct_no;
	}

	public String getMm_id() {
		return mm_id;
	}

	public void setMm_id(String mm_id) {
		this.mm_id = mm_id;
	}

	public String getCt_content() {
		return ct_content;
	}

	public void setCt_content(String ct_content) {
		this.ct_content = ct_content;
	}

	public String getCt_date() {
		return ct_date;
	}

	public void setCt_date(String ct_date) {
		this.ct_date = ct_date;
	}
	
	public int getCt_price() {
		return ct_price;
	}
	
	public void setCt_price(int ct_price) {
		this.ct_price = ct_price;
	}
	
	
	
}