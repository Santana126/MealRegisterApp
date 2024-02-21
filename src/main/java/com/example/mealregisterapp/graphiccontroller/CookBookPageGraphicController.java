package com.example.mealregisterapp.graphiccontroller;

import com.example.mealregisterapp.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class CookBookPageGraphicController {

    private final SceneManager sceneManager = SceneManager.getInstance(null);


    @FXML
    public void handleViewCookBooksClick(ActionEvent event) {
        sceneManager.showCookBookListPage();
    }

    @FXML
    public void handleNewCookBookClick(ActionEvent event) throws IOException {
        sceneManager.showNewCookBookPage();
    }

    @FXML
    public void handleViewRecipeClick(ActionEvent event) throws IOException {
        sceneManager.showNotImplementedYetOverlay();
    }

    @FXML
    public void handleHomePageClick(ActionEvent event) throws IOException {
        sceneManager.showChefHomePage();
    }

    @FXML
    public void handleCreateNewRecipeClick(ActionEvent event) throws IOException {
        sceneManager.showNotImplementedYetOverlay();
    }
}
