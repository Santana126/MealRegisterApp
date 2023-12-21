package com.example.mealregisterapp;

import com.example.mealregisterapp.graphiccontroller.OverlayController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SceneManager {
    private static Stage stage;

    private static SceneManager sceneManager=null;

    public static SceneManager getInstance(Stage newStage){
        if(sceneManager==null){
            sceneManager=new SceneManager();
            stage=newStage;
        }
        return sceneManager;
    }


    public void showHomePage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/mealregisterapp/homePage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public void showAccountPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/mealregisterapp/myAccountPage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    public void showMealPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/mealregisterapp/myAccountPage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public void showExitOverlay() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/mealregisterapp/exitOverlay.fxml"));
        Parent root = loader.load();
        OverlayController controller = loader.getController();
        Stage overlayStage = new Stage(StageStyle.UNDECORATED);
        overlayStage.initModality(Modality.APPLICATION_MODAL);
        overlayStage.initOwner(stage);
        overlayStage.setScene(new Scene(root));
        controller.setOverlayStage(overlayStage);
        overlayStage.showAndWait();
    }
}
