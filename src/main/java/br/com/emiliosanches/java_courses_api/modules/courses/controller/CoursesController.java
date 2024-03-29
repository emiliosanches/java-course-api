package br.com.emiliosanches.java_courses_api.modules.courses.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.emiliosanches.java_courses_api.modules.courses.dto.SetCourseActiveDTO;
import br.com.emiliosanches.java_courses_api.modules.courses.dto.UpdateCourseDTO;
import br.com.emiliosanches.java_courses_api.modules.courses.entity.CourseEntity;
import br.com.emiliosanches.java_courses_api.modules.courses.useCases.CreateCourseUseCase;
import br.com.emiliosanches.java_courses_api.modules.courses.useCases.DeleteCourseUseCase;
import br.com.emiliosanches.java_courses_api.modules.courses.useCases.GetCourseByIdUseCase;
import br.com.emiliosanches.java_courses_api.modules.courses.useCases.ListCoursesUseCase;
import br.com.emiliosanches.java_courses_api.modules.courses.useCases.SetCourseActiveUseCase;
import br.com.emiliosanches.java_courses_api.modules.courses.useCases.UpdateCourseUseCase;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("courses")
public class CoursesController {
  @Autowired
  private ListCoursesUseCase listCoursesUseCase;
  @Autowired
  private GetCourseByIdUseCase getCourseByIdUseCase;
  @Autowired
  private CreateCourseUseCase createCourseUseCase;
  @Autowired
  private UpdateCourseUseCase updateCourseUseCase;
  @Autowired
  private SetCourseActiveUseCase setCourseActiveUseCase;
  @Autowired
  private DeleteCourseUseCase deleteCourseUseCase;

  @GetMapping
  public List<CourseEntity> listCourses() {
    return this.listCoursesUseCase.execute();
  }

  @GetMapping("{id}")
  public CourseEntity getCourseById(@PathVariable UUID id) {
    return this.getCourseByIdUseCase.execute(id);
  }

  @PostMapping
  public CourseEntity createCourse(@Validated @RequestBody CourseEntity courseEntity) {
    return this.createCourseUseCase.execute(courseEntity);
  }

  @PutMapping("{id}")
  public CourseEntity updateCourse(@PathVariable UUID id, @RequestBody UpdateCourseDTO updateCourseDTO) {
    return this.updateCourseUseCase.execute(id, updateCourseDTO);
  }

  @PatchMapping("{id}/active")
  public CourseEntity setCourseActive(@PathVariable UUID id,
      @Validated @RequestBody SetCourseActiveDTO setCourseActiveDTO) {
    return this.setCourseActiveUseCase.execute(id, setCourseActiveDTO.getActive());
  }

  @DeleteMapping("{id}")
  public void deleteCourse(@PathVariable UUID id) {
    this.deleteCourseUseCase.execute(id);
  }
}
