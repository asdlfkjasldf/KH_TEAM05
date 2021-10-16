package com.indimoa.board.model.vo;

public class FbBoardImg {
//	IMG_PATH NOT NULL VARCHAR2(50) 
//	FB_NO             NUMBER(11)   
	private String imgPath;
	private int fbNo;

	@Override
	public String toString() {
		return "FbBoardImg [imgPath=" + imgPath + ", fbNo=" + fbNo + "]";
	}

	public FbBoardImg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FbBoardImg(String imgPath, int fbNo) {
		super();
		this.imgPath = imgPath;
		this.fbNo = fbNo;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public int getFbNo() {
		return fbNo;
	}

	public void setFbNo(int fbNo) {
		this.fbNo = fbNo;
	}

}
