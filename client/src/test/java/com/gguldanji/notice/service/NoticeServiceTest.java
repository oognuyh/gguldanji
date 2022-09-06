package com.gguldanji.notice.service;

import com.gguldanji.common.configuration.DataSourceConfig;
import com.gguldanji.common.configuration.DatabaseConfig;
import com.gguldanji.common.dto.PageRequest;
import com.gguldanji.notice.dao.NoticeDao;
import com.gguldanji.notice.exception.NoticeNotFoundException;
import java.util.Optional;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ActiveProfiles("test")
@ExtendWith({MockitoExtension.class, SpringExtension.class})
@ContextConfiguration(classes = {DataSourceConfig.class, DatabaseConfig.class})
public class NoticeServiceTest {

  @Autowired SqlSession sqlSession;

  @Mock private NoticeDao noticeDao;

  @InjectMocks private NoticeServiceImpl noticeService;

  @Test
  void shouldThrowNotFoundExceptionWhenFindNotExistingNoticeNo() {
    // given
    int noticeNo = -1;
    BDDMockito.given(noticeDao.findNoticeByNoticeNo(noticeNo)).willReturn(Optional.empty());

    // when
    Executable executable = () -> noticeService.findNoticeByNoticeNo(noticeNo);

    // then
    Assertions.assertThrows(NoticeNotFoundException.class, executable);

    BDDMockito.then(noticeDao).should().findNoticeByNoticeNo(noticeNo);
  }

  @Test
  @Sql("classpath:test-data.sql")
  void shouldReturnValidPageInfoWhenFindNoticeSummariesWithPageSizeAndPageNum() {
    // given
    PageRequest request = PageRequest.builder().build();
    NoticeService noticeService = new NoticeServiceImpl(this.sqlSession.getMapper(NoticeDao.class));

    // when
    var actual = noticeService.findNoticeSummaries(request);

    // then
    Assertions.assertEquals(request.getPageNum(), actual.getPageNum());
    Assertions.assertEquals(request.getPageSize(), actual.getPageSize());
    Assertions.assertEquals(1, actual.getTotal());
  }
}
