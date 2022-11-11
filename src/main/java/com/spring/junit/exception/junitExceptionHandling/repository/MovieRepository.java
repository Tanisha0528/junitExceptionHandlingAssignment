package com.spring.junit.exception.junitExceptionHandling.repository;

import com.spring.junit.exception.junitExceptionHandling.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("MovieRepository")
public interface MovieRepository extends MongoRepository<Movie,Long> {
}
