package com.hyun.cafe.dao;

import java.util.ArrayList;

import com.hyun.cafe.dto.DrinkDto;

public interface DrinkDao {

	//모든 음료 보여줌 + 메뉴 눌렀을 때 첫 화면 
	public ArrayList<DrinkDto> AllDrink();

	//음료 선택
	public ArrayList<DrinkDto> KindDrink(String dCategory);

	//이미지가 없는 메뉴를 추가합니다.
	public int addMenu_no_img(String dName,int dPrice,String dCategory,String dComment,String dHotnIce, String isNew);

	//이미지가 있는 메뉴 추가
	public int addMenu_img(String dName,int dPrice,String dCategory,String dComment,String dImg,String dHotnIce, String isNew);
	
	//수정 위해 해당 음료 가져오기
	public DrinkDto bringDrink(String dName);

	//이미지가 없는 메뉴 수정
	public int updateMenu_no_img(int dIdx,String dName,int dPrice,String dCategory,String dComment,String dHotnIce, String isNew);
	
	//이미지가 있는 메뉴 수정
	public int updateMenu_img(int dIdx,String dName,int dPrice,String dCategory,String dComment,String dImg,String dHotnIce, String isNew);
	
	//메뉴 삭제
	public int deleteMenu(String dName);

}
