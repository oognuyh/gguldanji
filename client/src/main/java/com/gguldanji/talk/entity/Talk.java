package com.gguldanji.talk.entity;

import java.time.LocalDateTime;

import org.apache.ibatis.type.Alias;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@Alias("Talk")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Talk {
	@EqualsAndHashCode.Include private int talkNo; // 댓글마다 구분 가능한 고유 번호

	private String kaptCode;
	
	private String userId;
  
	private String comment;
  
	private LocalDateTime createdAt;

}
