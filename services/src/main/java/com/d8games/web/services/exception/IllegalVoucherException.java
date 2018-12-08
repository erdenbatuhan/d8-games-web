package com.d8games.web.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FAILED_DEPENDENCY)
public class IllegalVoucherException extends RuntimeException {

    private static final String MESSAGE = "You cannot vouch out at %s if you have vouched in at %s!";

    public IllegalVoucherException(String voucherTypeInLocation, String voucherTypeOutLocation) {
        super(String.format(MESSAGE, voucherTypeOutLocation, voucherTypeInLocation));
    }
}
