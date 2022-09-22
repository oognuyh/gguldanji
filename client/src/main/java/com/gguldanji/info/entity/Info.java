package com.gguldanji.info.entity;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@Alias("Info")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Info {
	
	@EqualsAndHashCode.Include private String kaptCode; // 단지코드
	
	private Info basicAllInfo;
	
	private Info detailAllInfo;
	
	
}
