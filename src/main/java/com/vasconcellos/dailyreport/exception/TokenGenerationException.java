package com.vasconcellos.dailyreport.exception;

public class TokenGenerationException extends RuntimeException {

    public TokenGenerationException() {
        super("Error while generating token.");
    }
}