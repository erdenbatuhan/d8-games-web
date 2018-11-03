package com.d8games.web.services.model.dto;

@SuppressWarnings("unused")
public class DashboardCardDto {

    private String employeeId;
    private String employeeFullName;
    private String titleName;
    private String departmentName;

    public DashboardCardDto(String employeeId, String employeeName, String employeeSurname,
                            String titleName, String departmentName) {
        this.employeeId = employeeId;

        setEmployeeFullName(employeeName, employeeSurname);

        this.titleName = titleName;
        this.departmentName = departmentName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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
}
