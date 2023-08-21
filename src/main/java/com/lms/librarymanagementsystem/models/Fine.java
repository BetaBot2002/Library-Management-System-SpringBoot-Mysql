package com.lms.librarymanagementsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="fine")
public class Fine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fid;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "finedate")
    private String fineDate;
    
    @Column(name = "amount")
    private Integer amount;

    @Column(name = "paid")
    private String paid;

    public Fine() {
    }

    public Fine(Integer fid, String username, String fineDate, Integer amount,String paid) {
        this.fid = fid;
        this.username = username;
        this.fineDate = fineDate;
        this.amount = amount;
        this.paid = paid;
    }

    public Integer getFid() {
        return this.fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFineDate() {
        return this.fineDate;
    }

    public void setFineDate(String fineDate) {
        this.fineDate = fineDate;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getPaid() {
        return this.paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }


    @Override
    public String toString() {
        return "{" +
            " fid='" + getFid() + "'" +
            ", username='" + getUsername() + "'" +
            ", fineDate='" + getFineDate() + "'" +
            ", amount='" + getAmount() + "'" +
            ", paid='" + getPaid() + "'" +
            "}";
    }

}
