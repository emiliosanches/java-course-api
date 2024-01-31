package br.com.emiliosanches.java_courses_api.modules.courses.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class CourseEntity {
  private UUID id;
  private String name;
  private String category;
  private boolean is_active;
  private LocalDateTime created_at;
  private LocalDateTime updated_at;
}
