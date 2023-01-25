package com.telia.personalinformation.exception;

public class PersonEntityNotFoundException extends RuntimeException {
    public PersonEntityNotFoundException(Long personNumber) {
        super(String.format("Person Number %d not found", personNumber));
    }
}
