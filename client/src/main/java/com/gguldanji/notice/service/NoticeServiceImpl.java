package com.gguldanji.notice.service;

import com.gguldanji.common.dto.PageRequest;
import com.gguldanji.notice.dao.NoticeDao;
import com.gguldanji.notice.dto.NoticeResponse;
import com.gguldanji.notice.dto.NoticeSummaryResponse;
import com.gguldanji.notice.exception.NoticeNotFoundException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

  private final NoticeDao noticeDao;

  @Override
  public PageInfo<NoticeSummaryResponse> findNoticeSummaries(PageRequest request) {
    return PageHelper.startPage(request.getPageNum(), request.getPageSize())
        .doSelectPageInfo(
            () -> {
              noticeDao.findNoticeSummaries().stream().map(NoticeResponse::from);
            });
  }

  @Override
  public NoticeResponse findNoticeByNoticeNo(int noticeNo) {
    return noticeDao
        .findNoticeByNoticeNo(noticeNo)
        .map(NoticeResponse::from)
        .orElseThrow(() -> new NoticeNotFoundException(noticeNo));
  }
}
