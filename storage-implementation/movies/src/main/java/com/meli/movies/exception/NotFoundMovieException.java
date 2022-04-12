package com.meli.movies.exception;

public class NotFoundMovieException extends MainErrorException {

    public NotFoundMovieException(String message) {
        super(message);
    }

    public NotFoundMovieException() {
        super("The movie was not found.");
    }
}
