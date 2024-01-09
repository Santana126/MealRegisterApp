package com.example.mealregisterapp.graphiccontroller;

import com.example.mealregisterapp.SceneManager;
import com.example.mealregisterapp.bean.BeanMeal;
import com.example.mealregisterapp.model.Macro;
import com.example.mealregisterapp.model.MealType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MealPageGraphicController {

    private final SceneManager sceneManager = SceneManager.getInstance(null);

    @FXML
    private TextField textFieldCalories;
    @FXML
    private TextField textFieldCarbs;
    @FXML
    private TextField textFieldFats;
    @FXML
    private TextField textFieldProtein;
    @FXML
    private TextField textFieldDate;
    @FXML
    private ChoiceBox<String> choiceBoxMealType;


    @FXML
    private void handleRegistMeal() throws IOException {
        sceneManager.showFoodListPage();
    }

    @FXML
    private void handleViewMeal() throws IOException {
        sceneManager.showNotImplementedYetOverlay();
    }

    @FXML
    private void handleBackClick(ActionEvent event) throws IOException {
        sceneManager.showHomePage();
    }

    @FXML
    public void handleBackFromRegistPageClick(ActionEvent event) throws IOException {
        sceneManager.showMealPage();
    }

    @FXML
    public void handleSaveMealClick(ActionEvent event) throws IOException {

        BeanMeal.setCalories(Integer.parseInt(String.valueOf(textFieldCalories.getText())));
        Macro macro = new Macro();
        macro.setCarb(Integer.parseInt(String.valueOf(textFieldCarbs.getText())));
        macro.setFat(Integer.parseInt(String.valueOf(textFieldFats.getText())));
        macro.setProtein(Integer.parseInt(String.valueOf(textFieldProtein.getText())));
        BeanMeal.setMacro(macro);
        BeanMeal.setDate(String.valueOf(textFieldDate.getText()));
        switch (choiceBoxMealType.getValue()) {
            case "Colazione" -> BeanMeal.setMealType(MealType.COLAZIONE);
            case "Pranzo" -> BeanMeal.setMealType(MealType.PRANZO);
            case "Cena" -> BeanMeal.setMealType(MealType.CENA);
            case "Spuntino" -> BeanMeal.setMealType(MealType.SPUNTINO);
            default -> showErrorOverlay();
        }
        sceneManager.showMealResumePage();
    }

    private void showErrorOverlay() {
        /*
        Chiama metodo che fa apparire un Overlay di errore
         */
    }
}
