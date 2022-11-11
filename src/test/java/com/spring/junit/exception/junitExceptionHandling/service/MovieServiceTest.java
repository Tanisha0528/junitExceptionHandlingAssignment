package com.spring.junit.exception.junitExceptionHandling.service;
import com.spring.junit.exception.junitExceptionHandling.model.Movie;
import com.spring.junit.exception.junitExceptionHandling.repository.MovieRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
public class MovieServiceTest {

    //dummy data
    @Mock
    private MovieRepository repository;

    //dummy service
    @InjectMocks
    private MovieServiceImpl service;

    //before each test case ,mocked data is made ready
    @Before
    public void setup()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllMovies()
    {
        List<Movie> movielList=new ArrayList<>();
        movielList.add(new Movie((long) 1, "Maverick", 9, "Thriller"));
        movielList.add(new Movie((long) 2, "Annabell", 8.5, "Horror"));

        when(repository.findAll()).thenReturn(movielList);

        List<Movie> emplResult=service.getAllMovies();
        assertEquals(2,emplResult.size());
    }

    @Test
    public void  getMovieById() {
        Movie movie = new Movie((long) 1, "Annabell", 8.5, "Horror");
        when(repository.findById(1L)).thenReturn(Optional.of(movie));

        Movie movieResult = service.getMovieById(1L);

        assertEquals(1, movieResult.getId());
        assertEquals("Annabell", movieResult.getName());
        assertEquals(8.5, movieResult.getRating());
        assertEquals("Horror", movieResult.getGenre());
    }
    @Test
    public void  saveMovie() {
        Movie movie = new Movie((long) 1, "Annabell", 8.5, "Horror");
        when(repository.save(movie)).thenReturn(movie);

        Movie movieResult = service.saveMovie(movie);

        assertEquals(1, movieResult.getId());
        assertEquals("Annabell", movieResult.getName());
        assertEquals(8.5, movieResult.getRating());
        assertEquals("Horror", movieResult.getGenre());
    }
    @Test
    public void  updateMovie() {
        Movie movie = new Movie((long) 1, "Annabell", 8.5, "Horror");
        when(repository.save(movie)).thenReturn(movie);

        service.removeMovieById(1L);
        verify(repository,times(1)).deleteById(movie.getId());

        Movie movie1 = new Movie((long) 1, "Annabell", 9, "Horror");
        when(repository.save(movie1)).thenReturn(movie1);
        Movie movieResult = service.saveMovie(movie1);

        assertEquals(1, movieResult.getId());
        assertEquals("Annabell", movieResult.getName());
        assertEquals(9, movieResult.getRating());
        assertEquals("Horror", movieResult.getGenre());
    }
    @Test
    public void  removeEmployeeById() {
        Movie movie =  new Movie((long) 1, "Annabell", 8.5, "Horror");
       service.removeMovieById(1L);
       verify(repository,times(1)).deleteById(movie.getId());


    }





}
