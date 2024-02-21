package com.example.mealregisterapp.graphiccontroller;

import com.example.mealregisterapp.SceneManager;
import com.example.mealregisterapp.session.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChefHomePageGraphicController implements Initializable {

    private final SceneManager sceneManager = SceneManager.getInstance(null);

    @FXML
    private Text chefNameText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chefNameText.setText(Session.getCurrentSession().getChefBean().getName());
    }

    @FXML
    private void handleMyAccountClick(ActionEvent event) throws IOException {
        this.sceneManager.showAccountPage();
    }


    @FXML
    private void handleExitClick(ActionEvent event) throws IOException {
        this.sceneManager.showExitOverlay();
    }

    protected static void exitConfirmed() {
        System.exit(1);
    }


    @FXML
    public void handleCookBookPageClick(ActionEvent event) throws IOException {
        this.sceneManager.showCookBookPage();
    }
}
