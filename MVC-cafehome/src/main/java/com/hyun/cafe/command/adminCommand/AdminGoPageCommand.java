package com.hyun.cafe.command.adminCommand;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.hyun.cafe.command.Command;
import com.hyun.cafe.dao.AllMenuDao;
import com.hyun.cafe.dao.BoardDao;

public class AdminGoPageCommand implements Command {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		BoardDao bDao = sqlSession.getMapper(BoardDao.class);
		AllMenuDao amDao = sqlSession.getMapper(AllMenuDao.class);
		
		//여기서 전체 게시글, 전체 메뉴, 각각 개수를 가져와서 보내줘야 함.
		
		model.addAttribute("bDto", bDao.adminAllBoard());
		model.addAttribute("boardRes", bDao.totalRecord());
		model.addAttribute("amDto", amDao.AllMenuList());
		model.addAttribute("menuRes", amDao.AllMenuList().size());
		

	}

}
