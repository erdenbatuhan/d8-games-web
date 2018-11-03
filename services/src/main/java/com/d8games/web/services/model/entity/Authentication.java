package com.d8games.web.services.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "AUTHENTICATION")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@SuppressWarnings("unused")
public class Authentication implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "AUTHENTICATION_ID", unique = true, nullable = false)
    private String authenticationId;

    @Column(name = "AUTHENTICATION_IP", nullable = false)
    private String authenticationIp;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AUTHENTICATION_CREATED_DATE", nullable = false)
    private Date authenticationCreatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHENTICATION_EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
    private Employee authenticationEmployee;

    public String getAuthenticationId() {
        return authenticationId;
    }

    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId;
    }

    public String getAuthenticationIp() {
        return authenticationIp;
    }

    public void setAuthenticationIp(String authenticationIp) {
        this.authenticationIp = authenticationIp;
    }

    public Date getAuthenticationCreatedDate() {
        return authenticationCreatedDate;
    }

    public void setAuthenticationCreatedDate(Date authenticationCreatedDate) {
        this.authenticationCreatedDate = authenticationCreatedDate;
    }

    public Employee getAuthenticationEmployee() {
        return authenticationEmployee;
    }

    public void setAuthenticationEmployee(Employee authenticationEmployee) {
        this.authenticationEmployee = authenticationEmployee;
    }
}
