package com.gguldanji.info.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gguldanji.info.entity.Info;

import lombok.RequiredArgsConstructor;

@Mapper
@RequiredArgsConstructor
public class InfoDao {

	private final Info info;
	
	@Select("SELECT * FROM 기본정보 WHERE kapt_code= #{kaptCode} ")
	public Info Basic(String kaptCode) {
		return info.getBasicAllInfo();
	};

	@Select("SELECT * FROM 상세정보 WHERE kapt_code= #{kaptCode} ")
	public Info Detail(String kaptCode) {
		return info.getDetailAllInfo();
	};

}
