package com.ctd.backend.exceptions;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler({ConfigDataResourceNotFoundException.class})
    public ResponseEntity<String> rnfe (ResourceNotFoundException exp) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exp.getMessage());
    }
    @ExceptionHandler({DuplicatedValueException.class})
    public ResponseEntity<String> duplicatedValueException(DuplicatedValueException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }
}
