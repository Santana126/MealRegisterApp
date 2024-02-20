package com.example.mealregisterapp.bean;

public class CookBookBean {

    private String author;

    private int difficult;

    public CookBookBean(){}

    public CookBookBean(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }
}
