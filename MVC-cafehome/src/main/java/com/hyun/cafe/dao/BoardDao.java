package com.hyun.cafe.dao;

import java.util.ArrayList;

import com.hyun.cafe.dto.AllMenuDto;
import com.hyun.cafe.dto.BoardDto;

public interface BoardDao {
	
	public ArrayList<BoardDto> list_main(); // 메인 홈페이지 전용(공지사항 5개 출력)
	
	//게시판 페이지 들어갔을 때 
	public ArrayList<BoardDto> AllBoard(int begin, int recordPerPage);
	
	//게시글 전체 개수 
	public int totalRecord();
	
	//관리자 페이지에서 게시글 전체 가져오기
	public ArrayList<BoardDto> adminAllBoard();
	
	//이미지 없이 게시글 작성
	public int writeBoard_without_img(String bdTitle, String bdComment, String bdCategory);
	
	//이미지 있는 게시글 작성
	public int writeBoard_img(String bdTitle, String bdComment, String bdImg,String bdCategory);
	
	//게시글 수정,삭제 검색 - 카테고리 검색
	public ArrayList<BoardDto> searchCategory(String bdCategory,int begin, int recordPerPage);
	
	//게시글 수정,삭제 검색 - 제목 검색
	public ArrayList<BoardDto> searchTitle(String bdTitle,int begin, int recordPerPage);
	
	//총 갯수 - 카테고리 검색
	public int totalRecord_category(String bdCategory);
		
	//총 갯수 - 제목 검색
	public int totalRecord_title(String bdTitle);
	
	//수정할 게시글 가져오기
	public BoardDto bringBoard(int bdIdx);
	
	//게시글 수정 - 이미지 있음
	public int updateBoard_img(int bdIdx, String bdTitle, String bdComment, String bdImg, String bdCategory);
	
	//게시글 수정 - 이미지 없음
	public int updateBoard_no_img(int bdIdx, String bdTitle, String bdComment, String bdCategory);
	
	//게시글 삭제
	public int deleteBoard(int bdIdx);
	
	//현재 게시글 보기
	public BoardDto viewBoard(int bdIdx);
	
	//이전 글 게시글 제목
	public BoardDto view_forwardBoard(int bdIdx);
	
	//다음글 게시글 제목
	public BoardDto view_nextBoard(int bdIdx);
	
}
