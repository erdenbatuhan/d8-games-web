package com.d8games.web.services.model.dto;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class EmployeeCardDto {

    private String employeeName;
    private String employeeSurname;
    private String titleName;
    private String departmentName;
    private Long timeSinceJoin;

    public EmployeeCardDto(String employeeName, String employeeSurname, String titleName,
                           String departmentName, Date employeeJoinDate) {
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.titleName = titleName;
        this.departmentName = departmentName;
        this.timeSinceJoin = getEmployeeTimeSinceJoin(employeeJoinDate);
    }

    public Long getEmployeeTimeSinceJoin(Date employeeJoinDate) {
        long timeSinceJoinInMillies = new Date().getTime() - employeeJoinDate.getTime();
        long timeSinceJoinInDays = TimeUnit.DAYS.convert(timeSinceJoinInMillies, TimeUnit.MILLISECONDS);

        return timeSinceJoinInDays;
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

    public Long getTimeSinceJoin() {
        return timeSinceJoin;
    }

    public void setTimeSinceJoin(Long timeSinceJoin) {
        this.timeSinceJoin = timeSinceJoin;
    }
}
