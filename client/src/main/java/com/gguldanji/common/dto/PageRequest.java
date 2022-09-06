package com.gguldanji.common.dto;

import lombok.Data;

@Data
public class PageRequest {

  private int pageSize = 20;

  private int pageNum = 1;

  private String q;
}
