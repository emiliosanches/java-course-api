package br.com.emiliosanches.java_courses_api.modules.courses.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SetCourseActiveDTO {
  @NotNull
  private Boolean active;
}
