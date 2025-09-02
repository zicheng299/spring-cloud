package com.demo.provider.entity;

import lombok.Data;

import java.io.Serializable;

public class Book  implements Serializable {

    private String bid;

    private String title;

    private String author;

    public Book(String bid, String title, String author) {
        this.bid = bid;
        this.title = title;
        this.author = author;
    }

    public Book() {
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
