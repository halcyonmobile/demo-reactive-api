package com.halcyonmobile.demo.exception;

import com.halcyonmobile.demo.exception.error_type.ErrorType;

public class ResourceNotFoundException extends RestRuntimeException {

    public ResourceNotFoundException(final String message, final ErrorType errorType) {
        super(message, errorType);
    }

}
