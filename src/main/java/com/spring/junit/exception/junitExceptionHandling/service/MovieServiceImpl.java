package com.spring.junit.exception.junitExceptionHandling.service;

import com.spring.junit.exception.junitExceptionHandling.model.Movie;
import com.spring.junit.exception.junitExceptionHandling.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository repository;


    @Override
    public List<Movie> getAllMovies() {
        return repository.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        Optional<Movie> movie=repository.findById(id);
        if(movie.isPresent())
            return movie.get();
        return null;
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return repository.save(movie);
    }

    @Override
    public void removeMovieById(Long id) {

        repository.deleteById(id);

    }
    @Override
    public Movie updateMovie(Movie movie) {

        Optional<Movie> mov=repository.findById(movie.getId());
        if(mov.isPresent())
        {
            repository.deleteById(movie.getId());

        }
        return repository.save(movie);

    }
}
