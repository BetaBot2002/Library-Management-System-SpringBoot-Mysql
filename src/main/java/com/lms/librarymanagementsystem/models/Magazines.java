package com.lms.librarymanagementsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "magazines")
public class Magazines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mid")
    private Integer mid;

    @Column(name = "itid")
    private String itid;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "publisher", nullable = false)
    private String publisher;

    @Column(name = "issuedate")
    private String issuedate;

    @Column(name = "issuenumber")
    private String issuenumber;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "thumbnail", length = 200,nullable = true)
    private String thumbnail;

    @Column(name = "frequency")
    private String frequency;

    @Column(name = "keywords", columnDefinition = "LONGTEXT")
    private String keywords;

    @Column(name = "specialissue")
    private String specialissue;

    @Column(name = "category")
    private String category;

    @Column(name = "stock")
    private Integer stock;

    public Magazines() {
    }

    public Magazines(Integer mid, String itid, String title, String publisher, String issuedate, String issuenumber, String description, String thumbnail, String frequency, String keywords, String specialissue, String category, Integer stock) {
        this.mid = mid;
        this.itid = itid;
        this.title = title;
        this.publisher = publisher;
        this.issuedate = issuedate;
        this.issuenumber = issuenumber;
        this.description = description;
        this.thumbnail = thumbnail;
        this.frequency = frequency;
        this.keywords = keywords;
        this.specialissue = specialissue;
        this.category = category;
        this.stock = stock;
    }


    public String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getMid() {
        return this.mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getItid() {
        return this.itid;
    }

    public void setItid(String itid) {
        this.itid = itid;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getStock() {
        return this.stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "{" +
            " mid='" + getMid() + "'" +
            ", itid='" + getItid() + "'" +
            ", title='" + getTitle() + "'" +
            ", publisher='" + getPublisher() + "'" +
            ", issuedate='" + getIssuedate() + "'" +
            ", issuenumber='" + getIssuenumber() + "'" +
            ", description='" + getDescription() + "'" +
            ", frequency='" + getFrequency() + "'" +
            ", keywords='" + getKeywords() + "'" +
            ", specialissue='" + getSpecialissue() + "'" +
            ", category='" + getCategory() + "'" +
            ", stock='" + getStock() + "'" +
            "}";
    }

}
