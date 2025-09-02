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
		
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		List<BoardDto> boardDtos = boardDao.boardListDao(); // 모든 글 가져오기(조인테이블)
		model.addAttribute("boardList", boardDtos);
		
		model.addAttribute("boardCount", boardDao.AllBoardCountDao()); // 모든 글 갯수 전달
		
		return "boardlist";
	}
	
	@RequestMapping(value = "/boarddelete")
	public String boarddelete(HttpServletRequest request, Model model, HttpSession session) {
		
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		boardDao.boardDeleteDao(bnum);
		
		
		return "redirect:blist";
	}
	
	@RequestMapping(value = "/boardview")
	public String boardview(HttpServletRequest request, Model model, HttpSession session) {
		
		String bnum = request.getParameter("bnum");
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		boardDao.updateHitDao(bnum);
		BoardDto boardDto = boardDao.boardViewDao(bnum);
		model.addAttribute("boardDao", boardDto);
		
		return "boardview";
	}
	
	@RequestMapping(value = "/boardmodify")
	public String boardmodify(HttpServletRequest request, Model model, HttpSession session) {
		
		String bnum = request.getParameter("bnum");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		int result = boardDao.boardModifyDao(bnum, btitle, bcontent);
		
		if(result == 1) {
			model.addAttribute("msg", "글 수정 완료.");
			model.addAttribute("url", "blist");
			
		}else {
			model.addAttribute("msg", "글 수정 실패.");
			model.addAttribute("url", "blist");
			
		}	return "alert/alert";
	}	
	
	@RequestMapping(value = "pageList")
	public String pageList(HttpServletRequest request, Model model, HttpSession session) {
		
		int pageSize = 10; // 게시판 페이지당 보여줄 글 수
		int pageNum = 1; // 유저가 클릭한 페이지의 번호 -> 초기값 1
		int blockSize = 5; // 페이지 블록에 표시 될 페이지 수; 
		
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum")); // 유저가 선택한 페에지의 번호
		}
		
		int startRow = (pageNum * pageSize) - 9; // 페이징 시 시작 행의 번호 ( 1 -> 1, 2 -> 11 , 3 -> 21 ... )
		// ((pageNum - 1) * pageSize) + 1
		int endRow = pageNum * pageSize; // 1- 10, 2 - 20, 3 - 30 ...
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		List<BoardDto> boardDtos = boardDao.pageBoardListDao(startRow, endRow); //페이징 적용된 모든 글 가져오기(조인테이블)
		int totalCount = boardDao.AllBoardCountDao();
		
		int startPage = (((pageNum-1) / blockSize)*blockSize)+1;
		int endPage = startPage + (blockSize - 1);
		int totalPage = (int)Math.ceil((double)totalCount / pageSize) ;// 전체 글 개수로 만든 총 페이지 수
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		model.addAttribute("boardList", boardDtos);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("boardCount", totalCount); // 모든 글 갯수 전달
		return "pageList";
	}
}
