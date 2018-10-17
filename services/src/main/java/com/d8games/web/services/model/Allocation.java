package com.d8games.web.services.model;

import com.d8games.web.services.exception.AllocationTypeMismatch;
import com.d8games.web.services.util.ProjectConstants;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ALLOCATION")
@EntityListeners(AuditingEntityListener.class)
public class Allocation implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID", unique = true, updatable = false, nullable = false)
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE", updatable = false, nullable = false)
    private Date date;

    @Column(name = "TYPE", updatable = false, nullable = false)
    private String type;

    @OneToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", updatable = false, nullable = false)
    private User user;

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

    public void setType(String type) throws AllocationTypeMismatch {
        if (type.equals(ProjectConstants.ALLOCATION_TYPE_IN) || type.equals(ProjectConstants.ALLOCATION_TYPE_OUT))
            this.type = type;
        else
            throw new AllocationTypeMismatch(type);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
