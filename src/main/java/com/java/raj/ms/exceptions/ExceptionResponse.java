package com.java.raj.ms.exceptions;

import java.util.Date;


public class ExceptionResponse {
    Date timestamp;
    String message;
    String description;

    public ExceptionResponse(Date timestamp, String message, String description) {
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }
}
