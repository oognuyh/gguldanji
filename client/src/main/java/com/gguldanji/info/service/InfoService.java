package com.gguldanji.info.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.gguldanji.info.entity.Info;

public interface InfoService {
	
	public Info Basic(Info info);
	
	public Info Detail(Info info);
	
	
	
}
