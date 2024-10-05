package com.app.exceptions;

public class TheaterExist extends RuntimeException{
    public TheaterExist(){
        super("Theater is already present on this address");
    }

}
