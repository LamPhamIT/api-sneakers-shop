package com.shinn.sneakersshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDataSentException extends RuntimeException{
    public String fieldName;
    public InvalidDataSentException(String fieldName) {
        super(String.format("Invalid with %s",fieldName));
        this.fieldName = fieldName;
    }
}
