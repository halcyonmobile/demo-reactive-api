package com.halcyonmobile.demo.exception;

import com.halcyonmobile.demo.exception.error_type.ErrorType;
import lombok.Getter;

@Getter
class RestRuntimeException extends RuntimeException {

    private ErrorType errorType;

    public RestRuntimeException(final String message, final ErrorType errorType) {
        super(message);
        this.errorType = errorType;
    }

}
