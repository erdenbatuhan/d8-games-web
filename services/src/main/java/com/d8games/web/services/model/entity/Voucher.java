package com.d8games.web.services.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "VOUCHER")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Voucher implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID", unique = true, nullable = false)
    private String id;

    @Column(name = "TYPE", nullable = false)
    private String type;

    @Column(name = "LOCATION", nullable = false)
    private String location;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EXACT_VOUCHER_DATE")
    private Date exactVoucherDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ACTUAL_DATE", nullable = false)
    private Date actualDate;

    @Column(name = "DATE", nullable = false)
    private String date;

    @Column(name = "DAY", nullable = false)
    private String day;

    @Column(name = "HOUR", nullable = false)
    private String hour;

    @Column(name = "ADMIN", nullable = false)
    private boolean admin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID", nullable = false)
    private Employee employee;
}
