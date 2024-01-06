package com.example.mealregisterapp.graphiccontroller;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class OverlayController {

    private Stage overlayStage;

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

}