package com.indimoa.board.model.vo;

public class GbBoard {
//	GB_NO        NOT NULL NUMBER(11)    
//	GD_GAMEDEVID NOT NULL VARCHAR2(20)  
//	HE_HEADING   NOT NULL VARCHAR2(20)  
//	GB_TITLE     NOT NULL VARCHAR2(20)  
//	GB_CONTENT   NOT NULL VARCHAR2(255) 
//	GB_DATETIME  NOT NULL TIMESTAMP(6)  
//	GB_VISIT     NOT NULL NUMBER(10)    
//	GB_REPLY     NOT NULL NUMBER(20)    
//	GB_REPORT    NOT NULL NUMBER(5)     

	private int gbNo;
	private String gdGamedevid;
	private String heHeading;
	private String gbTitle;
	private String gbContent;
	private String gbDatetime;
	private int gbVisit;
	private int gbReply;
	private int gbReport;
	private int bref;
	private int breLevel;
	private int breStep;

	public GbBoard() {
		super();
	}
	
	public GbBoard(int gbNo, String gdGamedevid, String heHeading, String gbTitle, String gbContent, String gbDatetime,
			int gbVisit, int gbReply, int gbReport, int bref, int breLevel, int breStep) {
		super();
		this.gbNo = gbNo;
		this.gdGamedevid = gdGamedevid;
		this.heHeading = heHeading;
		this.gbTitle = gbTitle;
		this.gbContent = gbContent;
		this.gbDatetime = gbDatetime;
		this.gbVisit = gbVisit;
		this.gbReply = gbReply;
		this.gbReport = gbReport;
		this.bref = bref;
		this.breLevel = breLevel;
		this.breStep = breStep;
	}

	public int getGbNo() {
		return gbNo;
	}

	public void setGbNo(int gbNo) {
		this.gbNo = gbNo;
	}

	public String getGdGamedevid() {
		return gdGamedevid;
	}

	public void setGdGamedevid(String gdGamedevid) {
		this.gdGamedevid = gdGamedevid;
	}

	public String getHeHeading() {
		return heHeading;
	}

	public void setHeHeading(String heHeading) {
		this.heHeading = heHeading;
	}

	public String getGbTitle() {
		return gbTitle;
	}

	public void setGbTitle(String gbTitle) {
		this.gbTitle = gbTitle;
	}

	public String getGbContent() {
		return gbContent;
	}

	public void setGbContent(String gbContent) {
		this.gbContent = gbContent;
	}

	public String getGbDatetime() {
		return gbDatetime;
	}

	public void setGbDatetime(String gbDatetime) {
		this.gbDatetime = gbDatetime;
	}

	public int getGbVisit() {
		return gbVisit;
	}

	public void setGbVisit(int gbVisit) {
		this.gbVisit = gbVisit;
	}

	public int getGbReply() {
		return gbReply;
	}

	public void setGbReply(int gbReply) {
		this.gbReply = gbReply;
	}

	public int getGbReport() {
		return gbReport;
	}

	public void setGbReport(int gbReport) {
		this.gbReport = gbReport;
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
		return "GbBoard [gbNo=" + gbNo + ", gdGamedevid=" + gdGamedevid + ", heHeading=" + heHeading + ", gbTitle="
				+ gbTitle + ", gbContent=" + gbContent + ", gbDatetime=" + gbDatetime + ", gbVisit=" + gbVisit
				+ ", gbReply=" + gbReply + ", gbReport=" + gbReport + ", bref=" + bref + ", breLevel=" + breLevel
				+ ", breStep=" + breStep + "]";
	}
	
	public GbBoard(String title, String content, int bno) {
		this.gbTitle = title;
		this.gbContent = content;
		this.gbNo = bno; 
		//게시물관리에서 수정하기 위해 추가
	}

	public GbBoard(int bno) {
		this.gbNo = bno;
		//게시물관리에서 삭제하기 위해 추가
	}

}
