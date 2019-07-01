package com.halcyonmobile.demo.exception.handler;

import com.halcyonmobile.demo.exception.ErrorMessage;
import com.halcyonmobile.demo.exception.ResourceNotFoundException;
import com.halcyonmobile.demo.exception.error_type.ErrorType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ErrorMessage handle(final Exception exception) {
        log.error("Internal exception!", exception);
        return new ErrorMessage(INTERNAL_SERVER_ERROR.value(), INTERNAL_SERVER_ERROR.getReasonPhrase(), Instant.now(), null);
    }

    @ExceptionHandler
    @ResponseStatus(NOT_FOUND)
    public ErrorMessage handle(final ResourceNotFoundException exception) {
        log.error("Internal exception!", exception);
        final ErrorType errorType = exception.getErrorType();
        final com.halcyonmobile.demo.exception.Error error = new com.halcyonmobile.demo.exception.Error(errorType.getCode(),
                errorType.getDescription(), exception.getMessage());
        return new ErrorMessage(NOT_FOUND.value(), NOT_FOUND.getReasonPhrase(), Instant.now(), error);
    }

}
