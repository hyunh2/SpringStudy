package com.hyun.cafe.dao;

import com.hyun.cafe.dto.AdminDto;

public interface AdminDao {
	
	//로그인
	public AdminDto adminlogin(String aId, String aPw);
	
	
}
