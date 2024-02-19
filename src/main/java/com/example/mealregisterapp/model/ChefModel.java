package com.example.mealregisterapp.model;

public class ChefModel extends GenericUserModel {

    private String name;

    private String surname;

    private String username;

    private String website;

    public ChefModel(int id, String email, String name, String surname) {
        super(id, 1, email);
        this.name = name;
        this.surname = surname;
    }

    public ChefModel(int id, String email, String name, String surname, String website) {
        super(id, 1, email);
        this.name = name;
        this.surname = surname;
        this.website = website;
    }


    public ChefModel(int id, String email, String name, String surname, String website, String username) {
        super(id, 1, email);
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.website = website;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
