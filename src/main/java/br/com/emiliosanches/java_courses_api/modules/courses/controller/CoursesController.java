package br.com.emiliosanches.java_courses_api.modules.courses.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("courses")
public class CoursesController {
  @GetMapping
  public String listCourses() {
    return "This method lists courses";
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
