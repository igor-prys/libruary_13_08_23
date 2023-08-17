package com.example.library.exception;

import com.example.library.exception.handling.IncorrectDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<IncorrectDataException> handleException(NoSuchBookException exception){
        IncorrectDataException dataException=new IncorrectDataException(exception.getMessage());
        return new ResponseEntity<>(dataException, HttpStatus.NOT_FOUND);
    }
}
