package br.com.emiliosanches.java_courses_api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationErrorItem {
  private String message;
  private String field;
}
