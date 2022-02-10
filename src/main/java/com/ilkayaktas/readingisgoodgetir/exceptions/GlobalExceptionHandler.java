package com.ilkayaktas.readingisgoodgetir.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.AbstractMap;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Component
public class GlobalExceptionHandler {

  private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler
  public ResponseEntity<AbstractMap.SimpleEntry<String, String>> handle(Exception exception) {
    LOG.error("Request could not be processed but exception is handled by ReadingIsGood-Getir: ", exception);
    AbstractMap.SimpleEntry<String, String> response =
        new AbstractMap.SimpleEntry<>("message", "Request could not be processed!");
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }

  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public ResponseEntity<List<String>> handleException(
          HttpServletRequest request, MethodArgumentNotValidException e) {

    List<String> collect = e.getBindingResult()
            .getAllErrors().stream()
            .map(ObjectError::getDefaultMessage)
            .collect(Collectors.toList());

    return ResponseEntity.badRequest().body(collect);
  }

  @ExceptionHandler(value = StockException.class)
  public ResponseEntity<AbstractMap.SimpleEntry<String, String>> handleStockException(
          HttpServletRequest request, StockException e) {

    AbstractMap.SimpleEntry<String, String> response =
            new AbstractMap.SimpleEntry<>("message", "Book stock is not available!");
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }
}
