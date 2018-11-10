package com.d8games.web.services.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactCardDto {

    private String fullName;
    private String email;
    private String phoneNumber;
    private String titleName;

    public ContactCardDto(String fullName, String email,
                          String phoneNumber, String titleName) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.titleName = titleName;
    }
}
