package com.hyun.study.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.hyun.study.dto.MemberDto;

public class MemberDaoImpl implements MemberDao {
	@Autowired
	private MemberDao mDao;
	
	@Override
	public MemberDto Login(MemberDto memberDto) {
		
		return mDao.Login(memberDto);
	}

	@Override
	public int Logout() {
		// TODO Auto-generated method stub
		return 0;
	}

}
