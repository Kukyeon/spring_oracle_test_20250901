package com.kkuk.oracle.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
	
	private int rnum; // rownum 값 필드
	
	private int bnum;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private int bhit;
	private Timestamp bdate;
	
	//BoardDto : MemberDto -> 1:1관계
	private MemberDto memberDto;
}
