package com.example.mealregisterapp.graphiccontroller;

import com.example.mealregisterapp.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class MealPageGraphicController {

    private final SceneManager sceneManager = SceneManager.getInstance(null);

    @FXML
    private void  handleRegistMeal() throws IOException {
            sceneManager.showRegistMealPage();
    }

    @FXML
    private void handleViewMeal() throws IOException {
            sceneManager.showNotImplementedYetOverlay();
    }

    @FXML
    private void handleBackClick(ActionEvent event) throws IOException {
        sceneManager.showHomePage();
    }

    @FXML
    public void handleBackFromRegistPageClick(ActionEvent event) throws IOException {
        sceneManager.showMealPage();
    }
}
