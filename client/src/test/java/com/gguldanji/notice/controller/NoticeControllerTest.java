package com.gguldanji.notice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gguldanji.common.configuration.WebInitializer;
import com.gguldanji.common.error.GlobalExceptionHandler;
import com.gguldanji.notice.dto.NoticeResponse;
import com.gguldanji.notice.exception.NoticeNotFoundException;
import com.gguldanji.notice.service.NoticeService;
import com.gguldanji.notice.service.NoticeServiceImpl;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.filter.CharacterEncodingFilter;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {WebInitializer.class})
public class NoticeControllerTest {

  private MockMvc mockMvc;

  private NoticeService noticeService;

  private ObjectMapper objectMapper = new ObjectMapper();

  @BeforeEach
  void setup() {
    this.noticeService = Mockito.mock(NoticeServiceImpl.class);
    this.mockMvc =
        MockMvcBuilders.standaloneSetup(new NoticeController(noticeService))
            .alwaysDo(MockMvcResultHandlers.print())
            .addFilters(new CharacterEncodingFilter("utf-8", true))
            .setControllerAdvice(GlobalExceptionHandler.class)
            .build();
  }

  @Test
  void shouldBeOkWhenGetNotices() throws Exception {
    // given
    int pageSize = 20;
    int pageNum = 1;

    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

    params.add("pageSize", "%d".formatted(pageSize));
    params.add("pageNum", "%d".formatted(pageNum));

    // when
    var actual =
        mockMvc.perform(MockMvcRequestBuilders.get("/api/notices").params(params)).andReturn();

    // then
    Assertions.assertEquals(HttpServletResponse.SC_OK, actual.getResponse().getStatus());
  }

  @Test
  void shouldBeOkWhenGetNoticeByNoticeNo() throws Exception {
    // given
    int noticeNo = 100001;
    BDDMockito.given(noticeService.findNoticeByNoticeNo(noticeNo))
        .willReturn(NoticeResponse.builder().noticeNo(noticeNo).build());

    // when
    var actual =
        mockMvc
            .perform(MockMvcRequestBuilders.get("/api/notices/%d".formatted(noticeNo)))
            .andReturn();

    // then
    NoticeResponse notice =
        toObject(actual.getResponse().getContentAsString(), NoticeResponse.class);

    Assertions.assertEquals(HttpServletResponse.SC_OK, actual.getResponse().getStatus());
    Assertions.assertEquals(noticeNo, notice.getNoticeNo());
  }

  @Test
  void shouldBeNotFoundWhenGetNoticeByNotExistingNoticeNo() throws Exception {

    // given
    int noticeNo = -1;
    BDDMockito.given(noticeService.findNoticeByNoticeNo(noticeNo))
        .willThrow(new NoticeNotFoundException(noticeNo));

    // when
    var actual =
        mockMvc
            .perform(MockMvcRequestBuilders.get("/api/notices/%d".formatted(noticeNo)))
            .andReturn();

    // then
    Assertions.assertEquals(HttpServletResponse.SC_NOT_FOUND, actual.getResponse().getStatus());
  }

  private <T> T toObject(String jsonString, Class<T> clazz) throws Exception {
    return objectMapper.readValue(jsonString, clazz);
  }
}
