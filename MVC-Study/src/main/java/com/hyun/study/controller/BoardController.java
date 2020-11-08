package com.hyun.study.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyun.study.dto.BoardDto;
import com.hyun.study.dto.MemberDto;
import com.hyun.study.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService bdservice;
	
	@RequestMapping("boardlist")
	public String boardlist(Model model) {
		
		List<BoardDto> bdDto = bdservice.boardlist();
		model.addAttribute("bdDto", bdDto);
		
		return "board/main";
	}
	
	@RequestMapping("show")
	public String boardshow(@RequestParam int idk, Model model) {
		
		model.addAttribute("bd", bdservice.boardshow(idk));
		
		return "board/show";
	}
	
	@RequestMapping("remove")
	public String boardremove(@RequestParam int idk, Model model) {
		
		model.addAttribute("result", bdservice.boardremove(idk));
		
		
		
		return  "board/show";
	}
	
	@RequestMapping("add")
	public String writePage() {
		return "board/write";
	}
	
	@RequestMapping("boardadd")
	public String addboard(BoardDto bdDto) {
		
		bdservice.boardAdd(bdDto);
		
		return "redirect:boardlist";
	}
	
	@RequestMapping("listJoin")
		public String boardjoin(Model model) {
			List<MemberDto> memdto = bdservice.boardJoinlist();
			System.out.println(memdto.size());
			model.addAttribute("memdto",memdto );
			return "board/joinlist";
	}
}
