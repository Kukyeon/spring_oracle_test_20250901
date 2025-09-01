package com.kkuk.oracle.dao;

public interface MemberDao {

	public int memberjoinDao(String memberid, String memberpw, String membername);
	public int memberidCheckDao(String memberid); // 아이디 존재 여부 화긴
	public int memberLoginDao(String memberid, String memberpw); // 로그인 화긴
	
}
