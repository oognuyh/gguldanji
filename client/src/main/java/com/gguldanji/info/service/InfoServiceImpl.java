package com.gguldanji.info.service;

import org.springframework.stereotype.Service;

import com.gguldanji.info.dao.InfoDao;
import com.gguldanji.info.entity.Info;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InfoServiceImpl implements InfoService {

	private final InfoDao infoDao;

	@Override
	public Info Basic(String kaptCode) {
		// kaptCode 받고, info return 해주기
		return infoDao.Basic(kaptCode, info);
	}

	@Override
	public Info Detail(String kaptCode) {
		return infoDao.Detail(Info);
	}
	
}
