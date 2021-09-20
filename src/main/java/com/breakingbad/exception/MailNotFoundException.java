package com.breakingbad.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MailNotFoundException extends RuntimeException {
    public MailNotFoundException(String message, Exception exception) {
        super(message, exception);
    }
}
