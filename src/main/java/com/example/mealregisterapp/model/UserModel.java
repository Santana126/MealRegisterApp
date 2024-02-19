package com.example.mealregisterapp.model;

public class UserModel extends GenericUserModel{

    private String username;

    public UserModel(int id, String email, String username) {
        super(id, 0, email);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
