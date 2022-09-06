package com.gguldanji.common.error;

import com.gguldanji.common.error.exception.NotFoundException;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({NoHandlerFoundException.class})
  public String handleNoHandlerFoundException() {
    return "error/404";
  }

  @ResponseBody
  @ExceptionHandler({NotFoundException.class})
  public ResponseEntity<Map<String, String>> handleNotFoundException(NotFoundException exception) {
    return new ResponseEntity<>(Map.of("message", exception.getMessage()), HttpStatus.NOT_FOUND);
  }
}
