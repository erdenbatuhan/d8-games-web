package com.d8games.web.services.model.dto;

@SuppressWarnings("unused")
public class DashboardDto {

    private String employeeId;
    private String employeeName;
    private String employeeSurname;
    private String employeeTitleName;

    public DashboardDto(String employeeId, String employeeName, String employeeSurname, String employeeTitleName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.employeeTitleName = employeeTitleName;
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

    public String getEmployeeTitleName() {
        return employeeTitleName;
    }

    public void setEmployeeTitleName(String employeeTitleName) {
        this.employeeTitleName = employeeTitleName;
    }
}
