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

    @Column(name = "AUTHENTICATION_IP")
    private String authenticationIp;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AUTHENTICATION_CREATED_DATE", nullable = false)
    private Date authenticationCreatedDate;

    @Column(name = "AUTHENTICATION_EMPLOYEE_MOBILE_PHONE_ID")
    private String authenticationEmployeeMobilePhoneId;

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

    public String getAuthenticationEmployeeMobilePhoneId() {
        return authenticationEmployeeMobilePhoneId;
    }

    public void setAuthenticationEmployeeMobilePhoneId(String authenticationEmployeeMobilePhoneId) {
        this.authenticationEmployeeMobilePhoneId = authenticationEmployeeMobilePhoneId;
    }
}
