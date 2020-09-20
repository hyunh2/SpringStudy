package com.hyun.cafe.dto;

public class SandwitchDto {
	private int sIdx;
	private String sName;
	private int sPrice;
	private String sComment;
	private String sImg;
	private String isNew;
	
	public SandwitchDto() {
		// TODO Auto-generated constructor stub
	}

	public SandwitchDto(int sIdx, String sName, int sPrice, String sComment, String sImg, String isNew) {
		super();
		this.sIdx = sIdx;
		this.sName = sName;
		this.sPrice = sPrice;
		this.sComment = sComment;
		this.sImg = sImg;
		this.isNew = isNew;
	}

	public int getsIdx() {
		return sIdx;
	}

	public void setsIdx(int sIdx) {
		this.sIdx = sIdx;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getsPrice() {
		return sPrice;
	}

	public void setsPrice(int sPrice) {
		this.sPrice = sPrice;
	}

	public String getsComment() {
		return sComment;
	}

	public void setsComment(String sComment) {
		this.sComment = sComment;
	}

	public String getsImg() {
		return sImg;
	}

	public void setsImg(String sImg) {
		this.sImg = sImg;
	}

	public String getIsNew() {
		return isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}
	
	

}