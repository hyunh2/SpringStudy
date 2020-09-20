package com.hyun.cafe.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hyun.cafe.command.Command;
import com.hyun.cafe.command.bakeryCommand.BakeryListCommand;

@Controller
public class BakeryController {
	@Autowired
	private SqlSession sqlSession; //DI로 생성 (autowired로 통해서 알아서 생성되게)
	private Command bcommd; // new로 생성 (Spring 버전을 타지 않는다) 

	
	@RequestMapping("bakerypage")
	public String goBakeryPage(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		bcommd = new BakeryListCommand();
		bcommd.execute(sqlSession, model);
		
		return "bakeryPage/bakeryPage";
	}
}
