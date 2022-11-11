package com.spring.junit.exception.junitExceptionHandling.service;

import com.spring.junit.exception.junitExceptionHandling.model.Movie;

import java.util.List;

public interface MovieService {

    public List<Movie> getAllMovies();
    public Movie getMovieById(Long id);
    public Movie saveMovie(Movie movie);
    public void removeMovieById(Long id);
    public Movie updateMovie(Movie movie);
}
