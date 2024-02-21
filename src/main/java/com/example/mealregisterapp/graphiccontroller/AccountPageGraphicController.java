package com.example.mealregisterapp.graphiccontroller;

import com.example.mealregisterapp.SceneManager;
import com.example.mealregisterapp.session.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AccountPageGraphicController implements Initializable {

    private final SceneManager sceneManager = SceneManager.getInstance(null);

    @FXML
    private Label usernameLabel;
    @FXML
    private Label usernameField;
    @FXML
    private Label nameLabel;
    @FXML
    private Label nameField;
    @FXML
    private Label surnameLabel;
    @FXML
    private Label surnameField;
    @FXML
    private Label emailLabel;
    @FXML
    private Label emailField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (Session.getCurrentSession().getType() == 1) {
            //User
            surnameField.setVisible(false);
            surnameLabel.setVisible(false);

            usernameField.setText(Session.getCurrentSession().getUserBean().getUsername());
            emailField.setText(Session.getCurrentSession().getUserBean().getEmail());
        } else {
            //Chef
            usernameField.setVisible(false);
            usernameLabel.setVisible(false);

            nameField.setText(Session.getCurrentSession().getChefBean().getName());
            surnameField.setText(Session.getCurrentSession().getChefBean().getSurname());
            emailField.setText(Session.getCurrentSession().getChefBean().getEmail());
        }

    }

    @FXML
    private void handleHomePageClick(ActionEvent event) throws IOException {
        if (Session.getCurrentSession().getType() == 1) {
            //User
            this.sceneManager.showUserHomePage();
        } else {
            //Chef
            this.sceneManager.showChefHomePage();
        }
    }


}
