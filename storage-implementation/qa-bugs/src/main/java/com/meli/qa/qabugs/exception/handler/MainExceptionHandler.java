package com.meli.qa.qabugs.exception.handler;

import com.meli.qa.qabugs.exception.InvalidDateFormatTestCaseException;
import com.meli.qa.qabugs.exception.NotFoundTestCaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MainExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<?> methodNotValidException(MethodArgumentNotValidException err) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(NotFoundTestCaseException.class)
    protected ResponseEntity<?> notFoundTestCaseException(NotFoundTestCaseException err) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err.getMessage());
    }

    @ExceptionHandler(InvalidDateFormatTestCaseException.class)
    protected ResponseEntity<?> invalidDateFormatTestCaseException(InvalidDateFormatTestCaseException err) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
    }
}
