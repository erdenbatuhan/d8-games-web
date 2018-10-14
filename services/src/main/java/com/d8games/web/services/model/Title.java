package com.d8games.web.services.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "title")
@EntityListeners(AuditingEntityListener.class)
public class Title implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "title_id")
    private Long titleId;

    @NotBlank
    private String titleName;

    @NotBlank
    private String titleWage;

    @OneToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    private Department department;

    public Long getTitleId() {
        return titleId;
    }

    public void setTitleId(Long titleId) {
        this.titleId = titleId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getTitleWage() {
        return titleWage;
    }

    public void setTitleWage(String titleWage) {
        this.titleWage = titleWage;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
