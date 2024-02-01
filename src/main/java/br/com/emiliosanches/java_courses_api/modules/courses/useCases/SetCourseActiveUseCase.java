package br.com.emiliosanches.java_courses_api.modules.courses.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emiliosanches.java_courses_api.modules.courses.entity.CourseEntity;
import br.com.emiliosanches.java_courses_api.modules.courses.repositories.CoursesRepository;

@Service
public class SetCourseActiveUseCase {
  @Autowired private CoursesRepository coursesRepository;
  @Autowired private GetCourseByIdUseCase getCourseByIdUseCase;

  public CourseEntity execute(UUID id, boolean active) {
    var course = this.getCourseByIdUseCase.execute(id);

    course.setActive(active);

    this.coursesRepository.save(course);

    return course;
  }
}
