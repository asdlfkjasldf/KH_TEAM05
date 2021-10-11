package com.indimoa.board.model.vo;

public class FbBoard {
//	FB_NO       NOT NULL NUMBER(11)    
//	MM_ID       NOT NULL VARCHAR2(20)  
//	FB_TITLE    NOT NULL VARCHAR2(20)  
//	FB_CONTENT  NOT NULL VARCHAR2(255) 
//	FB_DATETIME NOT NULL TIMESTAMP(6)  
//	FB_VISIT    NOT NULL NUMBER(10)    
//	FB_REPLY    NOT NULL NUMBER(20)    
//	FB_REPORT   NOT NULL NUMBER(5)   

	private int fbNo;
	private String mmId;
	private String fbTitle;
	private String fbContent;
	private String fbDatetime;
	private int fbVisit;
	private int fbReply;
	private int fbReport;
	private int bref;
	private int breLevel;
	private int breStep;

	public FbBoard(int fbNo, String mmId, String fbTitle, String fbContent, String fbDatetime, int fbVisit, int fbReply,
			int fbReport, int bref, int breLevel, int breStep) {
		super();
		this.fbNo = fbNo;
		this.mmId = mmId;
		this.fbTitle = fbTitle;
		this.fbContent = fbContent;
		this.fbDatetime = fbDatetime;
		this.fbVisit = fbVisit;
		this.fbReply = fbReply;
		this.fbReport = fbReport;
		this.bref = bref;
		this.breLevel = breLevel;
		this.breStep = breStep;
	}

	public FbBoard() {
	}

	public int getFbNo() {
		return fbNo;
	}

	public void setFbNo(int fbNo) {
		this.fbNo = fbNo;
	}

	public String getMmId() {
		return mmId;
	}

	public void setMmId(String mmId) {
		this.mmId = mmId;
	}

	public String getFbTitle() {
		return fbTitle;
	}

	public void setFbTitle(String fbTitle) {
		this.fbTitle = fbTitle;
	}

	public String getFbContent() {
		return fbContent;
	}

	public void setFbContent(String fbContent) {
		this.fbContent = fbContent;
	}

	public String getFbDatetime() {
		return fbDatetime;
	}

	public void setFbDatetime(String fbDatetime) {
		this.fbDatetime = fbDatetime;
	}

	public int getFbVisit() {
		return fbVisit;
	}

	public void setFbVisit(int fbVisit) {
		this.fbVisit = fbVisit;
	}

	public int getFbReply() {
		return fbReply;
	}

	public void setFbReply(int fbReply) {
		this.fbReply = fbReply;
	}

	public int getFbReport() {
		return fbReport;
	}

	public void setFbReport(int fbReport) {
		this.fbReport = fbReport;
	}

	public int getBref() {
		return bref;
	}

	public void setBref(int bref) {
		this.bref = bref;
	}

	public int getBreLevel() {
		return breLevel;
	}

	public void setBreLevel(int breLevel) {
		this.breLevel = breLevel;
	}

	public int getBreStep() {
		return breStep;
	}

	public void setBreStep(int breStep) {
		this.breStep = breStep;
	}

	@Override
	public String toString() {
		return "FbBoard [fbNo=" + fbNo + ", mmId=" + mmId + ", fbTitle=" + fbTitle + ", fbContent=" + fbContent
				+ ", fbDatetime=" + fbDatetime + ", fbVisit=" + fbVisit + ", fbReply=" + fbReply + ", fbReport="
				+ fbReport + ", bref=" + bref + ", breLevel=" + breLevel + ", breStep=" + breStep + "]";
	}

}
