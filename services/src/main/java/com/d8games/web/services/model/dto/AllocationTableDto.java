package com.d8games.web.services.model.dto;

@SuppressWarnings("unused")
public class AllocationTableDto {

    private String allocationDate;
    private String allocationDay;
    private String allocationHour;
    private String allocationType;
    private String allocationLocation;

    public AllocationTableDto(String allocationDate, String allocationDay, String allocationHour,
                              String allocationType, String allocationLocation) {
        this.allocationDate = allocationDate;
        this.allocationDay = allocationDay;
        this.allocationHour = allocationHour;
        this.allocationType = allocationType;
        this.allocationLocation = allocationLocation;
    }

    public String getAllocationDate() {
        return allocationDate;
    }

    public void setAllocationDate(String allocationDate) {
        this.allocationDate = allocationDate;
    }

    public String getAllocationDay() {
        return allocationDay;
    }

    public void setAllocationDay(String allocationDay) {
        this.allocationDay = allocationDay;
    }

    public String getAllocationHour() {
        return allocationHour;
    }

    public void setAllocationHour(String allocationHour) {
        this.allocationHour = allocationHour;
    }

    public String getAllocationType() {
        return allocationType;
    }

    public void setAllocationType(String allocationType) {
        this.allocationType = allocationType;
    }

    public String getAllocationLocation() {
        return allocationLocation;
    }

    public void setAllocationLocation(String allocationLocation) {
        this.allocationLocation = allocationLocation;
    }
}
