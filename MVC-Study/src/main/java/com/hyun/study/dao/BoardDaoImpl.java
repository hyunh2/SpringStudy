package com.hyun.study.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyun.study.dto.BoardDto;
import com.hyun.study.dto.MemberDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSession sqlsession;

	@Override
	public int boardAdd(BoardDto boardDto) {
		
		return sqlsession.insert("addBoard", boardDto);
	}

	@Override
	public List<BoardDto> boardList() {
		
		
		return sqlsession.selectList("listAll");
	}

	@Override
	public BoardDto boardView(int idk) {
		return sqlsession.selectOne("show", idk);
	}
	
	@Override
	public int boardremove(int idk) {
		
		return sqlsession.delete("remove", idk);
	}

	@Override
	public List<MemberDto> boardlistJoin() {
		
		return sqlsession.selectList("listjoin");
	}
}
