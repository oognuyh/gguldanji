package com.gguldanji.talk.service;

import java.util.List;

import org.apache.ibatis.annotations.Delete;

import com.gguldanji.talk.entity.Talk;

public interface TalkService {
	
	List<Talk> getList(String kaptCode);
	
	Talk addComment (Talk talk);
	
	Talk deleteComment (Talk talk);
	
}
