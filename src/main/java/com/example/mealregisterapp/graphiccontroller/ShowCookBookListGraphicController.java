package com.example.mealregisterapp.graphiccontroller;

import com.example.mealregisterapp.SceneManager;
import com.example.mealregisterapp.app_controller.CookBookSellingController;
import com.example.mealregisterapp.bean.CookBookBean;
import com.example.mealregisterapp.exception.LoadCookBookException;
import com.example.mealregisterapp.exception.UpdateCookBookStatusException;
import com.example.mealregisterapp.session.Session;
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

public class ShowCookBookListGraphicController {

    private final SceneManager sceneManager = SceneManager.getInstance(null);

    private Map<CheckBox, CookBookBean> checkboxEntityMap;

    @FXML
    private ListView<HBox> cookbookListView;

    private List<CookBookBean> selectedCookBookBean;

    public void initialize() throws IOException {
        cookbookListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        List<CookBookBean> cookBookBeanList = null;
        CookBookSellingController cookBookSellingController = new CookBookSellingController();

        try {
            cookBookBeanList = cookBookSellingController.takeCookBookList(Session.getCurrentSession().getChefBean());
        } catch (LoadCookBookException e) {
            sceneManager.showErrorOverlay("Loading cookbooks failed: " + e.getMessage());
        }
        checkboxEntityMap = new HashMap<>();

        // Crea una HBox per ogni entità con una CheckBox
        for (CookBookBean cookBookBean : cookBookBeanList) {
            CheckBox checkBox = new CheckBox();
            checkBox.setText("Title: " + cookBookBean.getTitle() + " Description: " + cookBookBean.getDescription());

            HBox hbox = new HBox(checkBox);
            hbox.setSpacing(10); // Spazio tra CheckBox e testo dell'entità
            cookbookListView.getItems().add(hbox);

            // Aggiungi la checkbox e il suo valore alla mappa
            checkboxEntityMap.put(checkBox, cookBookBean);
        }
    }

    public void handleSellCookBookClick(ActionEvent event) throws IOException {

        // Ottieni le ricette selezionate dalla ListView
        ObservableList<HBox> allCookbooks = cookbookListView.getItems();
        dummy();
        ObservableList<HBox> selectedCookbooks = allCookbooks.filtered(item -> {
            CheckBox checkBox = (CheckBox) item.getChildren().get(0);
            return checkBox.isSelected();
        });

        selectedCookBookBean = new ArrayList<>();

        CookBookSellingController cookBookSellingController = new CookBookSellingController();
        try {
            List<CookBookBean> cookBookBeanList = cookBookSellingController.takeCookBookList(Session.getCurrentSession().getChefBean());

            // Recupera i valori dalle checkbox attraverso la mappa
            int i = 1;
            for (HBox hbox : selectedCookbooks) {
                CheckBox checkBox = (CheckBox) hbox.getChildren().get(0);
                CookBookBean cookBookBean = checkboxEntityMap.get(checkBox);
                cookBookSellingController.sellCookBookToUser(cookBookBeanList,i);
                i++;

            }
        } catch (LoadCookBookException | UpdateCookBookStatusException e) {
            sceneManager.showErrorOverlay(e.getMessage());
        }
        sceneManager.showChefHomePage();
    }

    private void dummy() {
        //do nothing
    }

    public void handleBackButtonClick(ActionEvent event) throws IOException {
        sceneManager.showCookBookPage();
    }

}
