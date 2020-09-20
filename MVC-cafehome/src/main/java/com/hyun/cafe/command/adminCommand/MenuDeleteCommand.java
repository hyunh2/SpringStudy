package com.hyun.cafe.command.adminCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.hyun.cafe.command.Command;
import com.hyun.cafe.dao.AllMenuDao;
import com.hyun.cafe.dao.BakeryDao;
import com.hyun.cafe.dao.DrinkDao;
import com.hyun.cafe.dao.SandwitchDao;

public class MenuDeleteCommand implements Command {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		AllMenuDao amDao = sqlSession.getMapper(AllMenuDao.class);
		
		if(category.equals("샌드위치")) {
			SandwitchDao sDao = sqlSession.getMapper(SandwitchDao.class);
			model.addAttribute("deleteRes", sDao.deleteMenu(name));
			amDao.deleteMenu(name);
		}else if(category.equals("디저트")){
			BakeryDao bDao = sqlSession.getMapper(BakeryDao.class);
			model.addAttribute("deleteRes", bDao.deleteMenu(name));
			amDao.deleteMenu(name);
		}else {
			DrinkDao dDao = sqlSession.getMapper(DrinkDao.class);
			model.addAttribute("deleteRes",dDao.deleteMenu(name) );
			amDao.deleteMenu(name);
		}
		
		model.addAttribute("currentPage", currentPage);
	}

}
