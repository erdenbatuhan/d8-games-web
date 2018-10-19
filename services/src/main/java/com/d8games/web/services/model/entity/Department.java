package com.d8games.web.services.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DEPARTMENT")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "departmentName" })
@SuppressWarnings("unused")
public class Department implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "DEPARTMENT_ID", unique = true, updatable = false, nullable = false)
    private String departmentId;

    @Column(name = "DEPARTMENT_NAME", unique = true, nullable = false)
    private String departmentName;

    @Column(name = "ACTUAL_DEPARTMENT_NAME", nullable = false)
    private String actualDepartmentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTMENT_MANAGER_ID", referencedColumnName = "EMPLOYEE_ID")
    private Employee departmentManager;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getActualDepartmentName() {
        return actualDepartmentName;
    }

    public void setActualDepartmentName(String actualDepartmentName) {
        this.actualDepartmentName = actualDepartmentName;
    }

    public Employee getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(Employee departmentManager) {
        this.departmentManager = departmentManager;
    }
}
