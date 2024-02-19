package com.example.mealregisterapp.bean;

public class ChefBean {

    private int chefID;
    private String username;

    private String name;
    private String surname;
    private String email;

    public ChefBean() {
    }
    public ChefBean(int chefID,  String name, String surname, String email) {
        this.chefID = chefID;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }


    public ChefBean(int chefID,  String name, String surname, String email,String username) {
        this.chefID = chefID;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public int getChefID() {
        return chefID;
    }

    public void setChefID(int chefID) {
        this.chefID = chefID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


