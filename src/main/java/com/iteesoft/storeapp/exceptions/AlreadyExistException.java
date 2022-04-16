package com.iteesoft.storeapp.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class AlreadyExistException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final String debugMessage;

    public AlreadyExistException(String message, String debugMessage) {
        super(message);
        this.debugMessage = debugMessage;
    }
}
