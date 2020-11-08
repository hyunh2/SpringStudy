package com.hyun.cafe.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hyun.cafe.command.Command;
import com.hyun.cafe.command.adminCommand.AddBoardCommand;
import com.hyun.cafe.command.adminCommand.AdminGoPageCommand;
import com.hyun.cafe.command.adminCommand.AdminLoginCommand;
import com.hyun.cafe.command.adminCommand.AdminLooutCommand;
import com.hyun.cafe.command.adminCommand.AllBoardListCommand;
import com.hyun.cafe.command.adminCommand.AllMenuListCommand;
import com.hyun.cafe.command.adminCommand.BoardDeleteCommand;
import com.hyun.cafe.command.adminCommand.BoardSearchCommand;
import com.hyun.cafe.command.adminCommand.BoardUpdatePageCommand;
import com.hyun.cafe.command.adminCommand.GoMenuUpdatePageCommand;
import com.hyun.cafe.command.adminCommand.MenuAddCommand;
import com.hyun.cafe.command.adminCommand.MenuDeleteCommand;
import com.hyun.cafe.command.adminCommand.MenuSearchCommand;
import com.hyun.cafe.command.adminCommand.UpdateBoardCommand;
import com.hyun.cafe.command.adminCommand.UpdateMenuCommand;
import com.hyun.cafe.command.boardCommand.BoardListMainCommnad;

@Controller
public class AdminController {
	
	@Autowired
	private SqlSession sqlSession; //DI로 생성 (autowired로 통해서 알아서 생성되게)
	private Command acommd; // new로 생성 (Spring 버전을 타지 않는다) 
	
	
	//관리자 로그인 페이지로 이동. 
		@RequestMapping("adminLoginPage")
		public String goAdminLogin() {
			return "admin/adminLogin";
		}
		
	
	//관리자 로그인시
	@RequestMapping("adminLogin")
	public String goLogin(HttpServletRequest  request, Model  model) {
		model.addAttribute("request", request);
		acommd = new AdminLoginCommand();
		acommd.execute(sqlSession, model);
		
		return"admin/adminLogin";
	}
	
	//관리자 페이지로 이동
	@RequestMapping("adminPage")
	public String goAdminPage(Model model) {
		
		acommd = new AdminGoPageCommand();
		acommd.execute(sqlSession, model);
		
		return "admin/adminPage";
	}
	
	//관리자 로그아웃
	@RequestMapping("adminLogout")
	public String adminLogOut(HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		acommd = new AdminLooutCommand();
		acommd.execute(sqlSession, model);
		Command commd = new BoardListMainCommnad();
		commd.execute(sqlSession, model);
		return "/index";
	}
	
	//메뉴 추가 페이지로 이동
	@RequestMapping("addMenu")
	public String goAddMenu() {
		
		return "admin/menuAddPage";
	}
	
	//메뉴 추가 시작
	@RequestMapping("addNewMenu")
	public String AddNewMenu(MultipartHttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		acommd = new MenuAddCommand();
		acommd.execute(sqlSession, model);
		return "admin/menuAddResult";
	}
	
	//메뉴 수정,삭제 페이지 이동
	@RequestMapping("dnuMenu")
	public String goDeleteAndUpdatePage(HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		acommd = new AllMenuListCommand();
		acommd.execute(sqlSession, model);
		return "admin/menuDeletNUpdatePage";
	}
	
	//메뉴 수정,삭제 -> 검색
	@RequestMapping("searchMenu")
	public String goSearch(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		acommd = new MenuSearchCommand();
		acommd.execute(sqlSession, model);
		
		return "admin/menuDeletNUpdatePage";
	}
	
	//메뉴 수정 페이지 고고
	@RequestMapping("menuUpdate")
	public String goUpdatePage(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		acommd = new GoMenuUpdatePageCommand();
		acommd.execute(sqlSession, model);
		
		return "admin/menuUpdatePage";
	}
	
	//메뉴 수정 함
	@RequestMapping("updateMenu")
	public String updateMenu(MultipartHttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		acommd = new UpdateMenuCommand();
		acommd.execute(sqlSession, model);
		
		return "admin/updateResult";
	}
	
	//메뉴 삭제
	@RequestMapping("deleteMenu")
	public String deleteMenu(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		acommd = new MenuDeleteCommand();
		acommd.execute(sqlSession, model);
		
		return "admin/menudeleteResult";
	}
	
	//게시글 작성 고고
	@RequestMapping("writeBoard")
	public String goWritePage() {
		return "admin/boardAddPage";
	}
	
	//게시글 작성
	@RequestMapping("addBoard")
	public String insertBoard(MultipartHttpServletRequest requeset, Model model) {
		model.addAttribute("request", requeset);
		acommd = new AddBoardCommand();
		acommd.execute(sqlSession, model);
		
		return "admin/addBoardResult";
	}
	//게시글 수정,삭제 페이지 이동
	@RequestMapping("dnuBoard")
	public String goDNU_boardPage(HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		acommd = new AllBoardListCommand();
		acommd.execute(sqlSession, model);
		return "admin/boardDeletNUpdatePage";
	}
	//게시글 수정,삭제 -> 검색
	@RequestMapping("searchBoard")
	public String goSearch_board(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		acommd = new BoardSearchCommand();
		acommd.execute(sqlSession, model);
		
		return "admin/boardDeletNUpdatePage";
	}
	//게시글 수정 페이지 고고
	@RequestMapping("boardUpdate")
	public String goUpdateBaordPage(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		acommd = new BoardUpdatePageCommand();
		acommd.execute(sqlSession, model);
		
		return "admin/boardUpdatePage";
	}
	//게시글 수정 함
	@RequestMapping("updateBoard")
	public String updateBoard(MultipartHttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		acommd = new UpdateBoardCommand();
		acommd.execute(sqlSession, model);
		
		return "admin/updateBoardResult";
	}
	
	//게시글 삭제
	@RequestMapping("deleteBoard")
	public String deleteBoard(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		acommd = new BoardDeleteCommand();
		acommd.execute(sqlSession, model);
		
		return "admin/deleteboardResult";
	}
}
