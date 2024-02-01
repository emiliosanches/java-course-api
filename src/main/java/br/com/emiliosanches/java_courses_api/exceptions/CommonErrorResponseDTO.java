package br.com.emiliosanches.java_courses_api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommonErrorResponseDTO {
  private String message;
}
