package com.hyun.cafe.dto;

import java.sql.Date;

public class BoardDto {
	private int bdIdx;
	private String bdTitle;
	private String bdComment;
	private String bdImg;
	private String bdCategory;
	private Date bdDate;

	public BoardDto() {
		// TODO Auto-generated constructor stub
	}

	public BoardDto(int bdIdx, String bdTitle, String bdComment, String bdImg, String bdCategory, Date bdDate) {
		super();
		this.bdIdx = bdIdx;
		this.bdTitle = bdTitle;
		this.bdComment = bdComment;
		this.bdImg = bdImg;
		this.bdCategory = bdCategory;
		this.bdDate = bdDate;
	}

	public int getBdIdx() {
		return bdIdx;
	}

	public void setBdIdx(int bdIdx) {
		this.bdIdx = bdIdx;
	}

	public String getBdTitle() {
		return bdTitle;
	}

	public void setBdTitle(String bdTitle) {
		this.bdTitle = bdTitle;
	}

	public String getBdComment() {
		return bdComment;
	}

	public void setBdComment(String bdComment) {
		this.bdComment = bdComment;
	}

	public String getBdImg() {
		return bdImg;
	}

	public void setBdImg(String bdImg) {
		this.bdImg = bdImg;
	}

	public String getBdCategory() {
		return bdCategory;
	}

	public void setBdCategory(String bdCategory) {
		this.bdCategory = bdCategory;
	}

	public Date getBdDate() {
		return bdDate;
	}

	public void setBdDate(Date bdDate) {
		this.bdDate = bdDate;
	}
	
	
	
}
