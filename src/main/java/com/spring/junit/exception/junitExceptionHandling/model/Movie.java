package com.spring.junit.exception.junitExceptionHandling.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Document(collection = "assignment")
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private double rating;
    private String genre;

    public Movie() {
    }

    public Movie(Long id, String name, double rating, String genre) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
