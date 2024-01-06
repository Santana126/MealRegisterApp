package com.example.mealregisterapp.graphiccontroller;

import com.example.mealregisterapp.SceneManager;
import com.example.mealregisterapp.app_controller.MealRegisterController;
import com.example.mealregisterapp.bean.BeanMeal;
import com.example.mealregisterapp.exception.SaveMealException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MealResumeGraphicController implements Initializable {

    private final SceneManager sceneManager = SceneManager.getInstance(null);

    @FXML
    public Label textResumeCalories;
    @FXML
    public Label textResumeCarbs;
    @FXML
    public Label textResumeFats;
    @FXML
    public Label textResumeProtein;
    @FXML
    public Label textResumeDate;
    @FXML
    public Label textResumeMealType;

    private MealRegisterController mealRegisterController;


    @FXML
    public void handleConfirmResume(ActionEvent event) throws SQLException, SaveMealException, IOException {
        mealRegisterController.saveMeal();
        sceneManager.showHomePage();
    }

    @FXML
    public void closeMealResumePage(ActionEvent event) throws IOException {
        sceneManager.showRegistMealPage();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mealRegisterController = new MealRegisterController();
        textResumeCalories.setText(String.valueOf(BeanMeal.getCalories()));
        textResumeCarbs.setText(String.valueOf(BeanMeal.getMacro().getCarb()));
        textResumeFats.setText(String.valueOf(BeanMeal.getMacro().getFat()));
        textResumeProtein.setText(String.valueOf(BeanMeal.getMacro().getProtein()));
        textResumeDate.setText(String.valueOf(BeanMeal.getDate()));
        textResumeMealType.setText(BeanMeal.getMealTypeString());
    }
}
