package com.d8games.web.services.model.dto;

@SuppressWarnings("unused")
public class DepartmentDto {

    private String id;
    private String name;
    private String managerId;

    public DepartmentDto() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }
}
