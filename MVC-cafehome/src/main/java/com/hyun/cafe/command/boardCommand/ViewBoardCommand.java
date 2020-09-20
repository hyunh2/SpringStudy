package com.hyun.cafe.command.boardCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.hyun.cafe.command.Command;
import com.hyun.cafe.dao.BoardDao;

public class ViewBoardCommand implements Command {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int bdIdx = Integer.parseInt(request.getParameter("bdIdx"));
		
		BoardDao bdDao = sqlSession.getMapper(BoardDao.class);
		
		
		// bdIdx 값에 따라 실행할 코드 다름
		// 맨 첫, 맨 끝 게시글 -> 다음글 /이전글만 존재하게
		
		int totalRecord = bdDao.totalRecord();
		
		if(totalRecord == 1) {//게시글이 딱 1개 있음.
			model.addAttribute("bdDto",bdDao.viewBoard(bdIdx) );
			model.addAttribute("res", totalRecord);
			
		}/*else if(totalRecord ==2) { //다음글 만 존재
			model.addAttribute("nextboard", bdDao.view_nextBoard(bdIdx));
			model.addAttribute("bdDto",bdDao.viewBoard(bdIdx) );
			
		}else if(bdIdx == totalRecord) { // 이전 글만 존재
			model.addAttribute("forwardboard", bdDao.view_forwardBoard(bdIdx));
			model.addAttribute("bdDto",bdDao.viewBoard(bdIdx) );
			
		}*/else {// 이전, 다음 글 존재
			model.addAttribute("nextboard", bdDao.view_nextBoard(bdIdx));
			model.addAttribute("forwardboard", bdDao.view_forwardBoard(bdIdx));
			model.addAttribute("bdDto",bdDao.viewBoard(bdIdx) );
		}
		
		
		model.addAttribute("currentPage", request.getParameter("currentPage"));
	}

}
