package br.com.emiliosanches.java_courses_api.modules.courses.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("courses")
public class CoursesController {
  @GetMapping
  public String helloWorld(@RequestParam(required = false) String name) {
    return "Hello, " + (name != null ? name : "world!");
  }

}
