package com.example.mealregisterapp.app_controller;

import com.example.mealregisterapp.bean.CookBookBean;
import com.example.mealregisterapp.bean.RecipeBean;
import com.example.mealregisterapp.dao.CookBookDAO;
import com.example.mealregisterapp.dao.RecipeDAO;
import com.example.mealregisterapp.exception.RecipeDaoException;
import com.example.mealregisterapp.exception.SaveCookBookException;
import com.example.mealregisterapp.model.CookBook;
import com.example.mealregisterapp.session.Session;

import java.util.List;

public class CookBookMakerControllerApp {


    public void createNewCookBook(CookBookBean cookBookBean) {

        Session.getCurrentSession().setCookBookBean(cookBookBean);
    }

    public CookBookBean takeCookBookResume() {
        return Session.getCurrentSession().getCookBookBean();
    }


    public void insertRecipeIntoCookBook(List<RecipeBean> selectedRecipeList) {
        Session.getCurrentSession().addRecipeListToCurrentCookBook(selectedRecipeList);
    }

    public void insertRecipeIntoCookBook(List<RecipeBean> selectedRecipeList,CookBookBean cookBookBean) {

        cookBookBean.addRecipeList(selectedRecipeList);
    }

    public List<RecipeBean> takeRecipeList() throws RecipeDaoException {
        RecipeDAO recipeDAO = new RecipeDAO();
        List<RecipeBean> recipeBeanList;
        try {
            recipeBeanList = recipeDAO.loadAllChefRecipe(Session.getCurrentSession().getChefBean());
        } catch (RecipeDaoException e) {
            throw new RecipeDaoException(e.getMessage());
        }
        return recipeBeanList;
    }

    public void confirmCookBook() throws SaveCookBookException {
        CookBook cookBook = new CookBook(Session.getCurrentSession().getCookBookBean());
        CookBookDAO cookBookDAO = new CookBookDAO();
        try {
            cookBookDAO.saveCookBook(cookBook);
        } catch (SaveCookBookException e) {
            throw new SaveCookBookException(e.getMessage());
        }
        Session.getCurrentSession().resetCookBookBean();
        Session.getCurrentSession().resetRecipeBean();
    }

    public void saveCurrentCookBookData(String title, String description) {
        Session.getCurrentSession().getCookBookBean().setAuthor(Session.getCurrentSession().getChefBean());
        Session.getCurrentSession().getCookBookBean().setTitle(title);
        Session.getCurrentSession().getCookBookBean().setDescription(description);
    }

    public List<RecipeBean> takeRecipeFromCookBook(CookBookBean cookBookBean){
        return cookBookBean.getRecipeBeanList();
    }
}
