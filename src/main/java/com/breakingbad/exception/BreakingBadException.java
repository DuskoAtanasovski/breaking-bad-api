package com.breakingbad.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BreakingBadException extends RuntimeException {

    public BreakingBadException(String message) {
        super(message);
    }

    public BreakingBadException(String message, Exception exception) {
        super(message, exception);
    }
}