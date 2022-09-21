package com.gguldanji.info.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.ibatis.type.Alias;

import com.gguldanji.notice.entity.Notice;

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
	
	private String kaptName; // 단지명
	
	private String kaptAddr; // 법정동주소
	
	private String codeSaleNm; // 분양
	
	private int kaptdaCnt; // 세대수
	
	private int kaptDongCnt; // 동수
	
	
	
}
