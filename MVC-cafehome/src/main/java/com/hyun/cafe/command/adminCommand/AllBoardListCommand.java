package com.hyun.cafe.command.adminCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.hyun.cafe.command.Command;
import com.hyun.cafe.command.boardCommand.Paging;
import com.hyun.cafe.dao.AllMenuDao;
import com.hyun.cafe.dao.BoardDao;

public class AllBoardListCommand implements Command {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		BoardDao bdDao = sqlSession.getMapper(BoardDao.class);
		
		//현재 페이지 
		String currentPage = request.getParameter("currentPage");
		int nowPage = 1;
		
		// nowpage 설정
		if(currentPage !=null && !currentPage.isEmpty()) {
				nowPage = Integer.parseInt(currentPage);
		}
		//currentPage 저장
		model.addAttribute("currentPage", nowPage);
				
		int recordPerPage = 10; // 한 페이지당 10개의 게시글
		int begin = (nowPage - 1 )*recordPerPage+1; // 시작 위치 
		
		int totalRecord = bdDao.totalRecord();
		String paging = Paging.getPaging("dnuMenu", nowPage, recordPerPage, totalRecord);
				
		model.addAttribute("paging", paging);
		model.addAttribute("bdDto", bdDao.AllBoard(begin-1, recordPerPage));
		model.addAttribute("res", bdDao.AllBoard(begin-1, recordPerPage).size());


	}

}
