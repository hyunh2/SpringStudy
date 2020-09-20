package com.hyun.cafe.command.bakeryCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.hyun.cafe.command.Command;
import com.hyun.cafe.dao.BakeryDao;

public class BakeryListCommand implements Command {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String getTitle = request.getParameter("getTitle");
		
		BakeryDao bDao = sqlSession.getMapper(BakeryDao.class); 
		
		model.addAttribute("getTitle", getTitle);
		model.addAttribute("bDto", bDao.AllBakery());
		model.addAttribute("res", bDao.AllBakery().size());
		
	}

}
