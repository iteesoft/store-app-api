package com.iteesoft.storeapp.exceptions;

import com.iteesoft.storeapp.payload.ApiValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiValidationError> handleNotFound(NotFoundException appException) {

        return new ResponseEntity<>(ApiValidationError.builder()
                .errors(Map.of("error", appException.getMessage())).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ApiValidationError> handleNotFound(AlreadyExistException appException) {

        return new ResponseEntity<>(ApiValidationError.builder()
                .errors(Map.of("error", appException.getMessage())).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiValidationError> handleInvalidArgument(MethodArgumentNotValidException ex) {
        var errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(ApiValidationError.builder().errors(errors).build(), HttpStatus.BAD_REQUEST);
    }

}
