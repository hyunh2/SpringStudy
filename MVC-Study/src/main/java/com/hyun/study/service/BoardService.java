package com.hyun.study.service;

import java.util.List;
import java.util.Map;

import com.hyun.study.dto.BoardDto;
import com.hyun.study.dto.MemberDto;

public interface BoardService {

	public List<BoardDto> boardlist();
	
	public BoardDto boardshow(int idk);
	
	public int boardremove(int idk);
	
	public int boardAdd(BoardDto bdDto);
	
	public List<MemberDto> boardJoinlist();
	
}
