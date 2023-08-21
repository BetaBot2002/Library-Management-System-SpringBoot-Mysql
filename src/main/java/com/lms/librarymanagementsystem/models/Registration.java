package com.lms.librarymanagementsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="registration")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RSID")
    private Integer rsid;

    @Column(name = "USERNAME", length = 100)
    private String username;

    @Column(name = "PASSWORD", length = 100)
    private String password;

    @Column(name = "PROFILEPICTURE", length = 100)
    private String profilePicture;

    @Column(name = "FIRSTNAME", length = 100)
    private String firstName;

    @Column(name = "LASTNAME", length = 100)
    private String lastName;

    @Column(name = "GENDER", length = 100)
    private String gender;

    @Column(name = "DOB", length = 100)
    private String dob;

    @Column(name = "PHONE", length = 100)
    private String phone;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "CATEGORY", length = 100)
    private String category;

    @Column(name = "PAID", length = 100)
    private String paid;

    @Column(name = "TRANSACTION", length = 100)
    private String transaction;

    @Column(name = "APPROVED", length = 100)
    private String approved;

    public Registration() {
    }

    public Registration(Integer rsid, String username, String password, String profilePicture, String firstName, String lastName, String gender, String dob, String phone, String email, String category, String paid, String transaction, String approved) {
        this.rsid = rsid;
        this.username = username;
        this.password = password;
        this.profilePicture = profilePicture;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.category = category;
        this.paid = paid;
        this.transaction = transaction;
        this.approved = approved;
    }

    public Integer getRsid() {
        return this.rsid;
    }

    public void setRsid(Integer rsid) {
        this.rsid = rsid;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicture() {
        return this.profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPaid() {
        return this.paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
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


    @Override
    public String toString() {
        return "{" +
            " rsid='" + getRsid() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", profilePicture='" + getProfilePicture() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", gender='" + getGender() + "'" +
            ", dob='" + getDob() + "'" +
            ", phone='" + getPhone() + "'" +
            ", email='" + getEmail() + "'" +
            ", category='" + getCategory() + "'" +
            ", paid='" + getPaid() + "'" +
            ", transaction='" + getTransaction() + "'" +
            ", approved='" + getApproved() + "'" +
            "}";
    }

}
