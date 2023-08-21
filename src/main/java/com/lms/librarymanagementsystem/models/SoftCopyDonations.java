package com.lms.librarymanagementsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "softcopydonations")
public class SoftCopyDonations {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sdnid")
    private Long sdnid;

    @Column(name = "donorname", length = 100)
    private String donorName;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "owner", length = 100)
    private String owner;

    @Column(name = "publisher", length = 100)
    private String publisher;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "thumbnail", length = 200)
    private String thumbnail;

    @Column(name = "category", length = 100)
    private String category;

    @Column(name = "keywords", columnDefinition = "LONGTEXT")
    private String keywords;

    @Column(name = "pageno")
    private Integer pageNo;

    @Column(name = "filename", length = 100)
    private String fileName;

    @Column(name = "donationdate")
    private String donationDate;

    @Column(name = "approved", length = 100)
    private String approved;
    
    public SoftCopyDonations() {
    }

    public SoftCopyDonations(Long sdnid, String donorName, String title, String owner, String publisher, String description, String thumbnail, String category, String keywords, Integer pageNo, String fileName, String donationDate, String approved) {
        this.sdnid = sdnid;
        this.donorName = donorName;
        this.title = title;
        this.owner = owner;
        this.publisher = publisher;
        this.description = description;
        this.thumbnail = thumbnail;
        this.category = category;
        this.keywords = keywords;
        this.pageNo = pageNo;
        this.fileName = fileName;
        this.donationDate = donationDate;
        this.approved = approved;
    }

    public Long getSdnid() {
        return this.sdnid;
    }

    public void setSdnid(Long sdnid) {
        this.sdnid = sdnid;
    }

    public String getDonorName() {
        return this.donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDonationDate() {
        return this.donationDate;
    }

    public void setDonationDate(String donationDate) {
        this.donationDate = donationDate;
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
            " sdnid='" + getSdnid() + "'" +
            ", donorName='" + getDonorName() + "'" +
            ", title='" + getTitle() + "'" +
            ", owner='" + getOwner() + "'" +
            ", publisher='" + getPublisher() + "'" +
            ", description='" + getDescription() + "'" +
            ", thumbnail='" + getThumbnail() + "'" +
            ", category='" + getCategory() + "'" +
            ", keywords='" + getKeywords() + "'" +
            ", pageNo='" + getPageNo() + "'" +
            ", fileName='" + getFileName() + "'" +
            ", donationDate='" + getDonationDate() + "'" +
            ", approved='" + getApproved() + "'" +
            "}";
    }
}

