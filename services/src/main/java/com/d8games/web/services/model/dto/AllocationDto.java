package com.d8games.web.services.model.dto;

import com.d8games.web.services.model.entity.Employee;

import java.util.Date;

@SuppressWarnings("unused")
public class AllocationDto {

    private String allocationId;
    private Date allocationDate;
    private String allocationType;
    private Employee allocationEmployee;

    public AllocationDto(String allocationId, Date allocationDate, String allocationType, Employee allocationEmployee) {
        this.allocationId = allocationId;
        this.allocationDate = allocationDate;
        this.allocationType = allocationType;
        this.allocationEmployee = allocationEmployee;
    }

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

    public void setAllocationType(String allocationType) {
        this.allocationType = allocationType;
    }

    public Employee getAllocationEmployee() {
        return allocationEmployee;
    }

    public void setAllocationEmployee(Employee allocationEmployee) {
        this.allocationEmployee = allocationEmployee;
    }
}
