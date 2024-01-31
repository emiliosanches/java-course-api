package br.com.emiliosanches.java_courses_api.modules.courses.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "courses")
public class CourseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Length(min = 5)
  private String name;
  
  private String category;
  
  private boolean is_active;
  
  @CreationTimestamp
  private LocalDateTime created_at;
  
  @UpdateTimestamp
  private LocalDateTime updated_at;
}
