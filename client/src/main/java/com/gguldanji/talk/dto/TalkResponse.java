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
	
	// comment 
	private String comment;
	
	// 생성일자
	private String createdAt;
	
}