package com.example.mealregisterapp.model;

import com.example.mealregisterapp.bean.ChefBean;

public class Chef {

    private int chefID;
    private String username;
    private String name;
    private String surname;
    private String email;
    private Tags[] tags;

    public Chef(ChefBean chefBean) {
        this.chefID = chefBean.getChefID();
        this.username = chefBean.getUsername();
        this.name = chefBean.getName();
        this.surname = chefBean.getSurname();
        this.email = chefBean.getEmail();
    }

    public Chef(int chefID, String name, String surname, String email) {
        this.chefID = chefID;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public int getChefID() {
        return chefID;
    }

}
