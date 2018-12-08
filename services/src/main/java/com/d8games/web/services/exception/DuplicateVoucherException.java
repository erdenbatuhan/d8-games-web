package com.d8games.web.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class DuplicateVoucherException extends RuntimeException {

    private static final String MESSAGE = "You cannot have adjacent %ss!";

    public DuplicateVoucherException(String type) {
        super(String.format(MESSAGE, type));
    }
}
