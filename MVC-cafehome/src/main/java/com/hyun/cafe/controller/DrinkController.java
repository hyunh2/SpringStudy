package com.hyun.cafe.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hyun.cafe.command.Command;
import com.hyun.cafe.command.drinkCommand.DrinkListCommand;
import com.hyun.cafe.command.drinkCommand.KindDrinkListCommand;
@Controller
public class DrinkController {
	@Autowired
	private SqlSession sqlSession; //DI로 생성 (autowired로 통해서 알아서 생성되게)
	private Command dcommd; // new로 생성 (Spring 버전을 타지 않는다) 
	
	
	//전체 메뉴 페이지 보여줌 + 메뉴 눌렀을 때 
	@RequestMapping("drinkpage")
	public String showAllDrink(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		dcommd = new DrinkListCommand();
		dcommd.execute(sqlSession, model);
		
		return "drinkPage/drinkPage";
		
	}
	
	@RequestMapping("drink_move")
	public String showDrink(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		dcommd = new KindDrinkListCommand();
		dcommd.execute(sqlSession, model);
		
		return "drinkPage/drinkPage";
	}
	

}
