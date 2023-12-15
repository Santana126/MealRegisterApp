package com.example.mealregisterapp;

import com.example.mealregisterapp.cli_graphic_controller.HomePageControllerCLI;
import com.example.mealregisterapp.utils.Printer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class MainClass extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainClass.class.getResource("homePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Meal Register");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        while (true) {
            Printer.printMessage("Welcome\nChoose the app interface\n1)CLI\n2)Desktop\n");
            Scanner scanner = new Scanner(System.in);
            try {
                int choice = scanner.nextInt();
            while (true){

                if (choice == 1) {
                HomePageControllerCLI homePageControllerCLI = new HomePageControllerCLI();
                homePageControllerCLI.displayHomePage();
            } else if (choice == 2) {
                launch();
            } else {
                Printer.printMessage("Enter a valid number");
                Printer.printMessage("-------------------------------------------------------");
                break;
            }
            }
            } catch (NumberFormatException e) {
                    launch();
                    break;
            }
        }
    }
}