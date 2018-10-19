package com.d8games.web.services.model.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE")
@EntityListeners(AuditingEntityListener.class)
@SuppressWarnings("unused")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "EMPLOYEE_ID", unique = true, updatable = false, nullable = false)
    private String employeeId;

    @Column(name = "EMPLOYEE_NAME", updatable = false, nullable = false)
    private String employeeName;

    @Column(name = "EMPLOYEE_SURNAME", updatable = false, nullable = false)
    private String employeeSurname;

    @Column(name = "EMPLOYEE_PHOTO", nullable = false)
    private String employeePhoto;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EMPLOYEE_STARTING_DATE", updatable = false, nullable = false)
    private Date employeeStartingDate;

    @OneToOne
    @JoinColumn(name = "EMPLOYEE_TITLE_ID", referencedColumnName = "TITLE_ID", nullable = false)
    private Title employeeTitle;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public String getEmployeePhoto() {
        return employeePhoto;
    }

    public void setEmployeePhoto(String employeePhoto) {
        this.employeePhoto = employeePhoto;
    }

    public Date getEmployeeStartingDate() {
        return employeeStartingDate;
    }

    public void setEmployeeStartingDate(Date employeeStartingDate) {
        this.employeeStartingDate = employeeStartingDate;
    }

    public Title getEmployeeTitle() {
        return employeeTitle;
    }

    public void setEmployeeTitle(Title employeeTitle) {
        this.employeeTitle = employeeTitle;
    }
}
