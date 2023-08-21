package com.lms.librarymanagementsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="softcopy")
public class SoftCopy {
    @Id
    private String sid;

    @Column(name="title")
    private String title;

    @Column(name="owner")
    private String owner;

    @Column(name="publisher")
    private String publisher;

    @Column(name="description")
    private String description;

    @Column(name = "thumbnail", length = 200,nullable = true)
    private String thumbnail;

    @Column(name="category")
    private String category;

    @Column(name="keywords")
    private String keywords;

    @Column(name="pageno")
    private Integer pageno;

    @Column(name="filename")
    private String filename;

    public SoftCopy() {
    }

    public SoftCopy(String sid, String title, String owner, String publisher, String description, String thumbnail, String category, String keywords, Integer pageno, String filename) {
        this.sid = sid;
        this.title = title;
        this.owner = owner;
        this.publisher = publisher;
        this.description = description;
        this.thumbnail = thumbnail;
        this.category = category;
        this.keywords = keywords;
        this.pageno = pageno;
        this.filename = filename;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }


    public String getSid() {
        return this.sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
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

    public Integer getPageno() {
        return this.pageno;
    }

    public void setPageno(Integer pageno) {
        this.pageno = pageno;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }


    @Override
    public String toString() {
        return "{" +
            " sid='" + getSid() + "'" +
            ", title='" + getTitle() + "'" +
            ", owner='" + getOwner() + "'" +
            ", publisher='" + getPublisher() + "'" +
            ", description='" + getDescription() + "'" +
            ", thumbnail='" + getThumbnail() + "'" +
            ", category='" + getCategory() + "'" +
            ", keywords='" + getKeywords() + "'" +
            ", pageno='" + getPageno() + "'" +
            ", filename='" + getFilename() + "'" +
            "}";
    }

}
