package com.example.mealregisterapp.graphiccontroller;

import com.example.mealregisterapp.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class UserHomePageGraphicController {



    private final SceneManager sceneManager = SceneManager.getInstance(null);


    @FXML
    private void handleMyAccountClick(ActionEvent event) throws IOException {
        this.sceneManager.showAccountPage();
    }

    @FXML
    private void handleMealPageClick(ActionEvent event) throws IOException {
        this.sceneManager.showMealPage();
    }


    public void handleCookBookPageClick(ActionEvent event) {

    }

    public void handleSettingsClick(ActionEvent event) {
    }
}
