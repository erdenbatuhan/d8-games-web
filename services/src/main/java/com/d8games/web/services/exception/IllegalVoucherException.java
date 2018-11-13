package com.d8games.web.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class IllegalVoucherException extends RuntimeException {

    public IllegalVoucherException(String voucherTypeInLocation, String voucherTypeOutLocation) {
        super(String.format("You cannot vouch out at %s if you have vouched in at %s!",
                voucherTypeOutLocation, voucherTypeInLocation));
    }
}
