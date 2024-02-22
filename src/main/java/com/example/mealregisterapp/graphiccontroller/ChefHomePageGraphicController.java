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
        if (Session.getCurrentSession().getChefBean().getUsername() == null){
            String name = Session.getCurrentSession().getChefBean().getName();
            String surname = Session.getCurrentSession().getChefBean().getSurname();
            chefNameText.setText(name + " " + surname);
        }else {
            chefNameText.setText(Session.getCurrentSession().getChefBean().getUsername());
        }
    }

    @FXML
    private void handleMyAccountClick(ActionEvent event) throws IOException {
        this.sceneManager.showAccountPage();
    }




    @FXML
    public void handleCookBookPageClick(ActionEvent event) throws IOException {
        this.sceneManager.showCookBookPage();
    }

    public void handleSettingsClick(ActionEvent event) throws IOException {
        this.sceneManager.showNotImplementedYetOverlay();
    }
}
