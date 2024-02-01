package br.com.emiliosanches.java_courses_api.modules.courses.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emiliosanches.java_courses_api.exceptions.CourseNotFoundException;
import br.com.emiliosanches.java_courses_api.modules.courses.entity.CourseEntity;
import br.com.emiliosanches.java_courses_api.modules.courses.repositories.CoursesRepository;

@Service
public class GetCourseByIdUseCase {
  @Autowired CoursesRepository coursesRepository;

  public CourseEntity execute(UUID id) {
    return this.coursesRepository.findById(id).orElseThrow(() -> new CourseNotFoundException());
  }
}
