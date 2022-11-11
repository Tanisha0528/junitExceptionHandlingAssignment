package com.spring.junit.exception.junitExceptionHandling.exceptionHandling;

public class MovieException extends Exception{

    private static final long serialVersionUid=1L;
    private String errorMessage;



    public MovieException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
    public MovieException() {}

    public String getErrorMessage()
    {
        return  this.errorMessage;
    }
}
