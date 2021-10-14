package com.indimoa.game.model.vo;



public class Game {
	// GG_NO
//	 GG_TITLE VARCHAR(20) NOT NULL,
//    GG_PRICE NUMBER(11) NOT NULL,
//    GG_SYSTEM_REQUIREMENTS VARCHAR(255) NOT NULL,
//    GG_GENRE VARCHAR(255) NOT NULL,
//    GG_DEVELOPER VARCHAR(30) NOT NULL, 
//    GG_RELEASE_DATE TIMESTAMP NOT NULL,
//    GG_PUBLISHER VARCHAR(20) NOT NULL,
//    GG_LANGUAGES VARCHAR(30) NOT NULL,
//    GG_INFORMATION VARCHAR(2000) NOT NULL,

	private int ggNo;
	private String ggTitle;
	private int ggPrice;
	private String ggSystemRequirement;
	private String ggGenre;
	private String ggDeveloper;
	private String ggReleaseDate;
	private String ggPublisher;
	private String ggLanguages;
	private String ggInfomation;


	
	public Game(int ggNo, String ggTitle, int ggPrice, String ggSystemRequirement, String ggGenre,
			String ggDeveloper, String ggReleaseDate, String ggPublisher, String ggLanguages, String ggInfomation) {
		super();
		this.ggNo = ggNo;
		this.ggTitle = ggTitle;
		this.ggPrice = ggPrice;
		this.ggSystemRequirement = ggSystemRequirement;
		this.ggGenre = ggGenre;
		this.ggDeveloper = ggDeveloper;
		this.ggReleaseDate = ggReleaseDate;
		this.ggPublisher = ggPublisher;
		this.ggLanguages = ggLanguages;
		this.ggInfomation = ggInfomation;
	}
	
	public Game() {
		
	}

	public int getGgNo() {
		return ggNo;
	}

	public void setGgNo(int ggNo) {
		this.ggNo = ggNo;
	}

	public String getGgTitle() {
		return ggTitle;
	}

	public void setGgTitle(String ggTitle) {
		this.ggTitle = ggTitle;
	}

	public int getGgPrice() {
		return ggPrice;
	}

	public void setGgPrice(int ggPrice) {
		this.ggPrice = ggPrice;
	}

	public String getGgSystemRequirement() {
		return ggSystemRequirement;
	}

	public void setGgSystemRequirement(String ggSystemRequirement) {
		this.ggSystemRequirement = ggSystemRequirement;
	}

	public String getGgGenre() {
		return ggGenre;
	}

	public void setGgGenre(String ggGenre) {
		this.ggGenre = ggGenre;
	}

	public String getGgDeveloper() {
		return ggDeveloper;
	}

	public void setGgDeveloper(String ggDeveloper) {
		this.ggDeveloper = ggDeveloper;
	}

	public String getGgReleaseDate() {
		return ggReleaseDate;
	}

	public void setGgReleaseDate(String ggReleaseDate) {
		this.ggReleaseDate = ggReleaseDate;
	}

	public String getGgPublisher() {
		return ggPublisher;
	}

	public void setGgPublisher(String ggPublisher) {
		this.ggPublisher = ggPublisher;
	}

	public String getGgLanguages() {
		return ggLanguages;
	}

	public void setGgLanguages(String ggLanguages) {
		this.ggLanguages = ggLanguages;
	}

	public String getGgInfomation() {
		return ggInfomation;
	}

	public void setGgInfomation(String ggInfomation) {
		this.ggInfomation = ggInfomation;
	}

	@Override
	public String toString() {
		return "Game [ggNo=" + ggNo + ", ggTitle=" + ggTitle + ", ggPrice=" + ggPrice + ", ggSystemRequirement="
				+ ggSystemRequirement + ", ggGenre=" + ggGenre + ", ggDeveloper=" + ggDeveloper + ", ggReleaseDate="
				+ ggReleaseDate + ", ggPublisher=" + ggPublisher + ", ggLanguages=" + ggLanguages + ", ggInfomation="
				+ ggInfomation + "]";
	}

}