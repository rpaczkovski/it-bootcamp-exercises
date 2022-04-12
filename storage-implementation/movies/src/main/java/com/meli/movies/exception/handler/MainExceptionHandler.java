package com.meli.movies.exception.handler;

import com.meli.movies.exception.NotFoundGenreException;
import com.meli.movies.exception.NotFoundMovieException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class MainExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<?> methodNotValidException(MethodArgumentNotValidException err) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(NotFoundMovieException.class)
    protected ResponseEntity<?> notFoundMovieException(NotFoundMovieException err) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err.getMessage());
    }

    @ExceptionHandler(NotFoundGenreException.class)
    protected ResponseEntity<?> notFoundGenreException(NotFoundGenreException err) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<?> entityNotFoundException(EntityNotFoundException err) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err.getMessage());
    }


}