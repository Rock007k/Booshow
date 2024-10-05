package com.app.exceptions;

public class UserExist extends RuntimeException{
    public UserExist(){
        super("User already exists with this emailId");
    }
}
