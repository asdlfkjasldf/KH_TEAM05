package com.indimoa.board.model.vo;

public class FaqBoard {
	private int fqNo;
	private String adId;
	private String fqTitle;
	private String fqContent;
	private String fqDatetime;
	private int fqVisit;
	private int fqReply;
	
	public FaqBoard() {
		super();
	}
	
	
	public int getFqNo() {
		return fqNo;
	}
	public void setFqNo(int fqNo) {
		this.fqNo = fqNo;
	}
	public String getAdId() {
		return adId;
	}
	public void setAdId(String adId) {
		this.adId = adId;
	}
	public String getFqTitle() {
		return fqTitle;
	}
	public void setFqTitle(String fqTitle) {
		this.fqTitle = fqTitle;
	}
	public String getFqContent() {
		return fqContent;
	}
	public void setFqContent(String fqContent) {
		this.fqContent = fqContent;
	}
	public String getFqDatetime() {
		return fqDatetime;
	}
	public void setFqDatetime(String fqDatetime) {
		this.fqDatetime = fqDatetime;
	}
	public int getFqVisit() {
		return fqVisit;
	}
	public void setFqVisit(int fqVisit) {
		this.fqVisit = fqVisit;
	}
	public int getFqReply() {
		return fqReply;
	}
	public void setFqReply(int fqReply) {
		this.fqReply = fqReply;
	}
	
	public String toString() {
		return "Faq board [fqNo ="+ fqNo + ", adId= "+adId 
				+ ", fqTitle= "+fqTitle + ", fqContent= "+fqContent   
				+ ", fqDatetime= " +fqDatetime + ", fqVisit= " + fqVisit 
				+ ", fQReply" + fqReply + "]";
	}
	public FaqBoard(String title, String content, String writer) {
		this.fqTitle = title;
		this.fqContent = content;
		this.adId = writer;
	}


	public FaqBoard(String title, String content, int bno) {
		this.fqTitle = title;
		this.fqContent = content;
		this.fqNo = bno;
	}
	
	
}
