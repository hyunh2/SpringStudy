package com.hyun.study.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

	@Autowired
	private SqlSession sqlsession;
	
	
	
	
	@RequestMapping("writerName")
	public String showName(Model model) {
		
		
		return "join/ex_inout";
	}
	
}
