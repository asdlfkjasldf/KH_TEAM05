package com.indimoa.board.model.vo;

public class TipBoardImg {
//	IMG_PATH NOT NULL VARCHAR2(50) 
//	TIP_NO             NUMBER(11)   

	private String imgPath;
	private int tipNo;

	@Override
	public String toString() {
		return "TipBoardImg [imgPath=" + imgPath + ", tipNo=" + tipNo + "]";
	}

	public TipBoardImg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipBoardImg(String imgPath, int tipNo) {
		super();
		this.imgPath = imgPath;
		this.tipNo = tipNo;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public int getTipNo() {
		return tipNo;
	}

	public void setTipNo(int tipNo) {
		this.tipNo = tipNo;
	}

}
