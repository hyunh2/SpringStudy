package com.hyun.cafe;

import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hyun.cafe.command.Command;
import com.hyun.cafe.command.boardCommand.BoardListMainCommnad;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private SqlSession sqlSession;
	private Command command;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//맨 처음에 시작했을 때 index페이지로 오는데
	//여기서 공지사항 가져와야함.. <- command사용해야함(board쪽)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale,Model model) {
		
		command = new BoardListMainCommnad();
		command.execute(sqlSession, model);
		
		
		return "/index";
	}
	
	//여기서 공지사항 가져와야함.. <- command사용해야함(board쪽)
	@RequestMapping("index")
	public String goHome(Model model) {
		command = new BoardListMainCommnad();
		command.execute(sqlSession, model);
		return "/index";
	}
	
	
}
