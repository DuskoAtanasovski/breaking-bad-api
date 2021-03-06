package com.breakingbad.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setStatus(HttpStatus.BAD_REQUEST);
        exceptionResponse.setMessage(ex.getLocalizedMessage());
        exceptionResponse.setTimestamp(new Date());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RecordNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(RecordNotFoundException nfe, WebRequest request) {

        String errorMessageDescription = nfe.getLocalizedMessage();

        if (errorMessageDescription == null)
            errorMessageDescription = nfe.getMessage();

        ExceptionResponse exceptionResponse = new ExceptionResponse();

        exceptionResponse.setStatus(HttpStatus.NOT_FOUND);
        exceptionResponse.setMessage(errorMessageDescription);
        exceptionResponse.setTimestamp(new Date());
        exceptionResponse.setErrorCode("L-001");

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}
