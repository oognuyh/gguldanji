package com.gguldanji.info.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gguldanji.info.entity.Info;
import com.gguldanji.info.service.InfoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class InfoController {
	
	private final InfoService infoService;
	
	// 기본 정보 제공
	@GetMapping("/api/infos")
	public Info Basic(@RequestBody Info info) {
		return infoService.Basic(info);
	}
	
	// 상세 정보 제공
	@GetMapping("/api/infos/detail")
	public Info Detail(@RequestBody Info info) {
		return infoService.Detail(info);
	}
	
	
}
