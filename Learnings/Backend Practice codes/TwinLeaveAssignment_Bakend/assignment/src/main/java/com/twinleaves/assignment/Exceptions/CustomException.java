package com.twinleaves.assignment.Exceptions;

public class CustomException extends RuntimeException{
    public CustomException(String msg, Throwable cause){
        super(msg,cause);
    }
}
