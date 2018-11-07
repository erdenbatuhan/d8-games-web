package com.d8games.web.services.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "JOB_INFO")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@SuppressWarnings("unused")
public class JobInfo {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID", unique = true, nullable = false)
    private String id;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "UNPAID_HOURS_NEEDED_PER_MONTH", length = 10, precision = 1, nullable = false)
    private Double unpaidHoursNeededPerMonth;

    @Column(name = "OFFICE_HOURS_NEEDED_PER_MONTH", length = 10, precision = 1, nullable = false)
    private Double officeHoursNeededPerMonth;

    @Column(name = "HOME_HOURS_NEEDED_PER_MONTH", length = 10, precision = 1, nullable = false)
    private Double homeHoursNeededPerMonth;

    @Column(name = "SALARY_PER_HOUR", length = 10, precision = 1, nullable = false)
    private Double salaryPerHour;

    @Column(name = "OVERTIME_SALARY_PER_HOUR", length = 10, precision = 1, nullable = false)
    private Double overtimeSalaryPerHour;

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

    public Double getUnpaidHoursNeededPerMonth() {
        return unpaidHoursNeededPerMonth;
    }

    public void setUnpaidHoursNeededPerMonth(Double unpaidHoursNeededPerMonth) {
        this.unpaidHoursNeededPerMonth = unpaidHoursNeededPerMonth;
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
}
