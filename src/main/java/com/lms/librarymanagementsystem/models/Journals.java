package com.lms.librarymanagementsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="journals")
public class Journals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jid")
    private Integer jid;

    @Column(name = "itid", nullable = false)
    private String itid;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "publisher", nullable = false)
    private String publisher;

    @Column(name = "editor")
    private String editor;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "thumbnail", length = 200,nullable = true)
    private String thumbnail;

    @Column(name = "category")
    private String category;

    @Column(name = "keywords", columnDefinition = "LONGTEXT")
    private String keywords;

    @Column(name = "startyear")
    private Integer startYear;

    @Column(name = "endyear")
    private Integer endYear;

    @Column(name = "pageno")
    private Integer pageNo;

    @Column(name = "stock")
    private Integer stock;

    public Journals() {
    }


    public Journals(Integer jid, String itid, String title, String publisher, String editor, String description, String thumbnail, String category, String keywords, Integer startYear, Integer endYear, Integer pageNo, Integer stock) {
        this.jid = jid;
        this.itid = itid;
        this.title = title;
        this.publisher = publisher;
        this.editor = editor;
        this.description = description;
        this.thumbnail = thumbnail;
        this.category = category;
        this.keywords = keywords;
        this.startYear = startYear;
        this.endYear = endYear;
        this.pageNo = pageNo;
        this.stock = stock;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getJid() {
        return this.jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
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

    public Integer getStartYear() {
        return this.startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return this.endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public Integer getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
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
            " jid='" + getJid() + "'" +
            ", itid='" + getItid() + "'" +
            ", title='" + getTitle() + "'" +
            ", publisher='" + getPublisher() + "'" +
            ", editor='" + getEditor() + "'" +
            ", description='" + getDescription() + "'" +
            ", category='" + getCategory() + "'" +
            ", keywords='" + getKeywords() + "'" +
            ", startYear='" + getStartYear() + "'" +
            ", endYear='" + getEndYear() + "'" +
            ", pageNo='" + getPageNo() + "'" +
            ", stock='" + getStock() + "'" +
            "}";
    }

}
