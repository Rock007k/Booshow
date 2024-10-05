package com.app.exceptions;

public class UserDoesNotExists extends RuntimeException{
    public UserDoesNotExists(){
        super("User Does not exists");
    }
}
