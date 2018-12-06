package com.d8games.web.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class EmployeeNotAuthorizedException extends RuntimeException {

    public EmployeeNotAuthorizedException(String employeeId) {
        super(String.format("Employee with ID = %s not authorized!", employeeId));
    }
}
