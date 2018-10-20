package com.d8games.web.services.model.dto;

import com.d8games.web.services.model.entity.Department;

@SuppressWarnings("unused")
public class DepartmentDto {

    private String departmentId;
    private Department departmentManager;

    public DepartmentDto(String departmentId, Department departmentManager) {
        this.departmentId = departmentId;
        this.departmentManager = departmentManager;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Department getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(Department departmentManager) {
        this.departmentManager = departmentManager;
    }
}
