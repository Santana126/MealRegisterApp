package com.example.mealregisterapp.session;

import com.example.mealregisterapp.bean.ChefBean;
import com.example.mealregisterapp.bean.UserBean;


public class Session {

    private static Session sessionInstance = null;

    private UserBean userBean;

    private ChefBean chefBean;


    private Session(Object ob) {
        if(ob instanceof UserBean) {
            this.userBean = (UserBean) ob;
        }
        else if(ob instanceof ChefBean) {
            chefBean = (ChefBean) ob;
        }
    }


    public static void setSessionInstance(Object ob) {
        if(sessionInstance == null)
            sessionInstance = new Session(ob);
    }



    public static void closeSession() {
        sessionInstance = null;
    }

    public static Session getCurrentSession() {
        return sessionInstance;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public ChefBean getShelterBean() {
        return chefBean;
    }

}
