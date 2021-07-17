package com.example.springboottest.entity;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Timestamp;

public class BaseEntity<T> implements Serializable {

    @Column(name = "created_date")
    private Timestamp createdDate;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "modified_date")
    private Timestamp modifiedDate;
    @Column(name = "modified_by")
    private String modifiedBy;

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
