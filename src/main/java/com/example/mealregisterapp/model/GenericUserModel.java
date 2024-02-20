package com.example.mealregisterapp.model;

public abstract class GenericUserModel {


    private int id;

    private int type;

    private String email;

    protected GenericUserModel(int id, int type, String email) {
        this.id = id;
        this.type = type;
        this.email = email;
    }

    protected GenericUserModel(int id, int type) {
        this.id = id;
        this.type = type;
    }

    protected GenericUserModel(int id, String email) {
        this.id = id;
        this.email = email;
    }

    protected GenericUserModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
