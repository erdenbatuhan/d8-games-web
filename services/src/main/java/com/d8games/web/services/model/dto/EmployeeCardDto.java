package com.d8games.web.services.model.dto;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unused")
public class EmployeeCardDto {

    private String employeeFullName;
    private String titleName;
    private String departmentName;
    private String employeeEmail;
    private String employeePhoneNumber;
    private Long employeeTimeSinceJoin;

    public EmployeeCardDto(String employeeFullName, String titleName, String departmentName,
                           String employeeEmail, String employeePhoneNumber, Date employeeJoinDate) {
        this.employeeFullName = employeeFullName;
        this.titleName = titleName;
        this.departmentName = departmentName;
        this.employeeEmail = employeeEmail;
        this.employeePhoneNumber = employeePhoneNumber;

        setTimeSinceJoin(employeeJoinDate);
    }

    public String getEmployeeFullName() {
        return employeeFullName;
    }

    public void setEmployeeFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public Long getEmployeeTimeSinceJoin() {
        return employeeTimeSinceJoin;
    }

    public void setEmployeeTimeSinceJoin(Long employeeTimeSinceJoin) {
        this.employeeTimeSinceJoin = employeeTimeSinceJoin;
    }

    public void setTimeSinceJoin(Date employeeJoinDate) {
        long timeInMillies = new Date().getTime() - employeeJoinDate.getTime();
        long timeInDays = TimeUnit.DAYS.convert(timeInMillies, TimeUnit.MILLISECONDS);

        this.employeeTimeSinceJoin = timeInDays;
    }
}
