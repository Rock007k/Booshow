package com.app.exceptions;

public class MovieAlreadyExist extends RuntimeException{
    public MovieAlreadyExist(){
        super("Movie already exists with same name and language");
    }
}
