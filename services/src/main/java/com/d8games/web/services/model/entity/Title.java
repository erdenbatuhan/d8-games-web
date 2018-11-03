package com.d8games.web.services.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TITLE")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@SuppressWarnings("unused")
public class Title implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "TITLE_ID", unique = true, updatable = false, nullable = false)
    private String titleId;

    @Column(name = "TITLE_NAME", unique = true, nullable = false)
    private String titleName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TITLE_WORK_INFO_ID", referencedColumnName = "WORK_INFO_ID", nullable = false)
    private WorkInfo titleWorkInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TITLE_DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID", nullable = false)
    private Department titleDepartment;

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
