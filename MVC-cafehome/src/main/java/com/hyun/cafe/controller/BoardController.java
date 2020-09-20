package com.hyun.cafe.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hyun.cafe.command.Command;
import com.hyun.cafe.command.boardCommand.BoardListCommand;
@Controller
public class BoardController {
	@Autowired
	private SqlSession sqlSession; //DI로 생성 (autowired로 통해서 알아서 생성되게)
	private Command bdcommd; // new로 생성 (Spring 버전을 타지 않는다) 
	
	
	@RequestMapping("boardPage")
	public String goBoardPage(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		bdcommd = new BoardListCommand();
		bdcommd.execute(sqlSession, model);
		
		return "boardPage/boardPage";
		
	}

}
