package com.lms.librarymanagementsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="journaldonations")
public class JournalDonations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jdnid")
    private Integer jdnid;

    @Column(name = "donorname", length = 100)
    private String donorname;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "publisher", length = 500)
    private String publisher;

    @Column(name = "editor", length = 500)
    private String editor;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "thumbnail", length = 200)
    private String thumbnail;

    @Column(name = "category", length = 100)
    private String category;

    @Column(name = "keywords", columnDefinition = "LONGTEXT")
    private String keywords;

    @Column(name = "startyear")
    private Integer startyear;

    @Column(name = "endyear")
    private Integer endyear;

    @Column(name = "pageno")
    private Integer pageno;

    @Column(name = "donationdate")
    private String donationdate;

    @Column(name = "approved", length = 100)
    private String approved;


    public JournalDonations() {
    }

    public JournalDonations(Integer jdnid, String donorname, String title, String publisher, String editor, String description, String thumbnail, String category, String keywords, Integer startyear, Integer endyear, Integer pageno, String donationdate, String approved) {
        this.jdnid = jdnid;
        this.donorname = donorname;
        this.title = title;
        this.publisher = publisher;
        this.editor = editor;
        this.description = description;
        this.thumbnail = thumbnail;
        this.category = category;
        this.keywords = keywords;
        this.startyear = startyear;
        this.endyear = endyear;
        this.pageno = pageno;
        this.donationdate = donationdate;
        this.approved = approved;
    }

    public Integer getJdnid() {
        return this.jdnid;
    }

    public void setJdnid(Integer jdnid) {
        this.jdnid = jdnid;
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

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getEditor() {
        return this.editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
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

    public Integer getStartyear() {
        return this.startyear;
    }

    public void setStartyear(Integer startyear) {
        this.startyear = startyear;
    }

    public Integer getEndyear() {
        return this.endyear;
    }

    public void setEndyear(Integer endyear) {
        this.endyear = endyear;
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
            " jdnid='" + getJdnid() + "'" +
            ", donorname='" + getDonorname() + "'" +
            ", title='" + getTitle() + "'" +
            ", publisher='" + getPublisher() + "'" +
            ", editor='" + getEditor() + "'" +
            ", description='" + getDescription() + "'" +
            ", thumbnail='" + getThumbnail() + "'" +
            ", category='" + getCategory() + "'" +
            ", keywords='" + getKeywords() + "'" +
            ", startyear='" + getStartyear() + "'" +
            ", endyear='" + getEndyear() + "'" +
            ", pageno='" + getPageno() + "'" +
            ", donationdate='" + getDonationdate() + "'" +
            ", approved='" + getApproved() + "'" +
            "}";
    }
    
}