package com.example.mealregisterapp.graphiccontroller;

import com.example.mealregisterapp.SceneManager;
import com.example.mealregisterapp.bean.BeanMeal;
import com.example.mealregisterapp.model.Macro;
import com.example.mealregisterapp.model.MealType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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

    private final BeanMeal beanMeal = new BeanMeal();

    @FXML
    private Text textResumeCalories;

    @FXML
    private Text textResumeCarbs;
    @FXML
    private Text textResumeFats;
    @FXML
    private Text textResumeProtein;
    @FXML
    private Text textResumeDate;
    @FXML
    private Text textResumeMealType;


    @FXML
    private void handleRegistMeal() throws IOException {
        sceneManager.showRegistMealPage();
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
        beanMeal.setCalories(Integer.parseInt(String.valueOf(this.textFieldCalories)));
        Macro macro = new Macro();
        macro.setCarb(Integer.parseInt(String.valueOf(textFieldCarbs)));
        macro.setFat(Integer.parseInt(String.valueOf(textFieldFats)));
        macro.setProtein(Integer.parseInt(String.valueOf(textFieldProtein)));
        beanMeal.setMacro(macro);
        beanMeal.setDate(String.valueOf(textFieldDate));
        switch (choiceBoxMealType.getValue()) {
            case "Colazione" -> beanMeal.setMealType(MealType.COLAZIONE);
            case "Pranzo" -> beanMeal.setMealType(MealType.PRANZO);
            case "Cena" -> beanMeal.setMealType(MealType.CENA);
            case "Spuntino" -> beanMeal.setMealType(MealType.SPUNTINO);
            default -> showErrorOverlay();
        }
        showMealResume();
    }

    private void showMealResume() throws IOException {
        textResumeDate.setText(beanMeal.getDate());
        textResumeMealType.setText(beanMeal.getMealTypeString());
        textResumeCalories.setText(String.valueOf(beanMeal.getCalories()));
        textResumeCarbs.setText(String.valueOf(beanMeal.getMacro().getCarb()));
        textResumeFats.setText(String.valueOf(beanMeal.getMacro().getFat()));
        textResumeProtein.setText(String.valueOf(beanMeal.getMacro().getProtein()));

        sceneManager.showMealResumeOverlay();
    }

    private void showErrorOverlay() {

    }

    @FXML
    public void handleConfirmResumeOverlay(ActionEvent event) throws IOException {
        sceneManager.showMealPage();
    }

    @FXML
    public void handleModifyResumeOverlay(ActionEvent event) throws IOException {
        sceneManager.showRegistMealPage();
    }
}
