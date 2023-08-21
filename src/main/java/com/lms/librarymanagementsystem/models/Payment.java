package com.lms.librarymanagementsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "paydate")
    private String paydate;
    
    @Column(name = "amount")
    private Integer amount;
    
    @Column(name = "transaction")
    private String transaction;
    
    @Column(name = "approved")
    private String approved;

    @Column(name = "paid")
    private String paid;

    @Column(name = "type")
    private String type;


    public Payment() {
    }

    public Payment(Integer pid, String username, String paydate, Integer amount, String transaction, String approved, String paid, String type) {
        this.pid = pid;
        this.username = username;
        this.paydate = paydate;
        this.amount = amount;
        this.transaction = transaction;
        this.approved = approved;
        this.paid = paid;
        this.type = type;
    }

    public Integer getPid() {
        return this.pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPaydate() {
        return this.paydate;
    }

    public void setPaydate(String paydate) {
        this.paydate = paydate;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getTransaction() {
        return this.transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public String getApproved() {
        return this.approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getPaid() {
        return this.paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
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
            " pid='" + getPid() + "'" +
            ", username='" + getUsername() + "'" +
            ", paydate='" + getPaydate() + "'" +
            ", amount='" + getAmount() + "'" +
            ", transaction='" + getTransaction() + "'" +
            ", approved='" + getApproved() + "'" +
            ", paid='" + getPaid() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }


}
