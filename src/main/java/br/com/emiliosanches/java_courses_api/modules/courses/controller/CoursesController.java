package br.com.emiliosanches.java_courses_api.modules.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.emiliosanches.java_courses_api.modules.courses.entity.CourseEntity;
import br.com.emiliosanches.java_courses_api.modules.courses.useCases.ListCoursesUseCase;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("courses")
public class CoursesController {
  @Autowired private ListCoursesUseCase listCoursesUseCase;

  @GetMapping
  public List<CourseEntity> listCourses() {
    return this.listCoursesUseCase.execute();
  }

  @GetMapping("{id}")
  public String getCourseById(@PathVariable String id) throws Exception {
    return "This method shows the course " + id;
  }

  @PostMapping
  public String createCourse() {
    return "This method creates a course";
  }

  @PutMapping("{id}")
  public String updateCourse(@PathVariable String id) {
    return "This method updates the course " + id;
  }

  @DeleteMapping("{id}")
  public String deleteCourse(@PathVariable String id) {
    return "This method deletes the course " + id;
  }
}
