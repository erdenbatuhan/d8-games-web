package com.d8games.web.services.model.dto;

@SuppressWarnings("unused")
public class WorkInfoDto {

    private String workInfoId;
    private String workInfoName;
    private Double officeHoursNeededPerMonth;
    private Double homeHoursNeededPerMonth;
    private Double unpaidHoursNeededPerMonth;
    private Double salaryPerHour;
    private Double overtimeSalaryPerHour;

    public WorkInfoDto(String workInfoId, String workInfoName, Double officeHoursNeededPerMonth,
                       Double homeHoursNeededPerMonth, Double unpaidHoursNeededPerMonth,
                       Double salaryPerHour, Double overtimeSalaryPerHour) {
        this.workInfoId = workInfoId;
        this.workInfoName = workInfoName;
        this.officeHoursNeededPerMonth = officeHoursNeededPerMonth;
        this.homeHoursNeededPerMonth = homeHoursNeededPerMonth;
        this.unpaidHoursNeededPerMonth = unpaidHoursNeededPerMonth;
        this.salaryPerHour = salaryPerHour;
        this.overtimeSalaryPerHour = overtimeSalaryPerHour;
    }

    public String getWorkInfoId() {
        return workInfoId;
    }

    public void setWorkInfoId(String workInfoId) {
        this.workInfoId = workInfoId;
    }

    public String getWorkInfoName() {
        return workInfoName;
    }

    public void setWorkInfoName(String workInfoName) {
        this.workInfoName = workInfoName;
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

    public Double getUnpaidHoursNeededPerMonth() {
        return unpaidHoursNeededPerMonth;
    }

    public void setUnpaidHoursNeededPerMonth(Double unpaidHoursNeededPerMonth) {
        this.unpaidHoursNeededPerMonth = unpaidHoursNeededPerMonth;
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
}
