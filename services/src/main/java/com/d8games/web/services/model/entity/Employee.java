package com.d8games.web.services.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@SuppressWarnings("unused")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "EMPLOYEE_ID", unique = true, nullable = false)
    private String employeeId;

    @Column(name = "EMPLOYEE_MOBILE_PHONE_ID", unique = true)
    private String employeeMobilePhoneId;

    @Column(name = "EMPLOYEE_NAME", nullable = false)
    private String employeeName;

    @Column(name = "EMPLOYEE_SURNAME", nullable = false)
    private String employeeSurname;

    @Column(name = "EMPLOYEE_EMAIL", nullable = false)
    private String employeeEmail;

    @Column(name = "EMPLOYEE_PHONE_NUMBER", nullable = false)
    private String employeePhoneNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "EMPLOYEE_JOIN_DATE", nullable = false)
    private Date employeeJoinDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_TITLE_ID", referencedColumnName = "TITLE_ID", nullable = false)
    private Title employeeTitle;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeMobilePhoneId() {
        return employeeMobilePhoneId;
    }

    public void setEmployeeMobilePhoneId(String employeeMobilePhoneId) {
        this.employeeMobilePhoneId = employeeMobilePhoneId;
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

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public Date getEmployeeJoinDate() {
        return employeeJoinDate;
    }

    public void setEmployeeJoinDate(Date employeeJoinDate) {
        this.employeeJoinDate = employeeJoinDate;
    }

    public Title getEmployeeTitle() {
        return employeeTitle;
    }

    public void setEmployeeTitle(Title employeeTitle) {
        this.employeeTitle = employeeTitle;
    }
}
