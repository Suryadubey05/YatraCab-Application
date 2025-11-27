package com.example.YatraCab.Exception;

public class BookingNotFoundException extends RuntimeException{
    public BookingNotFoundException(String m){
        super(m);
    }
}
