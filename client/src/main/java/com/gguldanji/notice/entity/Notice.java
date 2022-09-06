package com.gguldanji.notice.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@Builder
@ToString
@Alias("Notice")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Notice {

  @EqualsAndHashCode.Include private int noticeNo;

  private String title;

  private String content;

  private UUID authorId;

  private String authorName;

  private LocalDateTime createdAt;

  private UUID createdBy;

  private LocalDateTime updatedAt;

  private UUID updatedBy;
}
