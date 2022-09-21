package com.gguldanji.info.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gguldanji.info.entity.Info;

@Mapper
public class InfoDao {

	@Select("SELECT * FROM 기본정보 WHERE kapt_code= #{kaptCode} ")
	public Info Basic(String kaptCode) {
		return info;
	};

	@Select("SELECT * FROM 상세정보 WHERE kapt_code= #{kaptCode} ")
	// body를 만들라는 오류
	Info Detail(String kaptCode);
	
}
