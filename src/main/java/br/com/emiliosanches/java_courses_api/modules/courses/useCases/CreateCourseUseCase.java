package br.com.emiliosanches.java_courses_api.modules.courses.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emiliosanches.java_courses_api.modules.courses.entity.CourseEntity;
import br.com.emiliosanches.java_courses_api.modules.courses.repositories.CoursesRepository;

@Service
public class CreateCourseUseCase {
  @Autowired private CoursesRepository coursesRepository;

  public CourseEntity execute(CourseEntity courseEntity) {
    return this.coursesRepository.save(courseEntity);
  }
}
