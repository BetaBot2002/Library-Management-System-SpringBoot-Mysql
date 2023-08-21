package com.lms.librarymanagementsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Borrow")
public class Borrow {
    @Id
    @Column(name = "BRID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer brid;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "ITID")
    private String itid;

    @Column(name = "BORROWDATE")
    private String borrowDate;

    @Column(name = "RETURNDATE")
    private String returnDate;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "APPROVED")
    private String approved;

    public Borrow() {
    }

    public Borrow(Integer brid, String username, String itid, String borrowDate, String returnDate, String status, String approved) {
        this.brid = brid;
        this.username = username;
        this.itid = itid;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
        this.approved = approved;
    }

    public Integer getBrid() {
        return this.brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getitid() {
        return this.itid;
    }

    public void setitid(String itid) {
        this.itid = itid;
    }

    public String getBorrowDate() {
        return this.borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return this.returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApproved() {
        return this.approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    @Override
    public String toString() {
        return "{" +
            " brid='" + getBrid() + "'" +
            ", username='" + getUsername() + "'" +
            ", itid='" + getitid() + "'" +
            ", borrowDate='" + getBorrowDate() + "'" +
            ", returnDate='" + getReturnDate() + "'" +
            ", status='" + getStatus() + "'" +
            ", approved='" + getApproved() + "'" +
            "}";
    }
}
