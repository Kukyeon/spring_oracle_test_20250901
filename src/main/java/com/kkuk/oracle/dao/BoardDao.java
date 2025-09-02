package com.kkuk.oracle.dao;

import java.util.List;

import com.kkuk.oracle.dto.BoardDto;

public interface BoardDao {

	public void boardWriteDao(String btitle, String bcontent, String bwriter); // 게시판 글쓰기
	public List<BoardDto> boardListDao();//게시판 글 목록 보기
	public int AllBoardCountDao();
	public void boardDeleteDao(int bnum);
	public BoardDto boardViewDao(String bnum);
	public int boardModifyDao(String bnum, String btitle, String bcontent);
	public void updateHitDao(String bnum);
	
}
