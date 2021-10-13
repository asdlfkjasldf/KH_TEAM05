package com.indimoa.board.model.vo;

public class GbBoardR {
//	GB_R_NO       NOT NULL NUMBER(11)    
//	GB_R_ID       NOT NULL VARCHAR2(20)  
//	GB_R_CONTENT  NOT NULL VARCHAR2(100) 
//	GB_R_DATETIME NOT NULL TIMESTAMP(6)  

	private int gbRNo;
	private String gbRId;
	private String gbRContent;
	private String gbRDatetime;

	public GbBoardR() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GbBoardR [gbRNo=" + gbRNo + ", gbRId=" + gbRId + ", gbRContent=" + gbRContent + ", gbRDatetime="
				+ gbRDatetime + "]";
	}

	public GbBoardR(int gbRNo, String gbRId, String gbRContent, String gbRDatetime) {
		super();
		this.gbRNo = gbRNo;
		this.gbRId = gbRId;
		this.gbRContent = gbRContent;
		this.gbRDatetime = gbRDatetime;
	}

	public int getGbRNo() {
		return gbRNo;
	}

	public void setGbRNo(int gbRNo) {
		this.gbRNo = gbRNo;
	}

	public String getGbRId() {
		return gbRId;
	}

	public void setGbRId(String gbRId) {
		this.gbRId = gbRId;
	}

	public String getGbRContent() {
		return gbRContent;
	}

	public void setGbRContent(String gbRContent) {
		this.gbRContent = gbRContent;
	}

	public String getGbRDatetime() {
		return gbRDatetime;
	}

	public void setGbRDatetime(String gbRDatetime) {
		this.gbRDatetime = gbRDatetime;
	}

}
