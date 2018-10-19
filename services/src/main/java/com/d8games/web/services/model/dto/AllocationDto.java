package com.d8games.web.services.model.dto;

import java.util.Date;

@SuppressWarnings("unused")
public class AllocationDto {

    private String id;
    private Date date;
    private String type;
    private String userId;

    public AllocationDto() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
