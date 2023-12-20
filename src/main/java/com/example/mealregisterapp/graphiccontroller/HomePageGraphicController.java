package com.example.mealregisterapp.graphiccontroller;

import com.example.mealregisterapp.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class HomePageGraphicController{


    private final SceneManager sceneManager = SceneManager.getInstance(null);


    @FXML
    private void handleMyAccountClick(ActionEvent event) {
        this.sceneManager.showAccountPage();
    }

    @FXML
    private void handleMealPageClick(ActionEvent event) throws IOException {
        this.sceneManager.showMealPage();
    }
    @FXML
    private void handleExitClick(ActionEvent event) throws IOException {
        this.sceneManager.showExitOverlay();
        try {
            sleep(3000);
            System.exit(0);
        } catch (InterruptedException e) {
            System.exit(0);
        }
    }
}