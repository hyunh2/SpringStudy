package com.hyun.cafe.command.adminCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.hyun.cafe.command.Command;
import com.hyun.cafe.dao.BakeryDao;
import com.hyun.cafe.dao.BoardDao;
import com.hyun.cafe.dao.DrinkDao;
import com.hyun.cafe.dao.SandwitchDao;

public class BoardUpdatePageCommand implements Command {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String currentPage = request.getParameter("currentPage");
		int bdIdx = Integer.parseInt(request.getParameter("bdIdx"));
		int sres=1;
		
		BoardDao bdDao = sqlSession.getMapper(BoardDao.class);
		
		model.addAttribute("bdDto", bdDao.bringBoard(bdIdx));
		model.addAttribute("currentPage", currentPage);
		

	}

}
