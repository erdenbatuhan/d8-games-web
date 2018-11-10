package com.d8games.web.services.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticatedEmployeeDto {

    private String id;
    private String ip;

    public AuthenticatedEmployeeDto(String id, String ip) {
        this.id = id;
        this.ip = ip;
    }
}
