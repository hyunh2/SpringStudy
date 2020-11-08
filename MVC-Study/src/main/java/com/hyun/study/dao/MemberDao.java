package com.hyun.study.dao;

import com.hyun.study.dto.MemberDto;

public interface MemberDao {

	//로그인
	public MemberDto Login(MemberDto memberDto);
	
	//로그아웃
	public int Logout();
	
	
}
