package br.com.emiliosanches.java_courses_api.modules.courses.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emiliosanches.java_courses_api.modules.courses.entity.CourseEntity;
import br.com.emiliosanches.java_courses_api.modules.courses.repositories.CoursesRepository;

@Service
public class ListCoursesUseCase {
  @Autowired private CoursesRepository coursesRepository;

  public List<CourseEntity> execute() {
    return this.coursesRepository.findAll();
  }
}
