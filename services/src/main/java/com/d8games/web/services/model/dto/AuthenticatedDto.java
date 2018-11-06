package com.d8games.web.services.model.dto;

@SuppressWarnings("unused")
public class AuthenticatedDto {

    private String authenticatedEmployeeId;
    private String authenticatedEmployeeIp;

    public AuthenticatedDto() {

    }

    public AuthenticatedDto(String authenticatedEmployeeId, String authenticatedEmployeeIp) {
        this.authenticatedEmployeeId = authenticatedEmployeeId;
        this.authenticatedEmployeeIp = authenticatedEmployeeIp;
    }

    public String getAuthenticatedEmployeeId() {
        return authenticatedEmployeeId;
    }

    public void setAuthenticatedEmployeeId(String authenticatedEmployeeId) {
        this.authenticatedEmployeeId = authenticatedEmployeeId;
    }

    public String getAuthenticatedEmployeeIp() {
        return authenticatedEmployeeIp;
    }

    public void setAuthenticatedEmployeeIp(String authenticatedEmployeeIp) {
        this.authenticatedEmployeeIp = authenticatedEmployeeIp;
    }
}
