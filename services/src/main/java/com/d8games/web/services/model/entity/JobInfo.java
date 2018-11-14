package com.d8games.web.services.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "JOB_INFO")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class JobInfo implements Serializable {

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
}
