package com.lms.librarymanagementsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "connector")
public class Connector {
    @Id
    @Column(name = "itid", length = 100)
    private String itid;

    @Column(name = "type", length = 100, nullable = false)
    private String type;

    public Connector() {
    }

    public Connector(String itid, String type) {
        this.itid = itid;
        this.type = type;
    }

    public String getItid() {
        return this.itid;
    }

    public void setItid(String itid) {
        this.itid = itid;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{" +
            " itid='" + getItid() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }

}
