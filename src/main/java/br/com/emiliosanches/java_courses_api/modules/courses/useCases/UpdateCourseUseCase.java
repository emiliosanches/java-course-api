package br.com.emiliosanches.java_courses_api.modules.courses.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emiliosanches.java_courses_api.modules.courses.dto.UpdateCourseDTO;
import br.com.emiliosanches.java_courses_api.modules.courses.entity.CourseEntity;
import br.com.emiliosanches.java_courses_api.modules.courses.repositories.CoursesRepository;
import br.com.emiliosanches.java_courses_api.utils.Utils;

@Service
public class UpdateCourseUseCase {
  @Autowired private CoursesRepository coursesRepository;
  @Autowired private GetCourseByIdUseCase getCourseByIdUseCase;

  public CourseEntity execute(UUID id, UpdateCourseDTO updateCourseDTO) {
    var course = this.getCourseByIdUseCase.execute(id);

    Utils.mergeObjects(course, updateCourseDTO);

    return this.coursesRepository.save(course);
  }
}
