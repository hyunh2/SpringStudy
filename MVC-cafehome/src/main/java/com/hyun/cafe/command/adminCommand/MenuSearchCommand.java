package com.hyun.cafe.command.adminCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.hyun.cafe.command.Command;
import com.hyun.cafe.command.boardCommand.Paging;
import com.hyun.cafe.dao.AllMenuDao;

public class MenuSearchCommand implements Command {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int IsSearch = 0;
		
		String search = request.getParameter("search"); //카테고리인가 이름인가
		String content = "%"+request.getParameter("content")+"%";//검색 한 거
		
		AllMenuDao amDao = sqlSession.getMapper(AllMenuDao.class);
		
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
		
		int totalRecord =0;
		
		
		if(search.equals("amCategory")) {
			
			totalRecord = amDao.totalRecord_category(content);
			String paging = PagingQuery.getPaging("searchMenu", nowPage, recordPerPage, totalRecord,search,content);
			model.addAttribute("paging", paging);
			model.addAttribute("amDto", amDao.searchCategory(content,begin-1,recordPerPage));
			model.addAttribute("IsSearch", 1);
			model.addAttribute("sh_res", amDao.searchCategory(content,begin-1,recordPerPage).size());
			model.addAttribute("res", amDao.AllMenuList().size());
		}else {
			totalRecord = amDao.totalRecord_name(content);
			String paging = PagingQuery.getPaging("searchMenu", nowPage, recordPerPage, totalRecord,search,content);
			model.addAttribute("paging", paging);
			model.addAttribute("amDto", amDao.searchName(content,begin-1,recordPerPage));
			model.addAttribute("IsSearch", 1);
			model.addAttribute("sh_res", amDao.searchName(content,begin-1,recordPerPage).size());
			model.addAttribute("res", amDao.AllMenuList().size());
			
		}
		
	}

}
