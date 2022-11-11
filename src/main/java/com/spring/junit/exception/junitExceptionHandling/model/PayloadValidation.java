package com.spring.junit.exception.junitExceptionHandling.model;
public class PayloadValidation {

    public static boolean createdPayloadValidation(Movie movie)
    {
        if(movie.getId() == null) {
            return true;
        }
        return false;
    }
}