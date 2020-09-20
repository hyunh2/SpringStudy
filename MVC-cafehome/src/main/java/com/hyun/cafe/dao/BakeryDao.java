package com.hyun.cafe.dao;

import java.util.ArrayList;

import com.hyun.cafe.dto.BakeryDto;

public interface BakeryDao {

	public ArrayList<BakeryDao> AllBakery();
	
	//이미지가 없는 메뉴를 추가합니다.
	public int addMenu_no_img(String bName,int bPrice,String bComment, String isNew);

	//이미지가 있는 메뉴 추가
	public int addMenu_img(String bName,int bPrice,String bComment,String bImg,String isNew);
	
	//수정 위해 해당 디저트 가져오기
	public BakeryDto bringBakery(String bName);
	
	//이미지가 없는 메뉴를 수정.
	public int updateMenu_no_img(int bIdx,String bName,int bPrice,String bComment, String isNew);
	
	//이미지가 있는 메뉴 수정
	public int updateMenu_img(int bIdx,String bName,int bPrice,String bComment,String bImg,String isNew);
	
	//메뉴 삭제
	public int deleteMenu(String bName);
}
