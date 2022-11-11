package com.spring.junit.exception.junitExceptionHandling;

import com.spring.junit.exception.junitExceptionHandling.model.Movie;
import com.spring.junit.exception.junitExceptionHandling.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JunitExceptionHandlingAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(JunitExceptionHandlingAssignmentApplication.class, args);
	}

	@Bean
	public CommandLineRunner setup(MovieRepository repository) {
		return (args) -> {
			repository.save(new Movie((long) 1, "Maverick", 9, "Thriller"));
			repository.save(new Movie((long) 2, "Annabell", 8.5, "Horror"));
		};
	}

}
