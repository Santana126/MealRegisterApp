module com.example.mealregisterapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mealregisterapp to javafx.fxml;
    exports com.example.mealregisterapp;
}