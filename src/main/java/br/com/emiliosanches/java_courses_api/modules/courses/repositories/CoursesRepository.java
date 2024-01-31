package br.com.emiliosanches.java_courses_api.modules.courses.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.emiliosanches.java_courses_api.modules.courses.entity.CourseEntity;

public interface CoursesRepository extends JpaRepository<CourseEntity, UUID> {}