package com.hyun.cafe.command.adminCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.hyun.cafe.command.Command;
import com.hyun.cafe.dao.BakeryDao;
import com.hyun.cafe.dao.DrinkDao;
import com.hyun.cafe.dao.SandwitchDao;

public class GoMenuUpdatePageCommand implements Command {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String currentPage = request.getParameter("currentPage");
		int amIdx = Integer.parseInt(request.getParameter("amIdx"));
		int sres=1;
		
		DrinkDao dDao = sqlSession.getMapper(DrinkDao.class);
		SandwitchDao sDao = sqlSession.getMapper(SandwitchDao.class);
		BakeryDao bDao = sqlSession.getMapper(BakeryDao.class);
		
		if(category.equals("샌드위치")) {
			model.addAttribute("sDto", sDao.bringSandwitch(name));
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("amIdx", amIdx);
			model.addAttribute("sres", sres);
		}else if(category.equals("디저트")) {
			model.addAttribute("bDto", bDao.bringBakery(name));
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("amIdx", amIdx);
			
		}else {
			model.addAttribute("dDto", dDao.bringDrink(name));
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("amIdx", amIdx);
			
		}
		

	}

}
