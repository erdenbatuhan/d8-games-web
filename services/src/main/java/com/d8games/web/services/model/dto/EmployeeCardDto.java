package com.d8games.web.services.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class EmployeeCardDto {

    private String fullName;
    private String titleName;
    private String departmentName;
    private String managerId;
    private String managerFullName;
    private String email;
    private String phoneNumber;
    private Double completedStoryPoints;
    private Long timeSinceJoin;

    public EmployeeCardDto(String fullName, String titleName, String departmentName, String managerId,
                           String email, String phoneNumber, Double completedStoryPoints, Date joinDate) {
        this.fullName = fullName;
        this.titleName = titleName;
        this.departmentName = departmentName;
        this.managerId = managerId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.completedStoryPoints = completedStoryPoints;

        setTimeSinceJoin(joinDate);
    }

    public void setTimeSinceJoin(Date joinDate) {
        long timeInMillies = new Date().getTime() - joinDate.getTime();
        long timeInDays = TimeUnit.DAYS.convert(timeInMillies, TimeUnit.MILLISECONDS);

        this.timeSinceJoin = timeInDays;
    }
}
