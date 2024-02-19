package com.example.mealregisterapp.graphiccontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class OverlayController {

    private Stage overlayStage;

    @FXML
    public Label errorMessage;


    public void setOverlayStage(Stage overlayStage) {
        this.overlayStage = overlayStage;
    }

    @FXML
    private void closeExitOverlay() {
        overlayStage.close();
        HomePageGraphicController.exitConfirmed();
    }

    @FXML
    private void closeSimpleOverlay(){
        overlayStage.close();
    }

    public void setErrorMessage(String errorMessage){
        this.errorMessage.setText(errorMessage);
    }

}