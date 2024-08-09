package com.example.demo.CustomExceptionClasses;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

 @ExceptionHandler(MethodArgumentNotValidException.class)
 public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
     Map<String, Object> body = new HashMap<>();
     body.put("timestamp", LocalDateTime.now());
     body.put("status", HttpStatus.BAD_REQUEST.value());

     // Get all validation errors
     String errors = ex.getBindingResult()
             .getFieldErrors()
             .stream()
             .map(err -> err.getField() + ": " + err.getDefaultMessage())
             .collect(Collectors.joining(", "));

     body.put("errors", errors);

     return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
 }

 @ExceptionHandler(Exception.class)
 public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
     Map<String, Object> body = new HashMap<>();
     body.put("timestamp", LocalDateTime.now());
     body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
     body.put("error", ex.getMessage());

     return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
 }
}
