package com.indimoa.board.model.vo;

public class TipBoard {

//	TIP_NO       NOT NULL NUMBER(11)    
//	GD_GAMEDEVID NOT NULL VARCHAR2(20)  
//	TIP_TITLE    NOT NULL VARCHAR2(20)  
//	TIP_CONTENT  NOT NULL VARCHAR2(255) 
//	TIP_DATETIME NOT NULL TIMESTAMP(6)  
//	TIP_VISIT    NOT NULL NUMBER(10)    
//	TIP_REPLY    NOT NULL NUMBER(20)    
//	TIP_REPORT   NOT NULL VARCHAR2(20) 

	private int tipNo;
	private String gdGamedevid;
	private String tipTitle;
	private String tipContent;
	private String tipDatetime; // Date 대신 DAO에서 TO_DATE(), TO_CHAR()
	private int tipVisit;
	private int tipReply;
	private int tipReport;
	private int bref;
	private int breLevel;
	private int breStep;

	public TipBoard() {
		// TODO Auto-generated constructor stub
	}

	public TipBoard(int tipNo, String gdGamedevid, String tipTitle, String tipContent, String tipDatetime, int tipVisit,
			int tipReply, int tipReport, int bref, int breLevel, int breStep) {
		super();
		this.tipNo = tipNo;
		this.gdGamedevid = gdGamedevid;
		this.tipTitle = tipTitle;
		this.tipContent = tipContent;
		this.tipDatetime = tipDatetime;
		this.tipVisit = tipVisit;
		this.tipReply = tipReply;
		this.tipReport = tipReport;
		this.bref = bref;
		this.breLevel = breLevel;
		this.breStep = breStep;
	}

	public int getTipNo() {
		return tipNo;
	}

	public void setTipNo(int tipNo) {
		this.tipNo = tipNo;
	}

	public String getGdGamedevid() {
		return gdGamedevid;
	}

	public void setGdGamedevid(String gdGamedevid) {
		this.gdGamedevid = gdGamedevid;
	}

	public String getTipTitle() {
		return tipTitle;
	}

	public void setTipTitle(String tipTitle) {
		this.tipTitle = tipTitle;
	}

	public String getTipContent() {
		return tipContent;
	}

	public void setTipContent(String tipContent) {
		this.tipContent = tipContent;
	}

	public String getTipDatetime() {
		return tipDatetime;
	}

	public void setTipDatetime(String tipDatetime) {
		this.tipDatetime = tipDatetime;
	}

	public int getTipVisit() {
		return tipVisit;
	}

	public void setTipVisit(int tipVisit) {
		this.tipVisit = tipVisit;
	}

	public int getTipReply() {
		return tipReply;
	}

	public void setTipReply(int tipReply) {
		this.tipReply = tipReply;
	}

	public int getTipReport() {
		return tipReport;
	}

	public void setTipReport(int tipReport) {
		this.tipReport = tipReport;
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
		return "TipBoard [tipNo=" + tipNo + ", gdGamedevid=" + gdGamedevid + ", tipTitle=" + tipTitle + ", tipContent="
				+ tipContent + ", tipDatetime=" + tipDatetime + ", tipVisit=" + tipVisit + ", tipReply=" + tipReply
				+ ", tipReport=" + tipReport + ", bref=" + bref + ", breLevel=" + breLevel + ", breStep=" + breStep
				+ "]";
	}

}