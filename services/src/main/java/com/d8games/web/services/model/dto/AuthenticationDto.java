package com.d8games.web.services.model.dto;

public class AuthenticationDto {

    private String mobilePhoneId;
    private String ip;

    public AuthenticationDto(String mobilePhoneId, String ip) {
        this.mobilePhoneId = mobilePhoneId;
        this.ip = ip;
    }

    public String getMobilePhoneId() {
        return mobilePhoneId;
    }

    public void setMobilePhoneId(String mobilePhoneId) {
        this.mobilePhoneId = mobilePhoneId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
