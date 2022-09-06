package com.gguldanji.notice.service;

import com.gguldanji.common.dto.PageRequest;
import com.gguldanji.notice.dto.NoticeResponse;
import com.gguldanji.notice.dto.NoticeSummaryResponse;
import com.github.pagehelper.PageInfo;

public interface NoticeService {

  PageInfo<NoticeSummaryResponse> findNoticeSummaries(PageRequest request);

  NoticeResponse findNoticeByNoticeNo(int noticeNo);
}
