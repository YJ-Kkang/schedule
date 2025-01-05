package com.example.schedule.domain.common.exception;

import com.example.schedule.domain.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  // CourseNotFoundException 발생했을 때 응답 본문 설정한 대로 내보내라는 뜻 (/error 뜨지 않음)
  // 가운데에 또 다른 객체(인터페이스 등)를 두면 강결합이 약결합이 됨 (자동차 <- 엔진 -> 가스엔진)
  // 객체 <- ApiResponse -> 객체
  @ExceptionHandler(CourseNotFoundException.class)
  public ResponseEntity<ApiResponse<?>> handleCourseNotFoundException(CourseNotFoundException e) {
    ApiResponse<?> errorResponse = ApiResponse.error(HttpStatus.NOT_FOUND, e.getMessage());
    return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
  }
}
