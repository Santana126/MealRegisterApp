module com.example.mealregisterapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.mealregisterapp to javafx.fxml;
    exports com.example.mealregisterapp;
    opens com.example.mealregisterapp.graphiccontroller to javafx.fxml;
    exports com.example.mealregisterapp.graphiccontroller;
}
