package com.example.mealregisterapp.graphiccontroller;

import com.example.mealregisterapp.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AccountPageGraphicController {

    private final SceneManager sceneManager = SceneManager.getInstance(null);

    @FXML
    private void handleHomePageClick(ActionEvent event) {
        this.sceneManager.showHomePage();
    }


}
