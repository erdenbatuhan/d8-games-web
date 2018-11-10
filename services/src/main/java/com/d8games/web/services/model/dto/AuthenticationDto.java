package com.d8games.web.services.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationDto {

    private String mobilePhoneId;
    private String ip;

    public AuthenticationDto(String mobilePhoneId, String ip) {
        this.mobilePhoneId = mobilePhoneId;
        this.ip = ip;
    }
}
