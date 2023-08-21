package com.lms.librarymanagementsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "downloads")
public class Downloads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "did")
    private Integer did;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "sid")
    private String sid;
    
    @Column(name = "downloaddate")
    private String downloaddate;

    public Downloads() {
    }

    public Downloads(Integer did, String username, String sid, String downloaddate) {
        this.did = did;
        this.username = username;
        this.sid = sid;
        this.downloaddate = downloaddate;
    }

    public Integer getDid() {
        return this.did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSid() {
        return this.sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getDownloaddate() {
        return this.downloaddate;
    }

    public void setDownloaddate(String downloaddate) {
        this.downloaddate = downloaddate;
    }


    @Override
    public String toString() {
        return "{" +
            " did='" + getDid() + "'" +
            ", username='" + getUsername() + "'" +
            ", sid='" + getSid() + "'" +
            ", downloaddate='" + getDownloaddate() + "'" +
            "}";
    }
}
