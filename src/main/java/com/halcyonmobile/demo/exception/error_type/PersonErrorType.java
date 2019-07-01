package com.halcyonmobile.demo.exception.error_type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PersonErrorType implements ErrorType {

    NOT_FOUND(Value.NOT_FOUND, "Person not found!");

    private String code;
    private String description;

    private class Value {

        private static final String PREFIX = "person_";

        private static final String NOT_FOUND = PREFIX + "not_found";

    }

}
