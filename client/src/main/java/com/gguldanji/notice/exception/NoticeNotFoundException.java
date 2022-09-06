package com.gguldanji.notice.exception;

import com.gguldanji.common.error.exception.NotFoundException;

public class NoticeNotFoundException extends NotFoundException {

  public NoticeNotFoundException(int noticeNo) {
    super("%d번 공지를 찾을 수 없습니다.".formatted(noticeNo));
  }
}
