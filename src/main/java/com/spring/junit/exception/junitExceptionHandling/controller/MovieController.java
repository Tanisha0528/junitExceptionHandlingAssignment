package com.spring.junit.exception.junitExceptionHandling.controller;

import com.spring.junit.exception.junitExceptionHandling.exceptionHandling.MovieException;
import com.spring.junit.exception.junitExceptionHandling.model.Movie;
import com.spring.junit.exception.junitExceptionHandling.model.PayloadValidation;
import com.spring.junit.exception.junitExceptionHandling.model.Response;
import com.spring.junit.exception.junitExceptionHandling.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService service;

    @RequestMapping(value = "/getAllMovies",method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> getAllMovies()
    {
        return new ResponseEntity<>(service.getAllMovies(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getMovieById/{id}",method = RequestMethod.GET)

    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long id) throws MovieException
    {
        Movie emp=service.getMovieById(id);
        if(emp==null|| emp.getId()<=0)
            throw new MovieException("movie doesn't exist");

        return new ResponseEntity<>(service.getMovieById(id),HttpStatus.OK);

    }

    @PostMapping("/saveMovie")
    public ResponseEntity<Movie> saveEmployee(@RequestBody Movie payload) throws MovieException
    {

        if(!PayloadValidation.createdPayloadValidation(payload)) {
            throw new MovieException("PAYLOAD MALFORMED. ID MUST NOT BE DEFINED");
        }

        return new ResponseEntity<Movie>(service.saveMovie(payload), HttpStatus.OK);

    }
    @RequestMapping(value = "/updateMovie",method = RequestMethod.POST)

    public ResponseEntity<Movie> updateMovie(@RequestBody Movie payload)
    {

        return new ResponseEntity<Movie>(service.updateMovie(payload), HttpStatus.OK);

    }

    @RequestMapping(value = "/removeMovieById/{id}",method = RequestMethod.DELETE)

    public ResponseEntity<Response> removeMovieById(@PathVariable("id")Long id) throws MovieException
    {
        Movie emp=service.getMovieById(id);
        if(emp==null|| emp.getId()<=0)
            throw new MovieException("movie doesn't exist");
         service.removeMovieById(id);
          return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "movie deleted sucessfully"),HttpStatus.OK);
    }

}
