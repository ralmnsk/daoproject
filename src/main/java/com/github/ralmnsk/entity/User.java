package com.github.ralmnsk.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="usrtab")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="pass")
    private String pass;

    @Column(name="join_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date joinDate;

    @Column(name="role")
    private String role;

    @OneToMany //(mappedBy = "usrtab", cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="idusrtab")
    private List<UserNews> newsList=new ArrayList<UserNews>();


    public List<UserNews> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<UserNews> newsList) {
        this.newsList = newsList;
    }

    public boolean addNews(UserNews userNews) {
        if (newsList == null) {
            newsList = new ArrayList();
            newsList.add(userNews);
            return true;
        } else {
            if (newsList.contains(userNews)) {
                return false;
            }
        }
        newsList.add(userNews);
        return true;
    }

    public void removeUserNews(UserNews userNews){
        if ((getNewsList().size()>0)&&(getNewsList().contains(userNews))){
            getNewsList().remove(userNews);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String password) {
        this.pass = password;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date date) {
        this.joinDate = date;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(String name, String password, Date date, String role) {
        this.name = name;
        this.pass = password;
        this.joinDate = date;
        this.role = role;
    }

    public User(Long id,String name, String password, Date date, String role) {
        this.id=id;
        this.name = name;
        this.pass = password;
        this.joinDate = date;
        this.role = role;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", joinDate=" + joinDate +
                ", role='" + role + '\'' +
                '}';
    }
}
