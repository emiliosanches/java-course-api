package br.com.emiliosanches.java_courses_api;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaCoursesApiApplication {

	public static void main(String[] args) {
		Locale.setDefault(new Locale("en", "US"));
		SpringApplication.run(JavaCoursesApiApplication.class, args);
	}

}
