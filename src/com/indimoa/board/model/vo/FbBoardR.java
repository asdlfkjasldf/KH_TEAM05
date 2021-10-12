package com.indimoa.board.model.vo;

public class FbBoardR {
//	FB_R_NO       NOT NULL NUMBER(11)    
//	FB_R_ID       NOT NULL VARCHAR2(20)  
//	FB_R_CONTENT  NOT NULL VARCHAR2(100) 
//	FB_R_DATETIME NOT NULL TIMESTAMP(6) 
	private int fbRNo;
	private String fbRId;
	private String fbRContent;
	private String fbRDatetime;
	
	public FbBoardR() {
		super();
	}
	public FbBoardR(int fbRNo, String fbRId, String fbRContent, String fbRDatetime) {
		super();
		this.fbRNo = fbRNo;
		this.fbRId = fbRId;
		this.fbRContent = fbRContent;
		this.fbRDatetime = fbRDatetime;
	}
	
	@Override
	public String toString() {
		return "FbBoardR [fbRNo=" + fbRNo + ", fbRId=" + fbRId + ", fbRContent=" + fbRContent + ", fbRDatetime="
				+ fbRDatetime + "]";
	}
	
	public int getFbRNo() {
		return fbRNo;
	}
	public void setFbRNo(int fbRNo) {
		this.fbRNo = fbRNo;
	}
	public String getFbRId() {
		return fbRId;
	}
	public void setFbRId(String fbRId) {
		this.fbRId = fbRId;
	}
	public String getFbRContent() {
		return fbRContent;
	}
	public void setFbRContent(String fbRContent) {
		this.fbRContent = fbRContent;
	}
	public String getFbRDatetime() {
		return fbRDatetime;
	}
	public void setFbRDatetime(String fbRDatetime) {
		this.fbRDatetime = fbRDatetime;
	}

}
