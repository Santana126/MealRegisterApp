package com.example.mealregisterapp.graphiccontroller;

import com.example.mealregisterapp.SceneManager;
import com.example.mealregisterapp.app_controller.LoginController;
import com.example.mealregisterapp.bean.LoginBean;
import com.example.mealregisterapp.exception.EmailFormatException;
import com.example.mealregisterapp.exception.NotFoundException;
import com.example.mealregisterapp.exception.UserNotFoundException;
import com.example.mealregisterapp.session.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.sql.SQLException;

public class LoginGraphicController {

    private final SceneManager sceneManager = SceneManager.getInstance(null);

    @FXML
    private TextField txtFieldEmail;
    @FXML
    private TextField txtFieldPass;
    @FXML
    public void goToSignUp() throws IOException {
        this.sceneManager.showSignupPage();
    }


    public void goToChefSignUp() throws IOException {
        this.sceneManager.showChefSignupPage();
    }

    public void goToUserSignUp() throws IOException {
        this.sceneManager.showUserSignupPage();
    }

    @FXML
    public void login() throws IOException {
        try {
            LoginBean loginBean = new LoginBean(txtFieldEmail.getText(), txtFieldPass.getText());
            LoginController loginController = new LoginController();
            loginController.checkLogin(loginBean);

            if (loginBean.getAccountType() == 1) {
                loginController.completeUserLogin(loginBean);
                sceneManager.showHomePage();
            } else if (loginBean.getAccountType() == 2) {
                loginController.completeChefLogin(loginBean);
                //lunch Chef Page instead of classic home page
                sceneManager.showHomePage();
            } else
                throw new UserNotFoundException();
        } catch (EmailFormatException | UserNotFoundException | NotFoundException | SQLException e) {
            sceneManager.showErrorOverlay(e.getMessage());
        }
    }



    @FXML
    public void notDeveloped() throws IOException {
        this.sceneManager.showNotImplementedYetOverlay();
    }

    @FXML
    public void noLogin(ActionEvent event) {
        //lunch app with no Login as Guest
        Session.setSessionInstance(null);
    }

    @FXML
    public void enterLogin(KeyEvent keyEvent) throws IOException {
        if( keyEvent.getCode() == KeyCode.ENTER ) {
            login();
        }
    }

}
