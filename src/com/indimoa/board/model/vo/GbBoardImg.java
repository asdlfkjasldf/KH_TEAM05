package com.indimoa.board.model.vo;

public class GbBoardImg {
//	IMG_PATH NOT NULL VARCHAR2(50) 
//	GB_NO             NUMBER(11)   

	private String imgPath;
	private int gbNo;

	@Override
	public String toString() {
		return "GbBoardImg [imgPath=" + imgPath + ", gbNo=" + gbNo + "]";
	}

	public GbBoardImg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GbBoardImg(String imgPath, int gbNo) {
		super();
		this.imgPath = imgPath;
		this.gbNo = gbNo;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public int getGbNo() {
		return gbNo;
	}

	public void setGbNo(int gbNo) {
		this.gbNo = gbNo;
	}

}
