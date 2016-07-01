package com.hib.entities;

import javax.persistence.*;

@Entity
@Table(name = "guestbook")
public class GuestBook {

    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "date")
    private String date;

    @Column(name = "name")
    private String name;

    @Column(name = "text")
    private String text;

    public GuestBook() {
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GuestBook(String name, String date, String text) {
        this.date = date;
        this.name = name;
        this.text = text;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
