package com.lms.librarymanagementsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="alternative")
public class Alternative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AID")
    private Integer aid;

    @Column(name = "ITID", nullable = false)
    private String itid;

    @Column(name = "SID")
    private String sid;

    public Alternative() {
    }

    public Alternative(Integer aid, String itid, String sid) {
        this.aid = aid;
        this.itid = itid;
        this.sid = sid;
    }

    public Integer getAid() {
        return this.aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getItid() {
        return this.itid;
    }

    public void setItid(String itid) {
        this.itid = itid;
    }

    public String getSid() {
        return this.sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "{" +
            " aid='" + getAid() + "'" +
            ", itid='" + getItid() + "'" +
            ", sid='" + getSid() + "'" +
            "}";
    }
}
