package com.example.mealregisterapp.session;

import com.example.mealregisterapp.bean.ChefBean;
import com.example.mealregisterapp.bean.CookBookBean;
import com.example.mealregisterapp.bean.RecipeBean;
import com.example.mealregisterapp.bean.UserBean;


public class Session {

    private static Session sessionInstance = null;

    private UserBean userBean;

    private ChefBean chefBean;


    private CookBookBean cookBookBean = null;

    private RecipeBean recipeBean = null;

    private int type; //1 User; 2 Chef

    private Session(Object ob) {
        if(ob instanceof UserBean) {
            this.userBean = (UserBean) ob;
            this.type = 1;
        }
        else if(ob instanceof ChefBean) {
            this.type = 2;
            this.chefBean = (ChefBean) ob;
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

    public ChefBean getChefBean() {
        return chefBean;
    }

    public int getType() {
        return type;
    }

    public boolean existCookBookBean(){
        return (this.cookBookBean != null);
    }

    public CookBookBean getCookBookBean() {
        if(this.cookBookBean == null){
            this.cookBookBean = new CookBookBean();
        }
        return cookBookBean;
    }


    public void resetCookBookBean(){
        this.cookBookBean = null;
    }

    public void setCookBookBean(CookBookBean cookBookBean) {
        this.cookBookBean = cookBookBean;
    }

    public RecipeBean getRecipeBean(){
        if(this.recipeBean == null){
            this.recipeBean = new RecipeBean();
        }
        return recipeBean;
    }

    public void setRecipeBean(RecipeBean recipeBean){
        this.recipeBean = recipeBean;
    }

}
