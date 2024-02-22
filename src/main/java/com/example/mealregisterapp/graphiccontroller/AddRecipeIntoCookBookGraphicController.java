package com.example.mealregisterapp.graphiccontroller;

import com.example.mealregisterapp.SceneManager;
import com.example.mealregisterapp.app_controller.CookBookMakerControllerApp;
import com.example.mealregisterapp.bean.RecipeBean;
import com.example.mealregisterapp.exception.RecipeDaoException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AddRecipeIntoCookBookGraphicController {

    SceneManager sceneManager = SceneManager.getInstance(null);

    private Map<CheckBox, RecipeBean> checkboxEntityMap;

    @FXML
    private ListView<HBox> recipeListView;

    private List<RecipeBean> selectedRecipeList;

    public void initialize() throws IOException {
        recipeListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        List<RecipeBean> recipes = null;
        CookBookMakerControllerApp cookBookMakerControllerApp = new CookBookMakerControllerApp();

        try {
            recipes = cookBookMakerControllerApp.takeRecipeList();
        } catch (RecipeDaoException e) {
            sceneManager.showErrorOverlay(e.getMessage());
        }
        checkboxEntityMap = new HashMap<>();

        // Crea una HBox per ogni entità con una CheckBox
        for (RecipeBean recipeBean : recipes) {
            CheckBox checkBox = new CheckBox();
            checkBox.setText(recipeBean.getName());

            HBox hbox = new HBox(checkBox);
            hbox.setSpacing(10); // Spazio tra CheckBox e testo dell'entità
            recipeListView.getItems().add(hbox);

            // Aggiungi la checkbox e il suo valore alla mappa
            checkboxEntityMap.put(checkBox, recipeBean);
        }
    }

    public void handleInsertRecipeClick(ActionEvent event) throws IOException {

        // Ottieni le ricette selezionate dalla ListView
        ObservableList<HBox> allRecipes = recipeListView.getItems();
        ObservableList<HBox> selectedRecipes = allRecipes.filtered(item -> {
            CheckBox checkBox = (CheckBox) item.getChildren().get(0);
            return checkBox.isSelected();
        });

        selectedRecipeList = new ArrayList<>();

        // Recupera i valori dalle checkbox attraverso la mappa
        int i = 0;
        for (HBox hbox : selectedRecipes) {
            CheckBox checkBox = (CheckBox) hbox.getChildren().get(0);
            RecipeBean recipeBean = checkboxEntityMap.get(checkBox);
            selectedRecipeList.add(i, new RecipeBean());
            selectedRecipeList.get(i).setName(recipeBean.getName());
            selectedRecipeList.get(i).setDescription(recipeBean.getDescription());
            selectedRecipeList.get(i).setRecipeId(recipeBean.getRecipeId());
            i++;
        }

        CookBookMakerControllerApp cookBookMakerControllerApp = new CookBookMakerControllerApp();
        cookBookMakerControllerApp.insertRecipeIntoCookBook(selectedRecipeList);
        sceneManager.showNewCookBookPage();
    }

    public void handleBackButtonClick(ActionEvent event) throws IOException {
        sceneManager.showNewCookBookPage();
    }
}
