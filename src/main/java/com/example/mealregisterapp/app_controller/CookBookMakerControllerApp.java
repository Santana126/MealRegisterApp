package com.example.mealregisterapp.app_controller;

import com.example.mealregisterapp.bean.CookBookBean;
import com.example.mealregisterapp.bean.RecipeBean;
import com.example.mealregisterapp.cli_graphic_controller.CookBookMakerControllerCLI;
import com.example.mealregisterapp.dao.CookBookDAO;
import com.example.mealregisterapp.dao.RecipeDAO;
import com.example.mealregisterapp.exception.RecipeDaoException;
import com.example.mealregisterapp.exception.SaveCookBookException;
import com.example.mealregisterapp.model.CookBook;
import com.example.mealregisterapp.session.Session;

import java.util.ArrayList;
import java.util.List;

public class CookBookMakerControllerApp {

    private CookBookBean newCookBookBean;


    public void createNewCookBook() {
        CookBookMakerControllerCLI cookBookMakerControllerCLI = new CookBookMakerControllerCLI(this);
        newCookBookBean = cookBookMakerControllerCLI.createCookBook();

        cookBookMakerControllerCLI.displayCookBookResume(newCookBookBean);
        cookBookMakerControllerCLI.cookBookMenu();
    }

    public void showCookBookResume() {
        CookBookMakerControllerCLI cookBookMakerControllerCLI = new CookBookMakerControllerCLI(this);
        cookBookMakerControllerCLI.displayCookBookResume(newCookBookBean);
    }

    public void viewRecipeOnCookBook() {
        CookBookMakerControllerCLI cookBookMakerControllerCLI = new CookBookMakerControllerCLI(this);
        cookBookMakerControllerCLI.displayCookBookRecipes(newCookBookBean);
    }

    public void insertNewRecipe() {
        CookBookMakerControllerCLI cookBookMakerControllerCLI = new CookBookMakerControllerCLI(this);
        RecipeBean newRecipeBean = cookBookMakerControllerCLI.selectRecipe();
        newCookBookBean.addRecipe(newRecipeBean);
    }

    public void insertRecipeIntoCookBook(List<RecipeBean> selectedRecipeList, CookBookBean cookBookBean) {

        for (RecipeBean recipeBean :
                selectedRecipeList) {
            cookBookBean.addRecipe(recipeBean);
        }


    }

    public List<RecipeBean> takeRecipeList() {
        RecipeDAO recipeDAO = new RecipeDAO();
        List<RecipeBean> recipeBeanList = new ArrayList<>();
        try {
            recipeBeanList = recipeDAO.loadAllChefRecipe(Session.getCurrentSession().getChefBean());
        } catch (RecipeDaoException e) {
            CookBookMakerControllerCLI cookBookMakerControllerCLI = new CookBookMakerControllerCLI(this);
            cookBookMakerControllerCLI.cookBookSaveError(e.getMessage());
        }
        return recipeBeanList;
    }

    public void confirmCookBook() throws SaveCookBookException {
        CookBook cookBook = new CookBook(newCookBookBean);
        CookBookDAO cookBookDAO = new CookBookDAO();
        try {
            cookBookDAO.saveCookBook(cookBook);
        } catch (SaveCookBookException e) {
            throw new SaveCookBookException(e.getMessage());
        }
    }

    public void saveCurrentCookBookData(String title, String description) {
        Session.getCurrentSession().getCookBookBean().setAuthor(Session.getCurrentSession().getChefBean());
        Session.getCurrentSession().getCookBookBean().setTitle(title);
        Session.getCurrentSession().getCookBookBean().setDescription(description);
    }
}
