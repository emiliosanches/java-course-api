package br.com.emiliosanches.java_courses_api.modules.courses.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emiliosanches.java_courses_api.modules.courses.repositories.CoursesRepository;

@Service
public class DeleteCourseUseCase {
  @Autowired
  private CoursesRepository coursesRepository;

  @Autowired
  private GetCourseByIdUseCase getCourseByIdUseCase;

  public void execute(UUID id) {
    var course = this.getCourseByIdUseCase.execute(id);

    this.coursesRepository.delete(course);
  }
}
