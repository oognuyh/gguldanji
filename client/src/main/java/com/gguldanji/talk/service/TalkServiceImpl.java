package com.gguldanji.talk.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.gguldanji.talk.dao.TalkDao;
import com.gguldanji.talk.entity.Talk;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TalkServiceImpl implements TalkService{@Override
	
	private final TalkDao talkDao;
	
	public List<Talk> getList(String kaptCode) {
		return talkDao.getList(kaptCode);
	}

	@Override
	public Talk addComment(Talk talk) {
		return talkDao.addComment(talk);
		
	}

	@Override
	public Talk deleteComment(Talk talk) {
		return talkDao.deleteComment(talk);
		
	}

}
