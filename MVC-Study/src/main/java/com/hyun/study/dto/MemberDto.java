package com.hyun.study.dto;

import java.sql.Date;

public class MemberDto {
	private int idk;
	private String id;
	private String name;
	private String email;
	private String pw;
	private Date regdate;
	
	private BoardDto board;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public MemberDto(int idk, String id, String name, String email, String pw, Date regdate, BoardDto board) {
		super();
		this.idk = idk;
		this.id = id;
		this.name = name;
		this.email = email;
		this.pw = pw;
		this.regdate = regdate;
		this.board = board;
	}




	public int getIdk() {
		return idk;
	}



	public void setIdk(int idk) {
		this.idk = idk;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}



	public BoardDto getBoard() {
		return board;
	}



	public void setBoard(BoardDto board) {
		this.board = board;
	}
	
	
}
