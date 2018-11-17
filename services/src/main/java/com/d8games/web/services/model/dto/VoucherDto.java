package com.d8games.web.services.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class VoucherDto {

    private Date actualDate;
    private String type;
    private String location;

    public VoucherDto(Date actualDate, String type, String location) {
        this.actualDate = actualDate;
        this.type = type;
        this.location = location;
    }
}
