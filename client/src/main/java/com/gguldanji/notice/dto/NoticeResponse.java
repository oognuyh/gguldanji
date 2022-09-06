package com.gguldanji.notice.dto;

import com.gguldanji.notice.entity.Notice;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoticeResponse {

  private int noticeNo;

  private String author;

  private String title;

  private String content;

  private LocalDateTime createdAt;

  private UUID createdBy;

  private LocalDateTime updatedAt;

  private UUID updatedBy;

  @Builder
  public NoticeResponse(
      int noticeNo,
      String author,
      String title,
      String content,
      LocalDateTime createdAt,
      UUID createdBy,
      LocalDateTime updatedAt,
      UUID updatedBy) {
    this.noticeNo = noticeNo;
    this.author = author;
    this.title = title;
    this.content = content;
    this.createdAt = createdAt;
    this.createdBy = createdBy;
    this.updatedAt = updatedAt;
    this.updatedBy = updatedBy;
  }

  public static NoticeResponse from(Notice notice) {
    return NoticeResponse.builder()
        .noticeNo(notice.getNoticeNo())
        .author(notice.getAuthorName())
        .title(notice.getTitle())
        .content(notice.getContent())
        .createdAt(notice.getCreatedAt())
        .updatedAt(notice.getUpdatedAt())
        .build();
  }
}
