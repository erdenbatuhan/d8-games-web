package com.d8games.web.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeNotFound extends RuntimeException {

    public EmployeeNotFound(String employeeId) {
        super(String.format("Employee with ID = %s not found!", employeeId));
    }
}
