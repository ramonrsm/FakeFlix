package com.example.fakeflix.Models.Exceptions;

public class DomainException extends Exception {

    private static final long serialVersionID = 1L;

    public DomainException(String message) {
        super(message);
    }
}
