package com.d8games.web.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Employee not found!";
    private static final String CONSOLE_MESSAGE = "Employee (%s) not found!";

    public EmployeeNotFoundException(String employeeId) {
        super(MESSAGE);
        System.err.println(String.format(CONSOLE_MESSAGE, employeeId));
    }
}
