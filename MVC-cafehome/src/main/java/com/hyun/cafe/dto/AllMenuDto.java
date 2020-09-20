package com.hyun.cafe.dto;

public class AllMenuDto {
	private int amIdx;
	private String amName;
	private String amCategory;
	
	public AllMenuDto() {
		// TODO Auto-generated constructor stub
	}

	public AllMenuDto(int amIdx, String amName, String amCategory) {
		super();
		this.amIdx = amIdx;
		this.amName = amName;
		this.amCategory = amCategory;
	}

	public int getAmIdx() {
		return amIdx;
	}

	public void setAmIdx(int amIdx) {
		this.amIdx = amIdx;
	}

	public String getAmName() {
		return amName;
	}

	public void setAmName(String amName) {
		this.amName = amName;
	}

	public String getamCategory() {
		return amCategory;
	}

	public void setamCategory(String amCategory) {
		this.amCategory = amCategory;
	}
	
	
}
