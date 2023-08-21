package com.lms.librarymanagementsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "thesesdonations")
public class ThesesDonations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tdnid")
    private Integer tdnid;

    @Column(name = "donorname", nullable = true)
    private String donorname;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "researcher", nullable = false)
    private String researcher;

    @Column(name = "guides", nullable = false)
    private String guides;

    @Column(name = "description")
    private String description;

    @Column(name = "thumbnail", nullable = true)
    private String thumbnail;

    @Column(name = "category")
    private String category;

    @Column(name = "keywords")
    private String keywords;

    @Column(name = "completeddate")
    private String completeddate;

    @Column(name = "place")
    private String place;

    @Column(name = "abstract")
    private String abstractcontent;

    @Column(name = "pageno")
    private Integer pageno;

    @Column(name = "donationdate")
    private String donationdate;

    @Column(name = "approved")
    private String approved;

    public ThesesDonations() {
    }

    public ThesesDonations(Integer tdnid, String donorname, String title, String researcher, String guides,
            String description, String thumbnail, String category, String keywords, String completeddate, String place,
            String abstractcontent, Integer pageno, String donationdate, String approved) {
        this.tdnid = tdnid;
        this.donorname = donorname;
        this.title = title;
        this.researcher = researcher;
        this.guides = guides;
        this.description = description;
        this.thumbnail = thumbnail;
        this.category = category;
        this.keywords = keywords;
        this.completeddate = completeddate;
        this.place = place;
        this.abstractcontent = abstractcontent;
        this.pageno = pageno;
        this.donationdate = donationdate;
        this.approved = approved;
    }

    public Integer getTdnid() {
        return this.tdnid;
    }

    public void setTdnid(Integer tdnid) {
        this.tdnid = tdnid;
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

    public String getCompleteddate() {
        return this.completeddate;
    }

    public void setCompleteddate(String completeddate) {
        this.completeddate = completeddate;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAbstractcontent() {
        return this.abstractcontent;
    }

    public void setAbstractcontent(String abstractcontent) {
        this.abstractcontent = abstractcontent;
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
                " tdnid='" + getTdnid() + "'" +
                ", donorname='" + getDonorname() + "'" +
                ", title='" + getTitle() + "'" +
                ", researcher='" + getResearcher() + "'" +
                ", guides='" + getGuides() + "'" +
                ", description='" + getDescription() + "'" +
                ", thumbnail='" + getThumbnail() + "'" +
                ", category='" + getCategory() + "'" +
                ", keywords='" + getKeywords() + "'" +
                ", completeddate='" + getCompleteddate() + "'" +
                ", place='" + getPlace() + "'" +
                ", abstractcontent='" + getAbstractcontent() + "'" +
                ", pageno='" + getPageno() + "'" +
                ", donationdate='" + getDonationdate() + "'" +
                ", approved='" + getApproved() + "'" +
                "}";
    }

}
