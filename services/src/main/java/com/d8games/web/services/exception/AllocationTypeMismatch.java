package com.d8games.web.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
public class AllocationTypeMismatch extends RuntimeException {

    public AllocationTypeMismatch(String allocationType) {
        super(String.format("%s is not a valid allocation type", allocationType));
    }
}
