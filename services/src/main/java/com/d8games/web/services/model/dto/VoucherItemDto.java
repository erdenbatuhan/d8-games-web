package com.d8games.web.services.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoucherItemDto {

    private String date;
    private String day;
    private String hour;
    private String type;
    private String location;
    private Boolean admin;

    public VoucherItemDto(String date, String day, String hour, String type, String location, Boolean admin) {
        this.date = date;
        this.day = day;
        this.hour = hour;
        this.type = type;
        this.location = location;
        this.admin = admin;
    }
}
