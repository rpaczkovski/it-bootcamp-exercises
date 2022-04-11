package com.meli.turorials.infrastructure.exception;

import com.meli.turorials.application.usecase.tutorial.comman.exception.NotFoundTutorialException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MainControllerExceptionHandler {
    @ExceptionHandler(NotFoundTutorialException.class)
    protected ResponseEntity<?> notFoundTestCaseException(NotFoundTutorialException err) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err.getMessage());
    }
}
