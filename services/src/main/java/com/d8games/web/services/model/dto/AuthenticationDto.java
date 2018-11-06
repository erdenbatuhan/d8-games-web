package com.d8games.web.services.model.dto;

@SuppressWarnings("unused")
public class AuthenticationDto {

    private String authenticationEmployeeMobilePhoneId;
    private String authenticationIp;

    public AuthenticationDto(String authenticationEmployeeMobilePhoneId, String authenticationIp) {
        this.authenticationEmployeeMobilePhoneId = authenticationEmployeeMobilePhoneId;
        this.authenticationIp = authenticationIp;
    }

    public String getAuthenticationEmployeeMobilePhoneId() {
        return authenticationEmployeeMobilePhoneId;
    }

    public void setAuthenticationEmployeeMobilePhoneId(String authenticationEmployeeMobilePhoneId) {
        this.authenticationEmployeeMobilePhoneId = authenticationEmployeeMobilePhoneId;
    }

    public String getAuthenticationIp() {
        return authenticationIp;
    }

    public void setAuthenticationIp(String authenticationIp) {
        this.authenticationIp = authenticationIp;
    }
}
