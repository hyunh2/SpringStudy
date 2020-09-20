package com.hyun.cafe.dto;

public class DrinkDto {
	private int dIdx;
	private String dName;
	private int dPrice;
	private String dCategory;
	private String dComment;
	private String dImg;
	private String dHotnIce;
	private String isNew;
	
	public DrinkDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public DrinkDto(int dIdx, String dName, int dPrice, String dCategory, String dComment, String dImg,
			String dHotnIce, String isNew) {
		super();
		this.dIdx = dIdx;
		this.dName = dName;
		this.dPrice = dPrice;
		this.dCategory = dCategory;
		this.dComment = dComment;
		this.dImg = dImg;
		this.dHotnIce = dHotnIce;
		this.isNew = isNew;
	}



	public int getdIdx() {
		return dIdx;
	}
	public void setdIdx(int dIdx) {
		this.dIdx = dIdx;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public int getdPrice() {
		return dPrice;
	}
	public void setdPrice(int dPrice) {
		this.dPrice = dPrice;
	}
	public String getdCategory() {
		return dCategory;
	}
	public void setdCategory(String dCategory) {
		this.dCategory = dCategory;
	}
	public String getdComment() {
		return dComment;
	}
	public void setdComment(String dComment) {
		this.dComment = dComment;
	}
	public String getdImg() {
		return dImg;
	}
	public void setdImg(String dImg) {
		this.dImg = dImg;
	}
	public String getdHotnIce() {
		return dHotnIce;
	}
	public void setdHotnIce(String dHotnIce) {
		this.dHotnIce = dHotnIce;
	}
	public String getIsNew() {
		return isNew;
	}
	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}
	
	
	

}
