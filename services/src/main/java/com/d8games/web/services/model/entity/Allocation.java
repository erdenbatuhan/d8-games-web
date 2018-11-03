package com.d8games.web.services.model.entity;

import com.d8games.web.services.exception.AllocationTypeMismatch;
import com.d8games.web.services.util.ProjectConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ALLOCATION")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@SuppressWarnings("unused")
public class Allocation implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ALLOCATION_ID", unique = true, nullable = false)
    private String allocationId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ALLOCATION_DATE", nullable = false)
    private Date allocationDate;

    @Column(name = "ALLOCATION_TYPE", nullable = false)
    private String allocationType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ALLOCATION_EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID", nullable = false)
    private Employee allocationEmployee;

    public String getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(String allocationId) {
        this.allocationId = allocationId;
    }

    public Date getAllocationDate() {
        return allocationDate;
    }

    public void setAllocationDate(Date allocationDate) {
        this.allocationDate = allocationDate;
    }

    public String getAllocationType() {
        return allocationType;
    }

    public void setAllocationType(String allocationType) throws AllocationTypeMismatch {
        if (allocationType.equals(ProjectConstants.ALLOCATION_TYPE_IN) || allocationType.equals(ProjectConstants.ALLOCATION_TYPE_OUT))
            this.allocationType = allocationType;
        else
            throw new AllocationTypeMismatch(allocationType);
    }

    public Employee getAllocationEmployee() {
        return allocationEmployee;
    }

    public void setAllocationEmployee(Employee allocationEmployee) {
        this.allocationEmployee = allocationEmployee;
    }
}
