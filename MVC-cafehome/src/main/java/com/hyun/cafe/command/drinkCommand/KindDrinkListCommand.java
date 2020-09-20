package com.hyun.cafe.command.drinkCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.hyun.cafe.command.Command;
import com.hyun.cafe.dao.DrinkDao;

public class KindDrinkListCommand implements Command {
	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String , Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String dCategory= request.getParameter("category");
		
		DrinkDao dd = sqlSession.getMapper(DrinkDao.class);
		
		model.addAttribute("dDto", dd.KindDrink(dCategory));
		model.addAttribute("res", dd.KindDrink(dCategory).size());
		model.addAttribute("getTitle", dCategory);
		model.addAttribute("category", dCategory);
		
		
	}
	

}
