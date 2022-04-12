package com.meli.movies.exception;

public class NotFoundGenreException extends MainErrorException {
    public NotFoundGenreException(String message) {
        super(message);
    }

    public NotFoundGenreException() {
        super("The genre was not found.");
    }
}
