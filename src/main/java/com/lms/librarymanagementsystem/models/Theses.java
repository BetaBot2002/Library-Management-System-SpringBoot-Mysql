package com.lms.librarymanagementsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="theses")
public class Theses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid")
    private Integer tid;

    @Column(name = "itid")
    private String itid;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "researcher", nullable = false)
    private String researcher;

    @Column(name = "guides", nullable = false)
    private String guides;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "thumbnail", length = 200,nullable = true)
    private String thumbnail;

    @Column(name = "category")
    private String category;

    @Column(name = "keywords", columnDefinition = "LONGTEXT")
    private String keywords;

    @Column(name = "completeddate")
    private String completedDate;

    @Column(name = "place")
    private String place;

    @Column(name = "abstract", columnDefinition = "TEXT")
    private String abstractContent;

    @Column(name = "pageno")
    private Integer pageNo;

    @Column(name = "stock")
    private Integer stock;

    public Theses() {
    }

    public Theses(Integer tid, String itid, String title, String researcher, String guides, String description, String thumbnail, String category, String keywords, String completedDate, String place, String abstractContent, Integer pageNo, Integer stock) {
        this.tid = tid;
        this.itid = itid;
        this.title = title;
        this.researcher = researcher;
        this.guides = guides;
        this.description = description;
        this.thumbnail = thumbnail;
        this.category = category;
        this.keywords = keywords;
        this.completedDate = completedDate;
        this.place = place;
        this.abstractContent = abstractContent;
        this.pageNo = pageNo;
        this.stock = stock;
    }


    public String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getTid() {
        return this.tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
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

    public String getResearcher() {
        return this.researcher;
    }

    public void setResearcher(String researcher) {
        this.researcher = researcher;
    }

    public String getGuides() {
        return this.guides;
    }

    public void setGuides(String guides) {
        this.guides = guides;
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

    public String getCompletedDate() {
        return this.completedDate;
    }

    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAbstractContent() {
        return this.abstractContent;
    }

    public void setAbstractContent(String abstractContent) {
        this.abstractContent = abstractContent;
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
            " tid='" + getTid() + "'" +
            ", itid='" + getItid() + "'" +
            ", title='" + getTitle() + "'" +
            ", researcher='" + getResearcher() + "'" +
            ", guides='" + getGuides() + "'" +
            ", description='" + getDescription() + "'" +
            ", category='" + getCategory() + "'" +
            ", keywords='" + getKeywords() + "'" +
            ", completedDate='" + getCompletedDate() + "'" +
            ", place='" + getPlace() + "'" +
            ", abstractContent='" + getAbstractContent() + "'" +
            ", pageNo='" + getPageNo() + "'" +
            ", stock='" + getStock() + "'" +
            "}";
    }


}
