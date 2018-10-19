package com.d8games.web.services.model.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TITLE")
@EntityListeners(AuditingEntityListener.class)
@SuppressWarnings("unused")
public class Title implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "TITLE_ID", unique = true, updatable = false, nullable = false)
    private String titleId;

    @Column(name = "TITLE_NAME", unique = true, nullable = false)
    private String titleName;

    @Column(name = "OFFICE_HOURS_NEEDED_PER_MONTH", length = 10, precision = 1, nullable = false)
    private Double officeHoursNeededPerMonth;

    @Column(name = "HOME_HOURS_NEEDED_PER_MONTH", length = 10, precision = 1, nullable = false)
    private Double homeHoursNeededPerMonth;

    @Column(name = "SALARY_PER_HOUR", length = 10, precision = 1, nullable = false)
    private Double salaryPerHour;

    @Column(name = "OVERTIME_SALARY_PER_HOUR", length = 10, precision = 1, nullable = false)
    private Double overtimeSalaryPerHour;

    @OneToOne
    @JoinColumn(name = "TITLE_DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID", nullable = false)
    private Department titleDepartment;

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
