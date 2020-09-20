package com.hyun.cafe.dao;

import java.util.ArrayList;

import com.hyun.cafe.dto.SandwitchDto;

public interface SandwitchDao {
	
	
	public ArrayList<SandwitchDao> AllSandwitch();
	
	//이미지가 없는 메뉴를 추가합니다.
	public int addMenu_no_img(String sName,int sPrice,String sComment, String isNew);

	//이미지가 있는 메뉴 추가
	public int addMenu_img(String sName,int sPrice,String sComment,String sImg,String isNew);

	//수정위해 해당 샌드위치 가져오기
	public SandwitchDto bringSandwitch(String sName);
	
	//이미지가 없는 메뉴를 수정합니다.
	public int updateMenu_no_img(int sIdx, String sName,int sPrice,String sComment, String isNew);
	
	//이미지가 있는 메뉴 수정
	public int updateMenu_img(int sIdx,String sName,int sPrice,String sComment,String sImg,String isNew);
	
	//메뉴 삭제
	public int deleteMenu(String sName);
}
