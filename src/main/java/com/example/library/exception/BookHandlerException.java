package com.example.library.exception;

import com.example.library.exception.handling.IncorrectDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookHandlerException {

    @ExceptionHandler
    public ResponseEntity<IncorrectDataException> notFound(NoSuchBookException exception){
        IncorrectDataException data=new IncorrectDataException(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}
