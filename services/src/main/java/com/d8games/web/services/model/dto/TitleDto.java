package com.d8games.web.services.model.dto;

@SuppressWarnings("unused")
public class TitleDto {

    private String id;
    private String name;
    private Double officeHoursNeededPerMonth;
    private Double homeHoursNeededPerMonth;
    private Double salaryPerHour;
    private Double overtimeSalaryPerHour;
    private String departmentId;

    public TitleDto() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getOfficeHoursNeededPerMonth() {
        return officeHoursNeededPerMonth;
    }

    public void setOfficeHoursNeededPerMonth(Double officeHoursNeededPerMonth) {
        this.officeHoursNeededPerMonth = officeHoursNeededPerMonth;
    }

    public Double getHomeHoursNeededPerMonth() {
        return homeHoursNeededPerMonth;
    }

    public void setHomeHoursNeededPerMonth(Double homeHoursNeededPerMonth) {
        this.homeHoursNeededPerMonth = homeHoursNeededPerMonth;
    }

    public Double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(Double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public Double getOvertimeSalaryPerHour() {
        return overtimeSalaryPerHour;
    }

    public void setOvertimeSalaryPerHour(Double overtimeSalaryPerHour) {
        this.overtimeSalaryPerHour = overtimeSalaryPerHour;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
