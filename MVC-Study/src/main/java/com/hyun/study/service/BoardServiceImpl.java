package com.hyun.study.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyun.study.dao.BoardDao;
import com.hyun.study.dto.BoardDto;
import com.hyun.study.dto.MemberDto;

@Service
public class BoardServiceImpl implements BoardService {
@Autowired
private BoardDao bdDao;
	
	@Override
	public List<BoardDto> boardlist() {
		return bdDao.boardList();
	}

	@Override
		public BoardDto boardshow(int idk) {
			
			return bdDao.boardView(idk);
		}
	
	@Override
		public int boardremove(int idk) {
			
			return bdDao.boardremove(idk);
		}
	
	@Override
		public int boardAdd(BoardDto bdDto) {
			
			return bdDao.boardAdd(bdDto);
		}
	
	@Override
		public List<MemberDto> boardJoinlist() {
			
		
			return bdDao.boardlistJoin();
		}
}
