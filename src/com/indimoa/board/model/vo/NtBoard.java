package com.indimoa.board.model.vo;

import java.sql.Timestamp;

public class NtBoard {
	private int ntNo;
	private String adId;
	private	String ntTitle;
	private String ntContent;
	private String ntDatetime;
	
	
	public NtBoard() {
		super();
	}
	
	public String toString() {
		return "Notice board [ntNo ="+ ntNo + ", adId = "+adId 
				+ ", ntTitle"+ntTitle + ", ntContent = "+ntContent   
				+ ", ntDatetime = " +ntDatetime + "]";
	}
	public int getNtNo() {
		return ntNo;
	}
	public void setNtNo(int ntNo) {
		this.ntNo = ntNo;
	}
	
	public String getAdId() {
		return adId;
	}
	public void setAdId(String adId){
		this.adId = adId;
	}
	public String getNtTitle() {
		return ntTitle;
	}
	public void setNtTitle(String ntTitle) {
		this.ntTitle = ntTitle;
	}
	public String getNtContent() {
		return ntContent;
	}
	public void setNtContent(String ntContent) {
		this.ntContent = ntContent;
	}

	public String getNtDatetime() {
		return ntDatetime;
	}

	public void setNtDatetime(String ntDatetime) {
		this.ntDatetime = ntDatetime;
	}
	
	public NtBoard(String title, String content, int bno) {
		this.ntTitle = title;
		this.ntContent = content;
		this.ntNo = bno; 
		//게시물관리에서 수정하기 위해 추가
	}

	public NtBoard(int bno) {
		this.ntNo = bno;
		//게시물관리에서 삭제하기 위해 추가
	}
	


}
