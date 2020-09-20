package com.hyun.cafe.dto;

public class AdminDto {
	private int aIdx;
	private String aId;
	private String aPw;
	
	public AdminDto() {
		// TODO Auto-generated constructor stub
	}

	public AdminDto(int aIdx, String aId, String aPw) {
		super();
		this.aIdx = aIdx;
		this.aId = aId;
		this.aPw = aPw;
	}

	public int getaIdx() {
		return aIdx;
	}

	public void setaIdx(int aIdx) {
		this.aIdx = aIdx;
	}

	public String getaId() {
		return aId;
	}

	public void setaId(String aId) {
		this.aId = aId;
	}

	public String getaPw() {
		return aPw;
	}

	public void setaPw(String aPw) {
		this.aPw = aPw;
	}
	
	
}
