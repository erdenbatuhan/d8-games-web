package com.d8games.web.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class EmployeeNotAuthorizedException extends RuntimeException {

    private static final String MESSAGE = "Employee not authorized!";
    private static final String CONSOLE_MESSAGE = "Employee with ID = %s not authorized!";

    public EmployeeNotAuthorizedException(String employeeId) {
        super(MESSAGE);
        System.err.println(String.format(CONSOLE_MESSAGE, employeeId));
    }
}
