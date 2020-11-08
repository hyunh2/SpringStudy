package com.hyun.study.dao;

import java.util.List;
import java.util.Map;

import com.hyun.study.dto.BoardDto;
import com.hyun.study.dto.MemberDto;

public interface BoardDao {

	
	//게시글 추가
		public int boardAdd(BoardDto boardDto);
		
		//게시글 리스트
		public List<BoardDto> boardList();
		
		//게시글 뷰
		public BoardDto boardView(int idk);
		
		//게시글 삭제
		public int boardremove(int idk);
		
		public List<MemberDto> boardlistJoin();
}
