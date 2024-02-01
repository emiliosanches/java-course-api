package br.com.emiliosanches.java_courses_api.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
  private MessageSource messageSource;

  public ExceptionHandlerController(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  protected ResponseEntity<ValidationErrorResponseDTO> handleValidationException(
      MethodArgumentNotValidException e) {

    List<ValidationErrorItem> errors = new ArrayList<>();

    e.getFieldErrors().forEach(error -> {
      var errorResponse = new ValidationErrorItem(error.getField(),
          this.messageSource.getMessage(error, LocaleContextHolder.getLocale()));
      errors.add(errorResponse);
    });

    return new ResponseEntity<ValidationErrorResponseDTO>(
        new ValidationErrorResponseDTO("Invalid fields received. Check the errors and your data", errors),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  protected ResponseEntity<CommonErrorResponseDTO> handleNoBody(HttpMessageNotReadableException exception) {
    if (exception.getMessage().startsWith("Required request body is missing:"))
      return new ResponseEntity<CommonErrorResponseDTO>(
          new CommonErrorResponseDTO("Missing needed request body."), HttpStatus.BAD_REQUEST);

    throw exception;
  }
}
