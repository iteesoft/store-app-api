package com.iteesoft.storeapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> appExceptionHandler(NotFoundException appException) {
        return new ResponseEntity<>(appException.getMessage(), HttpStatus.NOT_FOUND);
    }

}
