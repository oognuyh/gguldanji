package com.gguldanji.notice.dao;

import com.gguldanji.notice.entity.Notice;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface NoticeDao {

  @Select("SELECT notice_no, title, author_id, created_at, created_by FROM notices")
  List<Notice> findNoticeSummaries();

  @Select("SELECT * FROM notices WHERE notice_no = #{noticeNo}")
  Optional<Notice> findNoticeByNoticeNo(@Param("noticeNo") int noticeNo);
}
