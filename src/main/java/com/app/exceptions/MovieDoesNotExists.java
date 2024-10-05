package com.app.exceptions;

public class MovieDoesNotExists extends RuntimeException{
    public MovieDoesNotExists(){
        super("Movie does not exists");
    }
}
