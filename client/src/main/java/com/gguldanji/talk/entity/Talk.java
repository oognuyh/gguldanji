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
	@EqualsAndHashCode.Include private int talkNo;

	private String kaptCode;
	
	private String userId;
	
	private int parent;
	
	private int child;
  
	private String comment;
  
	private LocalDateTime createdAt;

}
