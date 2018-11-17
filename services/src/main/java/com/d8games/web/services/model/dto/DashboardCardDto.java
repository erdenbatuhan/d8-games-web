package com.d8games.web.services.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DashboardCardDto {

    private String id;
    private String fullName;
    private String titleName;
    private String departmentName;

    public DashboardCardDto(String id, String fullName, String titleName, String departmentName) {
        this.id = id;
        this.fullName = fullName;
        this.titleName = titleName;
        this.departmentName = departmentName;
    }
}
