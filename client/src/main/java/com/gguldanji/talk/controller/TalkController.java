package com.gguldanji.talk.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gguldanji.common.dto.PageRequest;
import com.gguldanji.notice.dto.NoticeSummaryResponse;
import com.gguldanji.talk.entity.Talk;
import com.gguldanji.talk.service.TalkService;
import com.github.pagehelper.PageInfo;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TalkController {
	
	private final TalkService talkService;
	
	// 전체 리스트
	@GetMapping("/api/talks")
	public List<Talk> getList(@RequestParam String kaptCode) {
		return talkService.getList(kaptCode);
	}
	
	// 댓글 달기
	@GetMapping("/api/talks/insert")
	public Talk addTalk(Talk talk) {
		return talkService.addComment(talk);
	}
	
	// 댓글 삭제
	@GetMapping("/api/talks/delete")
	public Talk deleteTalk(Talk talk) {
		return talkService.deleteComment(talk);
	}
	
}