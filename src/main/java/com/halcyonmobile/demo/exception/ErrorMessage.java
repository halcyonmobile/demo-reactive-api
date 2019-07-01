package com.halcyonmobile.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

    private int status;
    private String message;
    private Instant timestamp;
    private Error error;

}
