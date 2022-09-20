package com.gguldanji.talk.dto;

import lombok.Data;

@Data
public class TalkResponse {
	
	// primary key
	private int talkNo;
	
	// kaptCode
	private String kaptCode;
	
	// 작성자
	private String userId;
	
	// 부모 구분
	private int parent;
	
	// 자식 구분
	private int child;
	
	// comment 
	private String comment;
	
	// 생성일자
	private String createdAt;
	
}