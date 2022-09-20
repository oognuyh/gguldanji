package com.gguldanji.talk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.gguldanji.talk.entity.Talk;

@Mapper
public interface TalkDao {
	
	@Select("SELECT * FROM comments WHERE apt_code= #{kaptCode}")
	List<Talk> getList(@Param("kaptCode") String kaptCode);
	
	@Insert("INSERT INTO comments(user_id, parent, child, comment, createdAt)"
			+ " values(#{userId}, #{parent}, #{child}, #{comment}, sysdate)")
	int addComment (Talk talk);
	
	@Delete("DELETE FROM comments "
			+ " WHERE user_id= #{userId} AND (parent= #{parent} OR child= #{child}) ")
	int deleteComment (Talk talk);
	
	
	

}
