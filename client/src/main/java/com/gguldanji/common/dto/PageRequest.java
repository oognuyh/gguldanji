package com.gguldanji.common.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PageRequest {

  private int pageSize = 20;

  private int pageNum = 1;

  private String q;

  @Builder
  public PageRequest(int pageNum, int pageSize, String q) {
    this.pageNum = pageNum > 0 ? pageNum : 1;
    this.pageSize = pageSize > 0 ? pageSize : 20;
    this.q = q;
  }
}
