package com.spring.junit.exception.junitExceptionHandling.util;

import com.spring.junit.exception.junitExceptionHandling.model.Movie;
import com.spring.junit.exception.junitExceptionHandling.model.PayloadValidation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PayloadValidatorTest {

    @Test
    public void validatePayload()
    {
        Movie movie =new Movie((long) -1, "Maverick", 9, "Thriller");
        assertEquals(false, PayloadValidation.createdPayloadValidation(movie));


    }  @Test
    public void validateInvalidPayload()
    {
        Movie movie =new Movie((long) 1, "Maverick", 9, "Thriller");
        assertEquals(true, PayloadValidation.createdPayloadValidation(movie));


    }
}
