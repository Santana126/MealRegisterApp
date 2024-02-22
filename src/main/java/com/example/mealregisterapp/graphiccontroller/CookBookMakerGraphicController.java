package com.example.mealregisterapp.graphiccontroller;

import com.example.mealregisterapp.SceneManager;
import com.example.mealregisterapp.app_controller.CookBookMakerControllerApp;
import com.example.mealregisterapp.exception.SaveCookBookException;
import com.example.mealregisterapp.session.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CookBookMakerGraphicController {
    private final SceneManager sceneManager = SceneManager.getInstance(null);

    @FXML
    public TextField titleField;

    @FXML
    public TextArea descriptionTextArea;



    public void modifyCookBook() {
        //not implemented yet

    }



    public void makeNewRecipe() {
        //not implemented yet

    }

    public void modifyRecipe() {
        //not implemented yet

    }


    public void initialize() {
        if (Session.getCurrentSession().existCookBookBean()) {
            titleField.setText(Session.getCurrentSession().getCookBookBean().getTitle());
            descriptionTextArea.setText(Session.getCurrentSession().getCookBookBean().getDescription());
        }
    }

    public void handleBackButtonClick(ActionEvent event) throws IOException {
        sceneManager.showCookBookPage();
    }

    public void handleViewRecipesClick(ActionEvent event) {
        //not implemented yet
    }

    public void handleConfirmCookBookClick(ActionEvent event) throws IOException {
        saveCurrentCookBook();
        CookBookMakerControllerApp cookBookMakerControllerApp = new CookBookMakerControllerApp();
        try {
            cookBookMakerControllerApp.confirmCookBook();
        } catch (SaveCookBookException e) {
            sceneManager.showErrorOverlay(e.getMessage());
        }
    }

    public void handleInsertRecipeClick(ActionEvent event) throws IOException {
        saveCurrentCookBook();
        //Insert recipe into cookbook
        sceneManager.showRecipeListPage();
    }

    public void handleCookBookResumeClick(ActionEvent event) throws IOException {
        saveCurrentCookBook();
        //View actual cookbook resume
        sceneManager.showCookBookResume();
    }

    public void saveCurrentCookBook(){
        //Save current data into cookbook
        CookBookMakerControllerApp cookBookMakerControllerApp = new CookBookMakerControllerApp();
        cookBookMakerControllerApp.saveCurrentCookBookData(titleField.getText(),descriptionTextArea.getText());

    }
}
