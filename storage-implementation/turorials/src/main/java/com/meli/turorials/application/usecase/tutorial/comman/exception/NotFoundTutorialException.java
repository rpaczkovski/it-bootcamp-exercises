package com.meli.turorials.application.usecase.tutorial.comman.exception;

import com.meli.turorials.application.exception.ApplicationException;

public class NotFoundTutorialException extends ApplicationException {
    public NotFoundTutorialException(String message) {
        super(message);
    }
}
