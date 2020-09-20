package com.hyun.cafe.dto;

public class BakeryDto {
	private int bIdx;
	private String bName;
	private int bPrice;
	private String bComment;
	private String bImg;
	private String isNew;
	
	public BakeryDto() {
		// TODO Auto-generated constructor stub
	}

	public BakeryDto(int bIdx, String bName, int bPrice, String bComment, String bImg, String isNew) {
		super();
		this.bIdx = bIdx;
		this.bName = bName;
		this.bPrice = bPrice;
		this.bComment = bComment;
		this.bImg = bImg;
		this.isNew = isNew;
	}

	public int getbIdx() {
		return bIdx;
	}

	public void setbIdx(int bIdx) {
		this.bIdx = bIdx;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public int getbPrice() {
		return bPrice;
	}

	public void setbPrice(int bPrice) {
		this.bPrice = bPrice;
	}

	public String getbComment() {
		return bComment;
	}

	public void setbComment(String bComment) {
		this.bComment = bComment;
	}

	public String getbImg() {
		return bImg;
	}

	public void setbImg(String bImg) {
		this.bImg = bImg;
	}

	public String getIsNew() {
		return isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}

	
	
}
