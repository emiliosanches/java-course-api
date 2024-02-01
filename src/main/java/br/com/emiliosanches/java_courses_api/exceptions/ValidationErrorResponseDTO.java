package br.com.emiliosanches.java_courses_api.exceptions;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ValidationErrorResponseDTO extends CommonErrorResponseDTO {
  public ValidationErrorResponseDTO(String message, List<ValidationErrorItem> errors) {
    super(message);
    this.errors = errors;
  }

  private List<ValidationErrorItem> errors;
}
