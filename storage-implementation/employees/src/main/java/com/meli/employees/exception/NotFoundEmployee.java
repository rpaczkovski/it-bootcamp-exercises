package com.meli.employees.exception;

public class NotFoundEmployee extends RuntimeException {
    public NotFoundEmployee(String message) {
        super(message);
    }
}
