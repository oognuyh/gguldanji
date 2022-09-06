package com.gguldanji.notice.dto;

import com.gguldanji.notice.entity.Notice;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoticeSummaryResponse {

  private int noticeNo;

  private String author;

  private String title;

  private LocalDateTime createdAt;

  @Builder
  public NoticeSummaryResponse(int noticeNo, String author, String title, LocalDateTime createdAt) {
    this.noticeNo = noticeNo;
    this.author = author;
    this.title = title;
    this.createdAt = createdAt;
  }

  public static NoticeSummaryResponse from(Notice notice) {
    return NoticeSummaryResponse.builder()
        .noticeNo(notice.getNoticeNo())
        .author(notice.getAuthorName())
        .title(notice.getTitle())
        .createdAt(notice.getCreatedAt())
        .build();
  }
}
