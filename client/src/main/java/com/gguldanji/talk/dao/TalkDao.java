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
	
	@Insert("INSERT INTO comments(talk_no, user_id, parent, child, comment, createdAt)"
			+ " values(#{talkNo}, #{userId}, #{parent}, #{child}, #{comment}, sysdate)")
	Talk addComment (Talk talk);
	
	@Delete("DELETE FROM comments "
			+ " WHERE talk_no= #{talkNo}) ")
	Talk deleteComment (int talkNo);
	
	
	

}
