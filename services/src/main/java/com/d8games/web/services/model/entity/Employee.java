package com.d8games.web.services.model.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE")
@EntityListeners(AuditingEntityListener.class)
@SuppressWarnings("unused")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID", unique = true, updatable = false, nullable = false)
    private String id;

    @Column(name = "NAME", updatable = false, nullable = false)
    private String name;

    @Column(name = "SURNAME", updatable = false, nullable = false)
    private String surname;

    @Column(name = "PHOTO", nullable = false)
    private String photo;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "STARTING_DATE", updatable = false, nullable = false)
    private Date startingDate;

    @OneToOne
    @JoinColumn(name = "TITLE_ID", referencedColumnName = "ID", nullable = false)
    private Title title;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }
}
