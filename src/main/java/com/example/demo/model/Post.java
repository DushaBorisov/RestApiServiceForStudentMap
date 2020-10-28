package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "posts")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Post {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "login")
    private String login;

    @Column(name = "date")
    private String date;

    @Column(name = "location")
    private String location;

    @Column(name = "text")
    private String text;

    @Column(name = "img")
    private String img;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getText() {
        return text;
    }

    public String getImg() {
        return img;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
