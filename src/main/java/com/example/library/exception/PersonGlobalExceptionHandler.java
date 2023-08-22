package com.example.library.exception;

import com.example.library.exception.handling.IncorrectDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class PersonGlobalExceptionHandler {

    public ResponseEntity<IncorrectDataException>handleException(NoSuchPersonException exception){
        IncorrectDataException dataException=new IncorrectDataException(exception.getMessage());
        return new ResponseEntity<>(dataException, HttpStatus.NOT_FOUND);
    }
}
