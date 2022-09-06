package com.gguldanji.notice.controller;

import com.gguldanji.common.dto.PageRequest;
import com.gguldanji.notice.dto.NoticeResponse;
import com.gguldanji.notice.dto.NoticeSummaryResponse;
import com.gguldanji.notice.service.NoticeService;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NoticeController {

  private final NoticeService noticeService;

  @GetMapping("/api/notices")
  public PageInfo<NoticeSummaryResponse> getNoticeSummaries(PageRequest request) {
    return noticeService.findNoticeSummaries(request);
  }

  @GetMapping("/api/notices/{noticeNo}")
  public NoticeResponse getNoticeByNo(@PathVariable int noticeNo) {
    return noticeService.findNoticeByNoticeNo(noticeNo);
  }
}
