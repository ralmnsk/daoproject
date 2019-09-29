package com.github.ralmnsk.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="newstab")
public class News implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idnews")
    private Long idNews;

    @Column(name="namenews")
    private String nameNews;

    @Column(name="datanews")
    private String dataNews;

    @Column(name="date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNews;

    @OneToOne
    @JoinColumn(name="idnews")
    private UserNews userNews;

    public Long getIdNews() {
        return idNews;
    }

    public void setIdNews(Long idNews) {
        this.idNews = idNews;
    }

    public String getNameNews() {
        return nameNews;
    }

    public void setNameNews(String nameNews) {
        this.nameNews = nameNews;
    }

    public String getDataNews() {
        return dataNews;
    }

    public void setDataNews(String dataNews) {
        this.dataNews = dataNews;
    }

    public Date getDateNews() {
        return dateNews;
    }

    public void setDateNews(Date dateNews) {
        this.dateNews = dateNews;
    }

    public News() {
    }

    public News(long idNews, String nameNews, String dataNews, Date dateNews) {
        this.idNews = idNews;
        this.nameNews = nameNews;
        this.dataNews = dataNews;
        this.dateNews = dateNews;
    }

    public News(String nameNews, String dataNews, Date dateNews) {
        this.nameNews = nameNews;
        this.dataNews = dataNews;
        this.dateNews = dateNews;
    }

    @Override
    public String toString() {
        return "News{" +
                "idNews=" + idNews +
                ", nameNews='" + nameNews + '\'' +
                ", dataNews='" + dataNews + '\'' +
                ", dateNews=" + dateNews +
                '}';
    }
}
