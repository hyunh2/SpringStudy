package com.hyun.study.dto;

import java.sql.Date;

public class BoardDto {
	
	private int idk;
	private String title;
	private String id;
	private String comment;
	private Date regdate;
	
	public BoardDto() {
		// TODO Auto-generated constructor stub
	}
	
	public BoardDto(int idk, String title, String id, String comment, Date regdate) {
		super();
		this.idk = idk;
		this.title = title;
		this.id = id;
		this.comment = comment;
		this.regdate = regdate;
	}
	public int getIdk() {
		return idk;
	}
	public void setIdk(int idk) {
		this.idk = idk;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	
	
	
	
}
