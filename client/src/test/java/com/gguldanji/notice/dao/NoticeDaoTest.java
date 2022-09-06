package com.gguldanji.notice.dao;

import com.gguldanji.common.configuration.DataSourceConfig;
import com.gguldanji.common.configuration.DatabaseConfig;
import java.sql.SQLException;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@ActiveProfiles("test")
@Sql("classpath:test-data.sql")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DatabaseConfig.class, DataSourceConfig.class})
public class NoticeDaoTest {

  @Autowired private NoticeDao noticeDao;

  @Autowired private SqlSession sqlSession;

  @AfterEach
  void after() throws SQLException {
    sqlSession.getConnection().createStatement().executeUpdate("DELETE FROM notices");
  }

  @Test
  void shouldHaveSpecificFieldsWhenFindNoticeSummaries() {
    // given

    // when
    var actual = noticeDao.findNoticeSummaries();

    // then
    Assertions.assertFalse(actual.isEmpty());
    Assertions.assertEquals(1, actual.size());
    actual.forEach(
        (notice) -> {
          Assertions.assertNotNull(notice.getNoticeNo());
          Assertions.assertNotNull(notice.getTitle());
          Assertions.assertNotNull(notice.getAuthorId());
          Assertions.assertNotNull(notice.getCreatedAt());
          Assertions.assertNotNull(notice.getCreatedBy());
          Assertions.assertNull(notice.getContent());
          Assertions.assertNull(notice.getUpdatedAt());
          Assertions.assertNull(notice.getUpdatedBy());
        });
  }

  @Test
  void shouldHaveAllFieldsWhenFindNoticeByNoticeNo() {
    // given
    int noticeNo = 100001;

    // when
    var actual = noticeDao.findNoticeByNoticeNo(noticeNo);

    // then
    Assertions.assertFalse(actual.isEmpty());
    Assertions.assertTrue(actual.isPresent());
    Assertions.assertNotNull(actual.get().getNoticeNo());
    Assertions.assertNotNull(actual.get().getTitle());
    Assertions.assertNotNull(actual.get().getContent());
    Assertions.assertNotNull(actual.get().getAuthorId());
    Assertions.assertNotNull(actual.get().getCreatedAt());
    Assertions.assertNotNull(actual.get().getCreatedBy());
    Assertions.assertNotNull(actual.get().getUpdatedAt());
    Assertions.assertNotNull(actual.get().getUpdatedBy());
  }
}
