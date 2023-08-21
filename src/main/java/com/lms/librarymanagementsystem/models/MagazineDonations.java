package com.lms.librarymanagementsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "magazinedonations")
public class MagazineDonations { // MAGAZINEDONATIONS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mdnid")
    private Integer mdnid;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "donorname", length = 100)
    private String donorname;

    @Column(name = "publisher", length = 500)
    private String publisher;

    @Column(name = "issuedate")
    private String issuedate;

    @Column(name = "issuenumber")
    private String issuenumber;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "thumbnail", length = 200)
    private String thumbnail;

    @Column(name = "frequency", length = 100)
    private String frequency;

    @Column(name = "keywords", columnDefinition = "LONGTEXT")
    private String keywords;

    @Column(name = "specialissue", length = 100)
    private String specialissue;

    @Column(name = "category", length = 100)
    private String category;

    @Column(name = "donationdate")
    private String donationdate;

    @Column(name = "approved", length = 100)
    private String approved;

    public MagazineDonations() {
    }

    public MagazineDonations(Integer mdnid, String title, String donorname, String publisher, String issuedate,
            String issuenumber, String description, String thumbnail, String frequency, String keywords,
            String specialissue, String category, String donationdate, String approved) {
        this.mdnid = mdnid;
        this.title = title;
        this.donorname = donorname;
        this.publisher = publisher;
        this.issuedate = issuedate;
        this.issuenumber = issuenumber;
        this.description = description;
        this.thumbnail = thumbnail;
        this.frequency = frequency;
        this.keywords = keywords;
        this.specialissue = specialissue;
        this.category = category;
        this.donationdate = donationdate;
        this.approved = approved;
    }

    public Integer getMdnid() {
        return this.mdnid;
    }

    public void setJdnid(Integer mdnid) {
        this.mdnid = mdnid;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDonorname() {
        return this.donorname;
    }

    public void setDonorname(String donorname) {
        this.donorname = donorname;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIssuedate() {
        return this.issuedate;
    }

    public void setIssuedate(String issuedate) {
        this.issuedate = issuedate;
    }

    public String getIssuenumber() {
        return this.issuenumber;
    }

    public void setIssuenumber(String issuenumber) {
        this.issuenumber = issuenumber;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getFrequency() {
        return this.frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getSpecialissue() {
        return this.specialissue;
    }

    public void setSpecialissue(String specialissue) {
        this.specialissue = specialissue;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDonationdate() {
        return this.donationdate;
    }

    public void setDonationdate(String donationdate) {
        this.donationdate = donationdate;
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
                " mdnid='" + getMdnid() + "'" +
                ", title='" + getTitle() + "'" +
                ", donorname='" + getDonorname() + "'" +
                ", publisher='" + getPublisher() + "'" +
                ", issuedate='" + getIssuedate() + "'" +
                ", issuenumber='" + getIssuenumber() + "'" +
                ", description='" + getDescription() + "'" +
                ", thumbnail='" + getThumbnail() + "'" +
                ", frequency='" + getFrequency() + "'" +
                ", keywords='" + getKeywords() + "'" +
                ", specialissue='" + getSpecialissue() + "'" +
                ", category='" + getCategory() + "'" +
                ", donationdate='" + getDonationdate() + "'" +
                ", approved='" + getApproved() + "'" +
                "}";
    }

}