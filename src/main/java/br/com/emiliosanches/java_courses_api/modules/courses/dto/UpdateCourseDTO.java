package br.com.emiliosanches.java_courses_api.modules.courses.dto;

import lombok.Data;

@Data
public class UpdateCourseDTO {
  private String name;
  private String category;
}
