package com.example.mealregisterapp.graphiccontroller;

import com.example.mealregisterapp.bean.BeanMeal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MealResumeGraphicController implements Initializable {


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


    @FXML
    public void handleConfirmResume(ActionEvent event) {

    }

    @FXML
    public void closeMealResumePage(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textResumeCalories.setText(String.valueOf(BeanMeal.getCalories()));
        textResumeCarbs.setText(String.valueOf(BeanMeal.getMacro().getCarb()));
        textResumeFats.setText(String.valueOf(BeanMeal.getMacro().getFat()));
        textResumeProtein.setText(String.valueOf(BeanMeal.getMacro().getProtein()));
        textResumeDate.setText(String.valueOf(BeanMeal.getDate()));
        textResumeMealType.setText(BeanMeal.getMealTypeString());
    }
}
