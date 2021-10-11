package com.indomoa.cart.model.vo;

import java.sql.Timestamp;

public class Cart {
	private int ct_no;
	private String mm_id;
	private String ct_content;
	private Timestamp ct_date;
	public Cart() {}
	
	public Cart(int ct_no, String mm_id, String ct_content, Timestamp ct_date) {
		super();
		this.ct_no = ct_no;
		this.mm_id = mm_id;
		this.ct_content = ct_content;
		this.ct_date = ct_date;
	}
	
	public Cart(int ct_no) {
		this.ct_no = ct_no;
	}

	@Override
	public String toString() {
		return "Cart [ct_no=" + ct_no + ", mm_id=" + mm_id + ", ct_content=" + ct_content + ", ct_date=" + ct_date
				+ "]";
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

	public Timestamp getCt_date() {
		return ct_date;
	}

	public void setCt_date(Timestamp ct_date) {
		this.ct_date = ct_date;
	}
	
	
	
}

	
