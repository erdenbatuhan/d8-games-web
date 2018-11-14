package com.d8games.web.services.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "WORK_INFO")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class WorkInfo {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID", unique = true, nullable = false)
    private String id;

    @Temporal(TemporalType.DATE)
    @Column(name = "ACTUAL_START_DATE", nullable = false)
    private Date actualStartDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "ACTUAL_END_DATE", nullable = false)
    private Date actualEndDate;

    @Column(name = "START_DATE", nullable = false)
    private String startDate;

    @Column(name = "END_DATE", nullable = false)
    private String endDate;

    @Column(name = "OFFICE_HOURS_COMPLETED", length = 10, precision = 1, nullable = false)
    private Double officeHoursCompleted;

    @Column(name = "HOME_HOURS_COMPLETED", length = 10, precision = 1, nullable = false)
    private Double homeHoursCompleted;

    @Column(name = "EXCUSED_HOURS_USED", length = 10, precision = 1, nullable = false)
    private Double excusedHoursUsed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID", nullable = false)
    private Employee employee;
}
