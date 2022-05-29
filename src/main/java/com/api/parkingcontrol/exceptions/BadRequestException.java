package com.api.parkingcontrol.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Entity not found")
public class BadRequestException extends RuntimeException {

    public BadRequestException(final String message) {
        super(message);
    }
}
