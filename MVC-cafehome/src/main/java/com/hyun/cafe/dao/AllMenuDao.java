package com.hyun.cafe.dao;

import java.util.ArrayList;

import com.hyun.cafe.dto.AllMenuDto;

public interface AllMenuDao {
	
	//모든 메뉴 나오게
	public ArrayList<AllMenuDto> AllMenuList();
	
	//모든 메뉴 - 페이징 있게 
	public ArrayList<AllMenuDto> AllMenuList_paging(int begin, int recordPerPage);
	
	//메뉴 삽입
	public int addMenu(String amName, String amCategory);
	
	//메뉴 총 갯수
	public int totalRecord();
	
	//메뉴 수정,삭제 검색 - 카테고리 검색
	public ArrayList<AllMenuDto> searchCategory(String amCategory,int begin, int recordPerPage);
	//메뉴 수정,삭제 검색 - 이름 검색
	public ArrayList<AllMenuDto> searchName(String amName,int begin, int recordPerPage);
	
	//총 갯수 - 카테고리 검색
	public int totalRecord_category(String amCategory);
	
	//총 갯수 - 이름 검색
	public int totalRecord_name(String amName);
	
	//메뉴 수정
	public int updateMenu(int amIdx,String amName, String amCategory);

	//메뉴 삭제
	public int deleteMenu(String amName);
}
