package com.example.library.exception;

public class NoSuchBookException extends RuntimeException{

    public NoSuchBookException(String message){
        super(message);
    }
}
