package com.github.ralmnsk.entity;


import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="usrnews")
public class UserNews implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idusrnews")
    private Long idUsrNews;

    @Column(name="idusrtab")
    private Long idUsr;

    @Column(name="idnews",insertable = false,updatable = false)
    //@OneToOne(mappedBy="usrnews", cascade=CascadeType.ALL)
    private Long idNews;

    @OneToOne
    @JoinColumn(name="idnews")
    private News news;

    @ManyToOne
    @JoinColumn(name="idusrtab",insertable = false,updatable = false)
    private User user;

    public Long getIdUsrNews() {
        return idUsrNews;
    }

    public void setIdUsrNews(Long idUsrNews) {
        this.idUsrNews = idUsrNews;
    }

    public Long getIdUsr() {
        return idUsr;
    }

    public void setIdUsr(Long idUsr) {
        this.idUsr = idUsr;
    }

    public Long getIdNews() {
        return idNews;
    }

    public void setIdNews(Long idNews) {
        this.idNews = idNews;
    }

    public UserNews(Long idUsr, Long idNews) {
        this.idUsr = idUsr;
        this.idNews = idNews;
    }

    public UserNews() {
    }

    public UserNews(Long idUsrNews, Long idUsr, Long idNews) {
        this.idUsrNews = idUsrNews;
        this.idUsr = idUsr;
        this.idNews = idNews;
    }
}
