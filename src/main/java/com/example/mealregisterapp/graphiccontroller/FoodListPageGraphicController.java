package com.example.mealregisterapp.graphiccontroller;

import com.example.mealregisterapp.SceneManager;
import com.example.mealregisterapp.app_controller.MealRegisterController;
import com.example.mealregisterapp.bean.BeanFood;
import com.example.mealregisterapp.exception.SaveMealException;
import com.example.mealregisterapp.model.MealType;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodListPageGraphicController {

    SceneManager sceneManager = SceneManager.getInstance(null);
    MealRegisterController mealRegisterController = new MealRegisterController();

    // Mappa per tenere traccia delle checkbox e dei corrispondenti valori
    private Map<CheckBox, String> checkboxEntityMap;

    @FXML
    private ListView<HBox> foodListView;

    @FXML
    private TextField dateTextField;

    @FXML
    private ChoiceBox<String> choiceBoxMealType;

    private List<BeanFood> selectedFoodList;

    public FoodListPageGraphicController() {
        //Empty, need to throw Exception
    }

    public void initialize() throws SQLException {
        foodListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        List<String> entities = mealRegisterController.loadAvailableFood();
        checkboxEntityMap = new HashMap<>();

        // Crea una HBox per ogni entità con una CheckBox
        for (String entity : entities) {
            CheckBox checkBox = new CheckBox();
            checkBox.setText(entity);

            HBox hbox = new HBox(checkBox);
            hbox.setSpacing(10); // Spazio tra CheckBox e testo dell'entità
            foodListView.getItems().add(hbox);

            // Aggiungi la checkbox e il suo valore alla mappa
            checkboxEntityMap.put(checkBox, entity);
        }
    }

    @FXML
    public void handleBackClick(ActionEvent event) throws IOException {
        sceneManager.showMealPage();
    }

    @FXML
    public void handleConfirmFood(ActionEvent event) throws SQLException, SaveMealException {
        // Ottieni gli elementi selezionati dalla ListView
        ObservableList<HBox> allItems = foodListView.getItems();
        ObservableList<HBox> selectedItems = allItems.filtered(item -> {
            CheckBox checkBox = (CheckBox) item.getChildren().get(0);
            return checkBox.isSelected();
        });

        selectedFoodList = new ArrayList<>();

        // Recupera i valori dalle checkbox attraverso la mappa
        int index = 0;
        for (HBox hbox : selectedItems) {
            CheckBox checkBox = (CheckBox) hbox.getChildren().get(0);
            String entity = checkboxEntityMap.get(checkBox);
            selectedFoodList.add(index, new BeanFood());
            selectedFoodList.get(index).setName(entity);
            index++;
        }

        MealType mealType = null;

        switch (choiceBoxMealType.getValue()) {
            case "Colazione" -> mealType = MealType.COLAZIONE;
            case "Pranzo" -> mealType = MealType.PRANZO;
            case "Cena" -> mealType = MealType.CENA;
            case "Spuntino" -> mealType = MealType.SPUNTINO;
            default -> showErrorOverlay();
        }
        MealRegisterController mealRegisterController = new MealRegisterController();
        mealRegisterController.createMeal(dateTextField.getText(), mealType);
        mealRegisterController.addFoodToMeal(selectedFoodList);
        mealRegisterController.mealResume();
        mealRegisterController.mealResumeConfirmed();

    }

    private void showErrorOverlay() {
        /*
        Chiama metodo che fa apparire un Overlay di errore
         */
    }
}
