package com.gguldanji.talk.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gguldanji.talk.entity.Talk;
import com.gguldanji.talk.service.TalkService;
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
	@PostMapping("/api/talks")
	public Talk addTalk(@RequestBody Talk talk) {
		return talkService.addComment(talk);
	}
	
	// 댓글 삭제
	@DeleteMapping("/api/talks/{talkNo}")
	public Talk deleteTalk(@PathVariable int talkNo) {
		return talkService.deleteComment(talkNo);
	}
	
}