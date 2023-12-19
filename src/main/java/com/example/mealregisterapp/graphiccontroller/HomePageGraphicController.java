package com.example.mealregisterapp.graphiccontroller;

import com.example.mealregisterapp.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class HomePageGraphicController{


    private final SceneManager sceneManager = SceneManager.getInstance(null);


    @FXML
    private void handleMyAccountClick(ActionEvent event) {
        this.sceneManager.showScene2();
    }


}