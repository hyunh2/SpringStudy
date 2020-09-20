package com.hyun.cafe.command.sandwitchCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.hyun.cafe.command.Command;
import com.hyun.cafe.dao.SandwitchDao;

public class SandwitchListCommand implements Command {
	
	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		SandwitchDao sDao = sqlSession.getMapper(SandwitchDao.class);
		
		String getTitle = request.getParameter("getTitle");
		
		model.addAttribute("getTitle", getTitle);
		model.addAttribute("sDto", sDao.AllSandwitch());
		model.addAttribute("res", sDao.AllSandwitch().size());
		
		
		
		
	}

}
