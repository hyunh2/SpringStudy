package com.hyun.cafe.command.boardCommand;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.hyun.cafe.command.Command;
import com.hyun.cafe.dao.BoardDao;

public class BoardListMainCommnad implements Command {
	
	// 메인 홈페이지 공지사항 5개 띄울 
	
		@Override
		public void execute(SqlSession sqlSession, Model model) {
			
			BoardDao bd = sqlSession.getMapper(BoardDao.class);
			
			model.addAttribute("bdDto", bd.list_main());
			model.addAttribute("res", bd.list_main().size());
			
		
		}

}
