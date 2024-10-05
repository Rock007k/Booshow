package com.app.exceptions;

public class TheaterNotExist extends RuntimeException{
    public TheaterNotExist(){
        super("Theater is not present in this address");
    }
}
