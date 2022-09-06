package com.gguldanji.common.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({NoHandlerFoundException.class})
  public String handleNoHandlerFoundException() {
    return "error/404";
  }
}
