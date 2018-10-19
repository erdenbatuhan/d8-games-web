package com.d8games.web.services.model.dto;

import com.d8games.web.services.model.entity.Department;

@SuppressWarnings("unused")
public class TitleDto {

    private String titleId;
    private String titleName;
    private Double officeHoursNeededPerMonth;
    private Double homeHoursNeededPerMonth;
    private Double salaryPerHour;
    private Double overtimeSalaryPerHour;
    private Department titleDepartment;

    public TitleDto(String titleId, String titleName, Double officeHoursNeededPerMonth, Double homeHoursNeededPerMonth,
                    Double salaryPerHour, Double overtimeSalaryPerHour, Department titleDepartment) {
        this.titleId = titleId;
        this.titleName = titleName;
        this.officeHoursNeededPerMonth = officeHoursNeededPerMonth;
        this.homeHoursNeededPerMonth = homeHoursNeededPerMonth;
        this.salaryPerHour = salaryPerHour;
        this.overtimeSalaryPerHour = overtimeSalaryPerHour;
        this.titleDepartment = titleDepartment;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
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

    public Department getTitleDepartment() {
        return titleDepartment;
    }

    public void setTitleDepartment(Department titleDepartment) {
        this.titleDepartment = titleDepartment;
    }
}
