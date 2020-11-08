package com.hyun.study.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hyun.study.dto.MemberDto;
import com.hyun.study.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private SqlSession sqlsession;
	private MemberService mservice;
	private HttpSession session;
	
	@RequestMapping("login")
	public String login(MemberDto memDto, Model model) {
		
		
		
		
		
		return "board/main";
	}
}
