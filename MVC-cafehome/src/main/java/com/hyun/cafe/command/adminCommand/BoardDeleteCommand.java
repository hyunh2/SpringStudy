package com.hyun.cafe.command.adminCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.hyun.cafe.command.Command;
import com.hyun.cafe.dao.BoardDao;

public class BoardDeleteCommand implements Command{
	
	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		BoardDao bdDao = sqlSession.getMapper(BoardDao.class);
		
		int bdIdx = Integer.parseInt(request.getParameter("bdIdx"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		
		model.addAttribute("res", bdDao.deleteBoard(bdIdx) );
		model.addAttribute("currentPage", currentPage);
		
	}

}
