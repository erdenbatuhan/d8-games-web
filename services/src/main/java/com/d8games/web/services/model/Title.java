package com.d8games.web.services.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TITLE")
@EntityListeners(AuditingEntityListener.class)
public class Title implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID", unique = true, updatable = false, nullable = false)
    private String id;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "OFFICE_HOURS_NEEDED_PER_MONTH", length = 10, precision = 1, nullable = false)
    private Double officeHoursNeededPerMonth;

    @Column(name = "HOME_HOURS_NEEDED_PER_MONTH", length = 10, precision = 1, nullable = false)
    private Double homeHoursNeededPerMonth;

    @Column(name = "SALARY_PER_HOUR", length = 10, precision = 1, nullable = false)
    private Double salaryPerHour;

    @Column(name = "OVERTIME_SALARY_PER_HOUR", length = 10, precision = 1, nullable = false)
    private Double overtimeSalaryPerHour;

    @OneToOne
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "ID", nullable = false)
    private Department department;

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
