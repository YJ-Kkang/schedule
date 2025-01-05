package com.example.schedule.domain.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(CourseNotFoundException.class)
  public ResponseEntity<ApiResponse<?>> handleCourseNotFoundException(CourseNotFoundException e) {
    ApiResponse<?> errorResponse = ApiResponse.error(HttpStatus.NOT_FOUND, e.getMessage());
    return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
  }
}
