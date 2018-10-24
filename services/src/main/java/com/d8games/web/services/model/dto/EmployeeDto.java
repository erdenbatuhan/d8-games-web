package com.d8games.web.services.model.dto;

import com.d8games.web.services.model.entity.Title;

import java.util.Date;

@SuppressWarnings("unused")
public class EmployeeDto {

    private String employeeId;
    private String employeeName;
    private String employeeSurname;
    private String employeePhoto;
    private Date employeeJoinDate;
    private Title employeeTitle;

    public EmployeeDto(String employeeId, String employeeName, String employeeSurname,
                       String employeePhoto, Date employeeJoinDate, Title employeeTitle) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.employeePhoto = employeePhoto;
        this.employeeJoinDate = employeeJoinDate;
        this.employeeTitle = employeeTitle;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    public String getEmployeePhoto() {
        return employeePhoto;
    }

    public void setEmployeePhoto(String employeePhoto) {
        this.employeePhoto = employeePhoto;
    }

    public Date getEmployeeJoinDate() {
        return employeeJoinDate;
    }

    public void setEmployeeJoinDate(Date employeeJoinDate) {
        this.employeeJoinDate = employeeJoinDate;
    }

    public Title getEmployeeTitle() {
        return employeeTitle;
    }

    public void setEmployeeTitle(Title employeeTitle) {
        this.employeeTitle = employeeTitle;
    }
}
