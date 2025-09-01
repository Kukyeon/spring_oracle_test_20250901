package com.kkuk.oracle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kkuk.oracle.dao.BoardDao;
import com.kkuk.oracle.dto.BoardDto;

@Controller
public class BoardController {

	
	@Autowired
	private SqlSession sqlSession;
	
	
	
	@RequestMapping(value = "/bwrite")
	public String bwrite(HttpServletRequest request, Model model, HttpSession session) {
		String sid = (String)session.getAttribute("sessionId");
		if(sid==null) {
			model.addAttribute("msg", "로그인한 회원만 글쓰기가 가능합니다.");
			model.addAttribute("url", "login");
			return "alert/alert";
		}
		return "write_form";
	}
	
	@RequestMapping(value = "/bwriteOk")
	public String bwriteOk(HttpServletRequest request, Model model, HttpSession session) {
		
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bwriter = request.getParameter("bwriter");
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		boardDao.boardWriteDao(btitle, bcontent, bwriter);
		
		return "redirect:blist";
	}
	
	@RequestMapping(value = "/blist")
	public String blist(HttpServletRequest request, Model model, HttpSession session) {
		
		System.out.println("blist->boardlist");
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		List<BoardDto> boardDtos = boardDao.boardListDao(); // 모든 글 가져오기(조인테이블)
		model.addAttribute("boardList", boardDtos);
		
		return "boardlist";
	}
}
