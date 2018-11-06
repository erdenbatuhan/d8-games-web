package com.d8games.web.services.model.dto;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unused")
public class EmployeeCardDto {

    private String employeeFullName;
    private String employeeEmail;
    private String employeePhoneNumber;
    private String titleName;
    private String departmentName;
    private Double employeeCompletedWorkInHours;
    private Long timeSinceJoin;

    public EmployeeCardDto(String employeeName, String employeeSurname, String employeeEmail,
                           String employeePhoneNumber, String titleName,
                           String departmentName, Double employeeCompletedWorkInHours, Date employeeJoinDate) {
        setEmployeeFullName(employeeName, employeeSurname);

        this.employeeEmail = employeeEmail;
        this.employeePhoneNumber = employeePhoneNumber;
        this.titleName = titleName;
        this.departmentName = departmentName;
        this.employeeCompletedWorkInHours = employeeCompletedWorkInHours;

        setTimeSinceJoin(employeeJoinDate);
    }

    public String getEmployeeFullName() {
        return employeeFullName;
    }

    public void setEmployeeFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }

    public void setEmployeeFullName(String employeeName, String employeeSurname) {
        this.employeeFullName = employeeName + " " + employeeSurname;
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

    public Double getEmployeeCompletedWorkInHours() {
        return employeeCompletedWorkInHours;
    }

    public void setEmployeeCompletedWorkInHours(Double employeeCompletedWorkInHours) {
        this.employeeCompletedWorkInHours = employeeCompletedWorkInHours;
    }

    public Long getTimeSinceJoin() {
        return timeSinceJoin;
    }

    public void setTimeSinceJoin(Long timeSinceJoin) {
        this.timeSinceJoin = timeSinceJoin;
    }

    public void setTimeSinceJoin(Date employeeJoinDate) {
        long timeInMillies = new Date().getTime() - employeeJoinDate.getTime();
        long timeInDays = TimeUnit.DAYS.convert(timeInMillies, TimeUnit.MILLISECONDS);

        this.timeSinceJoin = timeInDays;
    }
}
