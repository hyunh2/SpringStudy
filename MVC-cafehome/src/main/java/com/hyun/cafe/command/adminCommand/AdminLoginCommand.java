package com.hyun.cafe.command.adminCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.hyun.cafe.command.Command;
import com.hyun.cafe.dao.AdminDao;
import com.hyun.cafe.dto.AdminDto;

public class AdminLoginCommand implements Command {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpSession session = request.getSession();
		int res = 0;
		
		if((String)session.getValue("aId") != null) {
			System.out.println("세션에 아이디 존재~");
			session.removeAttribute("aId");
		}
		
		AdminDao adao = sqlSession.getMapper(AdminDao.class);
		
		String aId = request.getParameter("aId");
		String aPw = request.getParameter("aPw");
		System.out.println(aId);
		System.out.println(aPw);
		
		AdminDto aDto =  adao.adminlogin(aId, aPw);
		
		
		
		if(aDto != null) {
			System.out.println("여기까지 성공-존재");
			res =1;
			session.setAttribute("aId", aId);
			model.addAttribute("res", res);
			
		}else {
			System.out.println("여기까지 성공-노존재");
			res=0;
			model.addAttribute("res", res);
			
		}

	}

}
