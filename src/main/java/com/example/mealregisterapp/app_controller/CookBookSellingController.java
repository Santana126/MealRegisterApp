package com.example.mealregisterapp.app_controller;

import com.example.mealregisterapp.bean.ChefBean;
import com.example.mealregisterapp.bean.CookBookBean;
import com.example.mealregisterapp.dao.CookBookDAO;
import com.example.mealregisterapp.exception.LoadCookBookException;
import com.example.mealregisterapp.exception.UpdateCookBookStatusException;
import com.example.mealregisterapp.model.Recipe;
import com.example.mealregisterapp.observer.CookBookPublisher;

import java.util.List;

public class CookBookSellingController {


    public void insertCookBookInfo() {
        //Not Implemented Yed
    }

    public void publishCookBook() {
        //Not Implemented Yed
    }

    public void updateCookBook(Recipe recipe) {
        //Not Implemented Yed
    }


    public void saveRecipe() {
        //Not Implemented Yed
    }

    public void showCookBook() {
        //Not Implemented Yed
    }

    public void showCookBookList(Boolean suggested) {
        //Not Implemented Yed
    }

    public void sellCookBookToUser(List<CookBookBean> cookBookBeanList,int choice) throws UpdateCookBookStatusException {

        CookBookDAO cookBookDAO = new CookBookDAO();
        try {
            cookBookDAO.markCookBookAsSelling(cookBookBeanList.get(choice - 1));
        } catch (UpdateCookBookStatusException e) {
            throw new UpdateCookBookStatusException(e.getMessage());
        }

        CookBookPublisher cookBookPublisher = new CookBookPublisher();
        cookBookPublisher.notifySubscribers();
    }

    public void notifyInterestedUsers() {
        //Not Implemented Yed
    }

    public void notifyChef() {
        //Not Implemented Yed
    }

    public List<CookBookBean> takeCookBookList(ChefBean chefBean) throws LoadCookBookException {
        CookBookDAO cookBookDAO = new CookBookDAO();
        List<CookBookBean> cookBookBeanList = null;
        try {
            cookBookBeanList = cookBookDAO.loadAllCookBook(chefBean);
        } catch (LoadCookBookException e) {
            throw new LoadCookBookException(e.getMessage());
        }
        return cookBookBeanList;
    }
}
