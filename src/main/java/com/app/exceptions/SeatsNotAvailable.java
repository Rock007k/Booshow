package com.app.exceptions;

public class SeatsNotAvailable extends RuntimeException{
    public SeatsNotAvailable(){
        super("Requested Seats are Not Available");
    }
}
