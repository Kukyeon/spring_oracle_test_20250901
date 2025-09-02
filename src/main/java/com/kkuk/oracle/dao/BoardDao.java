package com.kkuk.oracle.dao;

import java.util.List;

import com.kkuk.oracle.dto.BoardDto;

public interface BoardDao {

	public void boardWriteDao(String btitle, String bcontent, String bwriter); // 게시판 글쓰기
	public List<BoardDto> boardListDao();//게시판 글 목록 보기 -> 페이징 미적용
	public int AllBoardCountDao();
	public void boardDeleteDao(int bnum);
	public BoardDto boardViewDao(String bnum);
	public int boardModifyDao(String bnum, String btitle, String bcontent);
	public void updateHitDao(String bnum);
	public List<BoardDto> pageBoardListDao(int startRow, int endRow); // 페이징 적용된 게시판 글 목록 보기
	
}
