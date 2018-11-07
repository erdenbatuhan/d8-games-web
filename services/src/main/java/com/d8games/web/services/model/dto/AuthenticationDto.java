package com.d8games.web.services.model.dto;

@SuppressWarnings("unused")
public class AuthenticationDto {

    private String employeeId;
    private String authenticationIp;

    public AuthenticationDto(String employeeId, String authenticationIp) {
        this.employeeId = employeeId;
        this.authenticationIp = authenticationIp;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getAuthenticationIp() {
        return authenticationIp;
    }

    public void setAuthenticationIp(String authenticationIp) {
        this.authenticationIp = authenticationIp;
    }
}
