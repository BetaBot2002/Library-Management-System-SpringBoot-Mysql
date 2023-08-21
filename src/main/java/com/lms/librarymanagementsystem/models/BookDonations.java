package com.lms.librarymanagementsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookdonations")
public class BookDonations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bdnid")
    private Integer bdnid;

    @Column(name = "donorname", nullable = true)
    private String donorname;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "publisher", nullable = false)
    private String publisher;

    @Column(name = "thumbnail", nullable = true)
    private String thumbnail;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "keywords")
    private String keywords;

    @Column(name = "edition")
    private String edition;

    @Column(name = "pageno")
    private Integer pageno;

    @Column(name = "donationdate")
    private String donationdate;

    @Column(name = "approved", nullable = true)
    private String approved;

    public BookDonations() {
    }

    public BookDonations(Integer bdnid, String donorname, String title, String author, String publisher, String thumbnail, String description, String category, String keywords, String edition, Integer pageno, String donationdate, String approved) {
        this.bdnid = bdnid;
        this.donorname = donorname;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.thumbnail = thumbnail;
        this.description = description;
        this.category = category;
        this.keywords = keywords;
        this.edition = edition;
        this.pageno = pageno;
        this.donationdate = donationdate;
        this.approved = approved;
    }

    public Integer getBdnid() {
        return this.bdnid;
    }

    public void setBdnid(Integer bdnid) {
        this.bdnid = bdnid;
    }

    public String getDonorname() {
        return this.donorname;
    }

    public void setDonorname(String donorname) {
        this.donorname = donorname;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getEdition() {
        return this.edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Integer getPageno() {
        return this.pageno;
    }

    public void setPageno(Integer pageno) {
        this.pageno = pageno;
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
            " bdnid='" + getBdnid() + "'" +
            ", donorname='" + getDonorname() + "'" +
            ", title='" + getTitle() + "'" +
            ", author='" + getAuthor() + "'" +
            ", publisher='" + getPublisher() + "'" +
            ", thumbnail='" + getThumbnail() + "'" +
            ", description='" + getDescription() + "'" +
            ", category='" + getCategory() + "'" +
            ", keywords='" + getKeywords() + "'" +
            ", edition='" + getEdition() + "'" +
            ", pageno='" + getPageno() + "'" +
            ", donationdate='" + getDonationdate() + "'" +
            ", approved='" + getApproved() + "'" +
            "}";
    }
}
