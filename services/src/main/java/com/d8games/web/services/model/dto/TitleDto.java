package com.d8games.web.services.model.dto;

import com.d8games.web.services.model.entity.Department;
import com.d8games.web.services.model.entity.WorkInfo;

@SuppressWarnings("unused")
public class TitleDto {

    private String titleId;
    private String titleName;
    private WorkInfo titleWorkInfo;
    private Department titleDepartment;

    public TitleDto(String titleId, String titleName, WorkInfo titleWorkInfo, Department titleDepartment) {
        this.titleId = titleId;
        this.titleName = titleName;
        this.titleWorkInfo = titleWorkInfo;
        this.titleDepartment = titleDepartment;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public WorkInfo getTitleWorkInfo() {
        return titleWorkInfo;
    }

    public void setTitleWorkInfo(WorkInfo titleWorkInfo) {
        this.titleWorkInfo = titleWorkInfo;
    }

    public Department getTitleDepartment() {
        return titleDepartment;
    }

    public void setTitleDepartment(Department titleDepartment) {
        this.titleDepartment = titleDepartment;
    }
}
