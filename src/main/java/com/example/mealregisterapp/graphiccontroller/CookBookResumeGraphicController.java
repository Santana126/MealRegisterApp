package com.example.mealregisterapp.graphiccontroller;

import com.example.mealregisterapp.SceneManager;
import com.example.mealregisterapp.bean.CookBookBean;
import com.example.mealregisterapp.bean.RecipeBean;
import com.example.mealregisterapp.session.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.List;

public class CookBookResumeGraphicController {
    private final SceneManager sceneManager = SceneManager.getInstance(null);
    @FXML
    public Label titleField;
    @FXML
    public Label authorField;
    @FXML
    public Label descriptionField;


    @FXML
    private ListView<HBox> recipeListView;

    public void initialize() {

        List<RecipeBean> recipeBeanList = Session.getCurrentSession().getCookBookBean().getRecipeBeanList();

        // Crea una HBox per ogni entità con una CheckBox
        for (RecipeBean recipeBean : recipeBeanList) {

            Label label = new Label();
            label.setText(recipeBean.getName());
            HBox hbox = new HBox(label);
            hbox.setSpacing(10); // Spazio tra CheckBox e testo dell'entità


            recipeListView.getItems().add(hbox);

        }

        CookBookBean cookBookBean = Session.getCurrentSession().getCookBookBean();

        titleField.setText(cookBookBean.getTitle());
        descriptionField.setText(cookBookBean.getDescription());
        authorField.setText(cookBookBean.getAuthor().getName() + " " + cookBookBean.getAuthor().getSurname());


    }

    public void handleBackButtonClick(ActionEvent event) throws IOException {
        sceneManager.showNewCookBookPage();
    }
}
